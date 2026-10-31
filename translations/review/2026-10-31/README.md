# 2026-10-31 — v27.0.1 beta 7 incremental update

Scope: the 56 entries that changed in the app catalogue since the beta 5 sync (54 new keys, 2 changed English values: `settings.composer_buttons_settings.summary`, `app_icon.info.delay`). Every other entry was left as it was.

Process (three roles):
- Lead audit: diff of the app's `en.json` against `source/en.json`; plurals unchanged; no obsolete keys.
- Translation: the 56 entries for the 43 distinct locales, reusing each catalogue's existing terms (`common.later`, `hidden.hide`, launcher term, feed names). Identity copies (zh-Hans-CN, zh-Hant-HK, zh-Hant-TW, sr-Cyrl-RS, fil-PH) take their base locale's values.
- Independent QA on all 43 locales: 0 critical, 0 high, about 45 medium and 10 low findings; 71 values corrected in 24 locales (Following feed name, launcher term, Chinese feed/emoji-pack terms, call-button summaries, grammar). Low findings left are style only.

Checks: `tools/Translations.ps1 -Command validate` passed 50/50; `en`, `pt-PT` and `context.json` copied from the app catalogues. Revisions: locales 4, en/pt-PT 6. Packs and `index.json` prepared with `prepare` (defaults as in the previous index).
