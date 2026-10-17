#!/usr/bin/env python3
"""Report exact entries whose recorded translation review is stale (Python 3.8+)."""
import argparse
import hashlib
import json
from pathlib import Path


def read(path):
    return json.loads(path.read_text(encoding="utf-8-sig"))


def digest(value):
    data = json.dumps(value, ensure_ascii=False, sort_keys=True, separators=(",", ":"))
    return hashlib.sha256(data.encode("utf-8")).hexdigest()


def compare(repository, state):
    source = read(repository / "translations/source/en.json")
    context = read(repository / "translations/source/context.json")["entries"]
    current = {key: (kind, value) for kind in ("strings", "plurals")
               for key, value in source[kind].items()}
    old = state["sourceEntries"]
    changed = {key for key in current.keys() | old.keys()
               if key not in current or key not in old
               or old[key]["kind"] != current[key][0]
               or old[key]["textSha256"] != digest(current[key][1])
               or old[key]["contextSha256"] != digest(context.get(key))}
    locales = {}
    for locale, record in sorted(state["locales"].items()):
        path = repository / "translations/source" / (locale + ".json")
        target = read(path) if path.exists() else {"strings": {}, "plurals": {}}
        target_values = {key: value for kind in ("strings", "plurals")
                         for key, value in target[kind].items()}
        target_changed = {key for key, item in record["entries"].items()
                          if key not in target_values
                          or item["targetSha256"] != digest(target_values[key])}
        unrecorded = target_values.keys() - record["entries"].keys()
        affected = changed | target_changed | unrecorded
        if affected:
            locales[locale] = {
                "reviewRequiredKeys": sorted(affected),
                "sourceOrContextChanged": sorted(changed),
                "translationChanged": sorted(target_changed | unrecorded),
            }
    return {"sourceOrContextChangedKeys": sorted(changed),
            "affectedLocales": locales, "affectedLocaleCount": len(locales),
            "reviewRequiredEntryCount": sum(len(r["reviewRequiredKeys"]) for r in locales.values())}


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--repository", type=Path,
                        default=Path(__file__).resolve().parents[2])
    parser.add_argument("--state", type=Path)
    args = parser.parse_args()
    state_path = args.state or args.repository / "translations/review/2026-10-17/review-state.json"
    result = compare(args.repository, read(state_path))
    print(json.dumps(result, ensure_ascii=False, indent=2))
    return 2 if result["affectedLocales"] else 0


if __name__ == "__main__":
    raise SystemExit(main())
