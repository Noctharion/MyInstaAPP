# Contribute a MyInsta translation

Everything needed is in this public repository. PowerShell and Java 11+ (`java` and `javac`) run the existing export/validate/prepare tool. Android tools and private-source access are unnecessary. An optional Python 3.8+ checker maintains per-entry review evidence.

## Translate and review

[source/en.json](source/en.json) is canonical: **1,688 strings and 18 plurals, 1,706 entries**. The existing 45 primary authoring catalogues and five documented system identity variants are complete at source revision **2**. English and pt-PT are bundled for offline first use; other locales use downloaded packs. The immutable delivery packs and index remain unchanged at revision **1**, with **1,598 entries**, pending later preparation of the new source. Missing new keys in an older downloaded pack use English fallback. [The delivery record](review/2026-10-17/README.md) describes the earlier delivery; its review flags do not certify the new delta. Technical coverage, AI review, human review and Android acceptance remain separate.

Export a fresh template:

```powershell
./translations/tools/Translations.ps1 -Command export -Locale es -Output ./translation-es
```

Translate `translation-es/template.json` in UTF-8. Use the intended BCP 47 `locale`, stable keys and existing named arguments such as `{name}` and `{count}`. Translate values inside `strings` and `plurals`; preserve brands, URLs, identities and technical values. Move arguments for natural grammar without changing their meaning or required occurrences. Do not add HTML, Markdown or ICU MessageFormat syntax. Public context explains surfaces/arguments, while the [functional glossary](review/2026-10-17/FUNCTIONAL-GLOSSARY.md) records exceptions and consumer-specific meaning. In particular, the name in conversation cleanup is the conversation title, including groups.

Maintain consistent terms using the [recorded locale conventions](review/2026-10-17/LOCALE-CONVENTIONS.md). Existing contributor attribution is preserved. Do not attribute newly AI-authored wording to earlier contributors or claim native-speaker approval without evidence. Review titles, summaries, actions and failures together; preserve eligibility, successful-send conditions, receipt/media exceptions and import conflict priorities.

Plurals support `zero`, `one`, `two`, `few`, `many` and `other`; **other is mandatory**, and every form preserves the required arguments. Use categories appropriate to the target and the consumer's integer count domain, consulting [Unicode CLDR rules](https://unicode.org/cldr/charts/48/supplemental/language_plural_rules.html). Android ICU chooses according to the text entry's language; English fallback uses English grammar. Numbers/dates retain the effective interface locale. Host ICU fixtures do not establish the ICU version or rendering behavior on an Android device.

Validate with the real strict parser:

```powershell
./translations/tools/Translations.ps1 -Command validate -File ./translation-es/template.json
```

Validation rejects malformed UTF-8/JSON, duplicate keys, unsupported schema/catalogue, missing `other` and incompatible placeholders. It reports key coverage, not language quality. Partial extra languages may omit untranslated entries and fall back to English; an omitted entry is not translated coverage. Never fill missing entries with empty text or copied English prose. The current authoring key set is complete for the existing target locales; the unchanged revision-1 downloadable packs predate the new source entries.

## Prepare a contribution

Save the authoring file as `translations/source/<locale>.json`. Future corrections increase the positive integer `revision`, independently of the APK version. Prepare into a separate local Git repository for review before integrating the resulting pack/index:

```powershell
./translations/tools/Translations.ps1 -Command prepare -File ./translations/source/es.json -Repository ../language-staging -Default
```

The destination must already be a Git repository. Omit `-Repository` to prepare in the current public checkout. `-Default` deliberately selects a fallback for the locale's language/script family; do not apply it indiscriminately. Exact locales take priority. pt-BR and pt-PT stay separate, with pt-PT as `pt` default. Chinese CN/HK/TW remain separate, with distinct Hans/Hant defaults and no broad `zh` default. Explicit Serbian Cyrillic and modern Filipino identities have compatible packs. [The manifest](review/2026-10-17/locale-manifest.json) and [sharing decisions](review/2026-10-17/variant-sharing.json) document the bounded aliases and unconfigured-script fallback.

Preparation validates, LF-normalizes physical JSON line endings, computes byte size/SHA-256, writes an immutable `packs/<locale>/<revision>-<hash>.json` path and atomically updates `index.json`. Escaped line breaks inside values are preserved. Same-revision changed content is rejected. Never put new bytes under an existing immutable path.

The owner requested a one-time revision reset and retirement of previous pack files for clean-install v27.0.1. This checkout therefore contains one current runtime pack per locale at revision 1. Retired paths can no longer satisfy old cached indexes; failures preserve a previous valid cache or offline fallback. A higher-revision development cache requires the owner's clean-install/reset path. The normal monotonic-revision and integrity checks remain enabled; future changes use new revisions and consider cached-index compatibility before retiring paths.

Review the authoring JSON, pack and index together before committing. Contributors without write access can submit a public pull request; maintainers merge/push to publish. Pack changes for existing keys require no APK rebuild. A new key or changed consumer needs the corresponding app source/build change.

## Track review and test the interface

The external [review state](review/2026-10-17/review-state.json) records per-entry source/context/translation hashes and AI review flags. This optional command identifies the exact approvals made stale by an edit:

```powershell
python ./translations/tools/Review-State.py
```

Review affected entries before refreshing records. Hash equality preserves recorded evidence; it is not proof of correctness. The coverage table distinguishes same-agent and independent AI passes. Human and Android visual acceptance must be recorded only when performed.

Report community findings with locale, key, source/context, current translation, meaning at risk, suggested correction and any real screenshot/runtime evidence. Use the [Android matrix](review/2026-10-17/ANDROID-MATRIX.md) for long text, RTL, mixed scripts/names, 360/412 dp widths, enlarged fonts, themes, notifications and custom-font glyph/shaping checks. JSON pseudolocales are technical fixtures and are never distributed as real languages.

## App behavior

The app follows Instagram's chosen language, including Follow system; there is no separate MyInsta selector. Only needed packs download over the fixed public HTTPS source. The index is checked at most daily with ETag. Index/pack limits remain 256 KiB/1 MiB with 10-second connect/read timeouts. Schema, identity, size, SHA-256 and known arguments must validate before atomic caching. Failures preserve the last valid cache. New translations apply to newly opened surfaces, preserving existing dialogs and edits.

Keys in `myinsta-ui-v1` retain meaning and arguments; incompatible meanings need new keys. Preference IDs, user messages, theme names, account names, stored values and protocols are not translation targets. APK artifacts and the public update feed are separate from language packs.
