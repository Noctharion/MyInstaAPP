# MyInsta language packs

These packs localize MyInsta's own interface from v27.0.1 onward. The app follows Instagram's chosen language. English and European Portuguese are included in the APK for offline first use; corrections and additional languages can be published here without rebuilding the APK.

The current catalogue contains 1,567 entries: 1,549 strings and 18 plurals. English (`en`) and European Portuguese (`pt-PT`) cover all entries, including the reorganized settings, grid/list presentation, developer support panel and separate MyInsta backup/Instagram DevFlags import guidance. Brazilian Portuguese (`pt-BR`), Spanish (`es`), German (`de`) and French (`fr`) currently retain 1,415 translated entries each (90.3%); the 152 entries missing from these packs use English fallback. Existing translated wording is retained while contributors review the updated settings and font screens. These four languages are downloaded when needed and then remain available from the local cache.

Start with [contribute/template.json](contribute/template.json) and [contribute/context.json](contribute/context.json). The template contains English source text. Change its `locale`, translate string/plural values, and preserve stable keys and named placeholders. Every plural needs `other`. Partial additional languages are supported; missing entries fall back to English. The exact Brazilian Portuguese pack takes precedence for `pt-BR`; `pt-PT` remains the default for other Portuguese variants without an exact pack.

Use this public checkout's [tools/Translations.ps1](tools/Translations.ps1) to export, validate and prepare a pack. Java 11+ and PowerShell are enough. The [contribution/publication guide](CONTRIBUTING.md) and [public wiki](https://github.com/Noctharion/MyInstaAPP/wiki/Translations) have the commands and compatibility rules; access to the private app source is unnecessary.

The preparation command computes byte size and SHA-256, writes an immutable `packs/<locale>/<revision>-<hash>.json` path and updates [index.json](index.json). Increment the revision before editing a published pack. Commit and push this directory to publish; keep old immutable packs. Script variants such as `zh-Hans` and `zh-Hant` use separate defaults.

Only necessary packs are downloaded over HTTPS. The app checks the index at most daily, validates downloads and keeps its last valid cache on failures. An update applies to the next surface opened, preserving dialogs and edits already in progress.

The v27.0.0 release artifacts and public APK update metadata are maintained separately.
