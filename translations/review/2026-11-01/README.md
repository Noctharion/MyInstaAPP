# 2026-11-01 — settings reorganization (incremental)

Scope: the delta between the app catalogue and `source/en.json`: 74 new keys, 45 changed English values, 105 removed keys (settings reorganization, Fonts/Emoji split, whole-app protection, removed edit history, plus the like-animation and active-status strings committed since beta 7). Every other entry was left as it was.

Process (three roles):
- Lead audit: diff of the app `en.json` against `source/en.json` (plurals unchanged); all 48 locales aligned with the public English before the update.
- Translation: the 119 new/changed entries for the 43 distinct locales in four parallel groups, reusing each catalogue's existing terms; identity copies (zh-Hans-CN, zh-Hant-HK, zh-Hant-TW, sr-Cyrl-RS, fil-PH) take their base locale's values. Removed keys deleted everywhere.
- Independent QA on all 43 locales: 0 critical, 4 high, 38 medium findings; 48 values corrected in 29 locales (see QA.md). About 20 low findings left (style).

Checks: `tools/Translations.ps1 -Command validate` passed 50/50; key sets, placeholders and newline counts match English in every file. `en`, `pt-PT`, `context.json` and `contribute/` copied from the app catalogues. Revisions: locales 5, en/pt-PT 7. Packs and `index.json` prepared with `prepare` (defaults unchanged).
