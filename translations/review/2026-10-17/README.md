# Translation delivery and review — 2026-10-17

This delivery contains 45 complete primary catalogues, including English, and five identical-text system identity variants. Each has 1,598 entries and revision 1. The [coverage table](COVERAGE.md) separates filled entries, missing-English fallback, current AI review evidence, strict validation and unperformed human/Android checks. Pack identities and hashes are in the runtime index. Old revision files were removed at the owner's request, with no history rewrite; no APK release or OTA metadata change is part of this delivery.

The translations use one frozen English/context checkpoint, originally source revision 14. Final delivery metadata resets the revision to 1 without changing the frozen English text or parsed context. Physical context line endings are normalized to LF for Git publication. [source-checkpoint.json](source-checkpoint.json) records both hashes, the metadata-only English reset and this context normalization. A source/context meaning change must invalidate review only for the affected keys.

Every translated entry received a separate saved-catalogue semantic pass. The author and independent-review counts in the table describe exact matching entries: a later correction can replace an author's reviewed value while retaining the independent review of the correction. All 596 entries in [critical-keys.json](critical-keys.json) received independent AI review in every non-English primary locale. That is a broad critical worklist, not a claim that every consumer was formally classified. Additional targeted descriptions, including generic Instants screen capture and Glass input controls, were reviewed. Some existing catalogues received a complete independent pass; the per-locale counts show which. Independent critical review is not a second complete review of every locale.

No human/native-speaker review, Android installation, UI screenshot, visual layout, glyph coverage, shaping or custom-font acceptance was performed. The owner deferred language acceptance to v27.0.1 users. Host formatting, plural fixtures and JSON expansion/RTL pseudolocales are technical checks and do not establish Android rendering quality. See [verification results](VERIFICATION.md) and the [Android acceptance matrix](ANDROID-MATRIX.md).

## Public maintenance record

[review-state.json](review-state.json) stores source text/context hashes once and per-entry translation hashes and AI review flags for each locale, outside runtime schemas. Identical system identities explicitly inherit review from their corresponding reviewed primary catalogue; they are not counted as additional translated languages. `humanReview` and `androidVisualReview` at the record root apply to every entry.

Hashes use SHA-256 over JSON values serialized as UTF-8, unescaped Unicode, sorted object keys and compact separators. They track meaning-bearing values independently of physical line endings and revision metadata. Run the optional Python 3.8+ checker after edits:

```powershell
python ./translations/tools/Review-State.py
python -m unittest discover -s ./translations/tools/tests -v
```

The checker returns exit 0 when recorded values still match, or exit 2 with exact changed source/context and target keys. A matching hash preserves evidence of a recorded review; it does not prove linguistic correctness. Do not regenerate approval flags merely to clear a changed-key report: review the changed meaning first. Use the existing strict validator separately.

## Community review without private-source access

Use `source/en.json`, `source/<locale>.json` and `contribute/context.json`. A report should give the locale and pack revision/hash, exact key and translated text, relevant English/context, the meaning at risk, suggested wording and whether the evidence is a language review, runtime observation or an actual Android screenshot.

Preserve placeholders, URLs, brands, schema and product behavior. [FUNCTIONAL-GLOSSARY.md](FUNCTIONAL-GLOSSARY.md) records the functional constraints, and [LOCALE-CONVENTIONS.md](LOCALE-CONVENTIONS.md) records the actual delivered terms. Previous attribution remains intact; new AI wording is not attributed to earlier human contributors. No contributor messages or review requests were sent by this task.
