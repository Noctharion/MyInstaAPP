# Contribute a MyInsta translation

Everything needed by a translator is in this **public MyInstaAPP repository**. Download or clone it, install a JDK 11 or newer (with `java` and `javac` on PATH), and use PowerShell. Android tools and access to MyInsta's private source are unnecessary.

## Translate

The complete English catalogue is [source/en.json](source/en.json). Complete translations are published for [European Portuguese](source/pt-PT.json), [Brazilian Portuguese](source/pt-BR.json), [Spanish](source/es.json), [German](source/de.json) and [French](source/fr.json), with 1,322 entries each. English and European Portuguese are bundled in the APK; the other four are downloaded when needed. The [template](contribute/template.json) and [context](contribute/context.json) are ready to download, or export a new template:

```powershell
./translations/tools/Translations.ps1 -Command export -Locale es -Output ./translation-es
```

Edit `translation-es/template.json` in a UTF-8 editor. Set `locale` to the intended BCP 47 tag, such as `es`, `pt-BR`, `zh-Hans` or `zh-Hant`. Translate values inside `strings` and `plurals`; preserve keys and named placeholders such as `{folder}`, `{username}` and `{count}`. Move placeholders to fit the sentence. Preserve brands and proper names. The context file explains each surface and argument; implementation filenames are descriptive references to the private source and require no translator access.

Plural forms accept `zero`, `one`, `two`, `few`, `many` and `other`; **other is mandatory**, and every form preserves the same arguments including `{count}`. Android ICU selects a form using the entry's language. English fallback entries use English rules. Display numbers/dates follow Instagram's effective language. See [Android plural rules](https://developer.android.com/reference/android/icu/text/PluralRules).

Additional languages can omit untranslated entries. Missing entries use English; delete an untranslated entry rather than making its value empty. English and pt-PT are complete bundled catalogues. Validate a candidate:

```powershell
./translations/tools/Translations.ps1 -Command validate -File ./translation-es/template.json
```

Validation reports coverage and rejects duplicate keys, malformed UTF-8/JSON, unsupported schema/catalogue, missing plural `other` and altered placeholders. The distributed validator follows the application's validation contract. Older clients ignore newer unknown keys.

## Prepare a contribution

Save the translated authoring file under `translations/source/<locale>.json`. Increase its positive integer `revision` when correcting an already published locale. Revisions are independent of the app version.

```powershell
./translations/tools/Translations.ps1 -Command prepare -File ./translations/source/es.json -Default
```

`-Default` makes the locale the fallback for its language/script family. pt-PT is the `pt` default; the published exact pt-BR pack takes precedence for Brazilian Portuguese. Portuguese variants without an exact pack use pt-PT. `zh-Hans` and `zh-Hant` have separate defaults; do not mix scripts. Exact variants take precedence; partial entries fall back to English.

Preparation validates UTF-8 and normalizes physical line endings to LF before computing the byte length and SHA-256. It creates an immutable `translations/packs/<locale>/<revision>-<sha256>.json` path and atomically updates `translations/index.json`. JSON-escaped line breaks in text values are preserved. Same-revision changes are rejected. Keep older immutable packs for cached indexes and older clients.

Review and commit the authoring JSON, new pack and index. Contributors without write access submit a pull request to this public repository. Maintainers merge/push the files to publish. A correction or additional language needs **no APK rebuild**.

## Compatibility and app behavior

Keys in `myinsta-ui-v1` keep their meaning and arguments. An incompatible change uses a new key. Adding a new app feature/key requires a code update and APK build; maintainers update the public source/template/context alongside the bundled catalogues. Translator changes cover presentation only: preference IDs, stored states, filenames, protocols, user messages and user-defined names retain their values.

The app follows the language selected inside Instagram, including Follow system. There is no independent MyInsta selector. English and pt-PT are bundled for offline first use. Other packs and corrections use the fixed public HTTPS repository source.

The index is checked at most daily with ETag; only needed packs are downloaded. Index/pack limits are 256 KiB/1 MiB with 10-second connect/read timeouts. Schema, identity, hash, size and known placeholders must validate before atomic caching. Failed downloads keep the previous valid pack. A new revision applies to the next surface/message, preserving open dialogs and edits.

See the [public translation wiki](https://github.com/Noctharion/MyInstaAPP/wiki/Translations) for implementation status and validation limits. The v27.0.0 APK release and public update feed are separate from language packs.
