# Independent QA: v27.0.2 translations (MyInstaAPP authoring sources)

Reviewer role: independent QA (third role). Date: 2026-11-02. Scope: the 30 new entries in 43 distinct locales, the fixed-width shortenings and the "kept" decisions in `merge-stats.json`. en and pt-PT (owner-maintained) skipped; identity copies checked for equality with their base only.

## Totals

- CRITICAL: 0
- HIGH: 0
- MEDIUM: 11 (all corrected in `qa/corrections.json`: 11 corrections in 9 locales)
- LOW: 29 (left as they are)

After applying the corrections, refresh the identity copy zh-Hant-HK from zh-HK (the merge step copies identity files from their base).

## Method and automated checks

- Parsed every authoring file and compared it with `git show HEAD:` (script `qa/check.py`). In all 43 distinct locales: no BOM, top-level fields unchanged, revision +1, exactly the 30 new keys added, exactly the 3 removed keys gone (`settings.download_date_in_name.*`, `navigation.layout.locked_pager`), and no other existing value changed except the shortenings listed in `merge-stats.json` (old/new values match the record). Key order matches the app catalogue (2,156 entries).
- `git diff --numstat`: 31 added / 4 removed lines per locale plus one line per shortening; no reformatting.
- New entries: placeholders (none expected) and line breaks match English; no literal `\n`, no leading/trailing or double spaces; no untranslated English in non-Latin locales except product names. Values identical to English: da/fr/nl "Type", ms "Import", tl "Username" - all genuine words in those catalogues.
- `settings.download_open_external.title` and `.summary` contain `media.download.open_external` verbatim (case-sensitive) in all 43 locales.
- Units and digits follow each catalogue (fr "Mo", ru/uk "МБ", others "MB"; Latin digits everywhere, as in the rest of each catalogue).
- Identity copies (zh-Hans-CN, zh-Hant-HK, zh-Hant-TW, sr-Cyrl-RS, fil-PH): strings and plurals equal to their base, revision +1.
- Terminology: for every locale I read the new entries next to about 40 related entries (like-animation strings, common/fonts import, download settings, audio-extraction switch, whole-app lock, pull to refresh, confirm before calling, Feed/Explore/Reels names, navigation layout and restart strings) and the removed `download_date_in_name` texts from HEAD (`qa/dump/<locale>.txt`).
- Width: code read in `SettingsActivity.chooseNameFormat` (chips: 3 per row, weight 1, 8 dp gaps, 8 dp padding, single line, autosize 14 to 9 sp, "N · " prefix and medium typeface when selected; sheet panel padding 20 dp, so about 85 dp of text on a 360 dp phone) and `NavigationLayoutEditor.segment` (single line, 4 dp padding, autosize 14 to 9 sp; about 88 dp of text). Text measured with Windows fonts as stand-ins (Arial for Latin/Cyrillic/Greek, Segoe UI for Arabic script, Nirmala UI for Indic, Leelawadee UI, YaHei/JhengHei/Yu Gothic/Malgun for CJK), without complex shaping (`qa/dump.py`, `qa/segments.py`). Every segment label in every locale (zones, logo position, header title) fits at 11 sp or more.

## Per-locale results

"Related" = other entries re-checked because a shortened label is quoted or inserted elsewhere (navigation.layout.not_allowed, navigation.screen.help/.imported/reset_all_confirm).

| Locale | Entries checked | CRITICAL | HIGH | MEDIUM | LOW | Corrected |
|---|---|---|---|---|---|---|
| af | 32 (30 new, 0 shortened, 2 kept, 0 related) | 0 | 0 | 1 | 1 | 1 |
| ar | 32 (30 new, 0 shortened, 2 kept, 0 related) | 0 | 0 | 0 | 0 | 0 |
| bg | 40 (30 new, 3 shortened, 3 kept, 4 related) | 0 | 0 | 1 | 1 | 1 |
| bn | 32 (30 new, 0 shortened, 2 kept, 0 related) | 0 | 0 | 0 | 0 | 0 |
| cs | 32 (30 new, 0 shortened, 2 kept, 0 related) | 0 | 0 | 0 | 1 | 0 |
| da | 34 (30 new, 0 shortened, 4 kept, 0 related) | 0 | 0 | 0 | 0 | 0 |
| de | 31 (30 new, 0 shortened, 1 kept, 0 related) | 0 | 0 | 0 | 1 | 0 |
| el | 40 (30 new, 2 shortened, 7 kept, 1 related) | 0 | 0 | 0 | 1 | 0 |
| es | 37 (30 new, 2 shortened, 4 kept, 1 related) | 0 | 0 | 1 | 1 | 1 |
| fa | 32 (30 new, 0 shortened, 2 kept, 0 related) | 0 | 0 | 0 | 0 | 0 |
| fi | 34 (30 new, 0 shortened, 4 kept, 0 related) | 0 | 0 | 0 | 0 | 0 |
| fr | 37 (30 new, 2 shortened, 4 kept, 1 related) | 0 | 0 | 1 | 1 | 1 |
| gu | 32 (30 new, 0 shortened, 2 kept, 0 related) | 0 | 0 | 0 | 0 | 0 |
| he | 30 (30 new, 0 shortened, 0 kept, 0 related) | 0 | 0 | 2 | 0 | 2 |
| hi | 32 (30 new, 0 shortened, 2 kept, 0 related) | 0 | 0 | 0 | 0 | 0 |
| hr | 36 (30 new, 1 shortened, 4 kept, 1 related) | 0 | 0 | 0 | 0 | 0 |
| hu | 36 (30 new, 1 shortened, 4 kept, 1 related) | 0 | 0 | 0 | 2 | 0 |
| id | 30 (30 new, 0 shortened, 0 kept, 0 related) | 0 | 0 | 0 | 0 | 0 |
| it | 36 (30 new, 3 shortened, 2 kept, 1 related) | 0 | 0 | 2 | 1 | 2 |
| ja | 34 (30 new, 1 shortened, 3 kept, 0 related) | 0 | 0 | 0 | 0 | 0 |
| kn | 34 (30 new, 1 shortened, 2 kept, 1 related) | 0 | 0 | 0 | 2 | 0 |
| ko | 33 (30 new, 0 shortened, 3 kept, 0 related) | 0 | 0 | 0 | 1 | 0 |
| mr | 30 (30 new, 0 shortened, 0 kept, 0 related) | 0 | 0 | 0 | 0 | 0 |
| ms | 31 (30 new, 0 shortened, 1 kept, 0 related) | 0 | 0 | 0 | 2 | 0 |
| nb | 33 (30 new, 0 shortened, 3 kept, 0 related) | 0 | 0 | 0 | 0 | 0 |
| nl | 31 (30 new, 0 shortened, 1 kept, 0 related) | 0 | 0 | 0 | 0 | 0 |
| pl | 38 (30 new, 1 shortened, 4 kept, 3 related) | 0 | 0 | 0 | 2 | 0 |
| pt-BR | 35 (30 new, 2 shortened, 2 kept, 1 related) | 0 | 0 | 1 | 1 | 1 |
| ro | 38 (30 new, 3 shortened, 3 kept, 2 related) | 0 | 0 | 1 | 1 | 1 |
| ru | 35 (30 new, 0 shortened, 5 kept, 0 related) | 0 | 0 | 0 | 1 | 0 |
| sk | 37 (30 new, 1 shortened, 3 kept, 3 related) | 0 | 0 | 0 | 1 | 0 |
| sr | 36 (30 new, 2 shortened, 3 kept, 1 related) | 0 | 0 | 0 | 0 | 0 |
| sv | 33 (30 new, 0 shortened, 3 kept, 0 related) | 0 | 0 | 0 | 0 | 0 |
| ta | 37 (30 new, 1 shortened, 5 kept, 1 related) | 0 | 0 | 0 | 2 | 0 |
| te | 35 (30 new, 1 shortened, 3 kept, 1 related) | 0 | 0 | 0 | 0 | 0 |
| th | 32 (30 new, 0 shortened, 2 kept, 0 related) | 0 | 0 | 0 | 0 | 0 |
| tl | 31 (30 new, 0 shortened, 1 kept, 0 related) | 0 | 0 | 0 | 0 | 0 |
| tr | 31 (30 new, 0 shortened, 1 kept, 0 related) | 0 | 0 | 0 | 1 | 0 |
| uk | 36 (30 new, 1 shortened, 4 kept, 1 related) | 0 | 0 | 0 | 2 | 0 |
| vi | 32 (30 new, 0 shortened, 2 kept, 0 related) | 0 | 0 | 0 | 2 | 0 |
| zh-CN | 32 (30 new, 0 shortened, 2 kept, 0 related) | 0 | 0 | 0 | 0 | 0 |
| zh-HK | 32 (30 new, 0 shortened, 2 kept, 0 related) | 0 | 0 | 1 | 0 | 1 |
| zh-TW | 33 (30 new, 0 shortened, 3 kept, 0 related) | 0 | 0 | 0 | 1 | 0 |
| zh-Hans-CN | identity copy of zh-CN (strings and plurals equal to the base) | - | - | - | - | 0 |
| zh-Hant-HK | identity copy of zh-HK (strings and plurals equal to the base) | - | - | - | - | 1 (follows zh-HK) |
| zh-Hant-TW | identity copy of zh-TW (strings and plurals equal to the base) | - | - | - | - | 0 |
| sr-Cyrl-RS | identity copy of sr (strings and plurals equal to the base) | - | - | - | - | 0 |
| fil-PH | identity copy of tl (strings and plurals equal to the base) | - | - | - | - | 0 |

## Findings corrected (CRITICAL/HIGH/MEDIUM)

### af · MEDIUM · `settings.like_animation.custom`

- Old: Geïmporteer
- New: Ingevoer
- Reason: Terminology: this catalogue says "invoer" for import (common.import "Voer in", fonts.imported "{name} ingevoer"); the tile sits next to the "Voer in" tile, so "Geïmporteer" mixes two words for the same action.

### bg · MEDIUM · `settings.biometric_app_grace.title`

- Old: Питане отново
- New: Повторно удостоверяване
- Reason: Unnatural calque: a verbal noun followed by an adverb ("Питане отново") is not idiomatic Bulgarian. "Повторно удостоверяване" is the usual phrase and uses the catalogue term for authentication (summary: "да поиска отново удостоверяване"; settings.biometric_direct_messages: "Изисква удостоверяване").

### es · MEDIUM · `navigation.layout.not_allowed`

- Old: {item} no se puede colocar en {zone}.
- New: {item} no se puede colocar en «{zone}».
- Reason: Side effect of the shortening: {zone} is filled with navigation.layout.zones.* (NavigationLayoutEditor.zoneName, line 180), so the drag-refusal notice now reads "... no se puede colocar en Herramientas" ("in Tools"). Quoting makes it read as the option label; the catalogue already quotes labels with «».

### fr · MEDIUM · `navigation.layout.not_allowed`

- Old: {item} ne peut pas être placé dans {zone}.
- New: {item} ne peut pas être placé dans « {zone} ».
- Reason: Same side effect: the notice now reads "... placé dans Navigation", which also matches the Navigation page title. Quoted with the catalogue's « » style (regular spaces, as in themes.error.opaque).

### he · MEDIUM · `settings.like_animation.custom`

- Old: יובאה
- New: מיובאת
- Reason: Wrong part of speech: "יובאה" is a finite past-tense verb ("was imported"). The value is a tile name and the toast "אנימציית לייק: {name}", so it needs the adjective "מיובאת" (feminine, agreeing with אנימציה).

### he · MEDIUM · `settings.download_name_format.summary`

- Old: בחרו איך יקראו הקבצים שנשמרים: שם משתמש, מזהה מדיה, תאריך הורדה או תאריך פרסום, לפי הסדר שתבחרו.
- New: בחרו איך ייקראו הקבצים שנשמרים: שם משתמש, מזהה מדיה, תאריך הורדה או תאריך פרסום, לפי הסדר שתבחרו.
- Reason: Spelling that changes the literal meaning: in full spelling "יקראו" is the qal form "(they) will read"; "will be called" (niphal) is "ייקראו", the way the same batch writes "ייטענו" in gestures.refresh.message.

### it · MEDIUM · `navigation.screen.direct`

- Old: Direct nella barra
- New: Direct tra le schede
- Reason: Ambiguous shortening: "Direct nella barra" does not say which bar, and Direct is already in the top toolbar by default, so the label no longer tells this screen type apart. The value is a row value and a full-width sheet row, not a fixed-width control; "Direct tra le schede" stays short (like the French "Direct dans les onglets") and uses the catalogue word for tabs (navigation.screen.help "le schede").

### it · MEDIUM · `navigation.layout.not_allowed`

- Old: {item} non può essere posizionato in {zone}.
- New: {item} non può essere posizionato in «{zone}».
- Reason: Side effect of the shortening: the notice now reads "... posizionato in Strumenti" ("in Tools"). Quoted with the catalogue's «» style.

### pt-BR · MEDIUM · `navigation.layout.not_allowed`

- Old: {item} não pode ser colocado em {zone}.
- New: {item} não pode ser colocado em “{zone}”.
- Reason: Side effect of the shortening: the notice now reads "... colocado em Ferramentas" ("in Tools"). Quoted with the catalogue's “ ” style.

### ro · MEDIUM · `navigation.layout.not_allowed`

- Old: {item} nu poate fi plasat în {zone}.
- New: {item} nu poate fi plasat în „{zone}”.
- Reason: Side effect of the shortening: the notice now reads "... plasat în Instrumente" ("in Tools"). Quoted with the catalogue's „ ” style.

### zh-HK · MEDIUM · `settings.biometric_app_grace.summary`

- Old: Instagram 在背景停留多久後，整個應用程式的鎖定會再次要求驗證身分。
- New: Instagram 在背景停留多久後，整個應用程式的鎖定會再次要求驗證身份。
- Reason: Regional form: "身分" is the Taiwan form; the zh-HK catalogue writes "身份" (4 of 5 uses, e.g. settings.biometric_direct_messages "要求身份驗證"). The identity copy zh-Hant-HK must receive the same value.

Code-side alternative for the `navigation.layout.not_allowed` findings: `NavigationLayoutEditor` line 180 could pass the group name (`navigation.layout.groups.<zone>`, as the swap notice on line 170 already does) instead of the short segment label; then the quoting corrections are optional.

## LOW findings (left as they are)

| Locale | Key | Note |
|---|---|---|
| af | `settings.biometric_app_grace.60 / .300` | "Na 1 minuut" / "Na 5 minute": the catalogue writes temporal "ná" ("ná 'n herbegin", "ná die gebruikersnaam"). The accent is optional; consistency only. |
| cs | `settings.download_name_format.token.date / .posted` | Asymmetric pair "Datum stažení" / "Zveřejněno". "Datum zveřejnění" (16 characters) would match but is longer than the 14-character target; acceptable. |
| de | `settings.download_name_format.token.date / .posted` | Asymmetric pair "Download-Datum" / "Veröffentlicht"; acceptable for the chip width. |
| hu | `settings.download_name_format.token.date / .posted` | Asymmetric pair "Letöltés dátuma" / "Közzétéve"; acceptable. |
| pl | `settings.download_name_format.token.date / .posted` | Asymmetric pair "Data pobrania" / "Opublikowano"; acceptable. |
| es | `settings.download_name_format.token.id` | "ID de contenido" while the summary says "ID del contenido"; both natural. |
| fr | `settings.download_open_external.title` | "Afficher Ouvrir dans une autre application" stacks two verbs without quotes. It follows this catalogue's existing "Afficher Audio uniquement ..." convention, so left as is. |
| it | `settings.download_open_external.title` | "Mostra Apri in un'altra app": two verbs without quotes, same convention as "Mostra Solo audio ...". |
| ms | `settings.download_open_external.title` | "Paparkan Buka dalam apl lain": two verbs without quotes, same convention as "Paparkan Audio sahaja ...". |
| pt-BR | `settings.download_open_external.title` | "Mostrar Abrir em outro app": two verbs without quotes, same convention as "Mostrar Somente áudio ...". |
| vi | `settings.download_open_external.title` | "Hiện Mở trong ứng dụng khác": two verbs without quotes, same convention as "Hiện Chỉ âm thanh ...". |
| ms | `settings.confirm_refresh.summary` | "... memuat Suapan, Teroka atau Reels" says "loads"; "memuat semula" (reloads) would be closer to the English. |
| vi | `settings.confirm_refresh.summary` | "Hỏi trước khi kéo xuống để làm mới ..." literally asks before the pull rather than before the reload; the intent is still clear. |
| ru | `settings.like_animation.custom` | "Импортировано" is the neuter status form; "Импортированная" would agree with "анимация". Fine as a status label. |
| tr | `settings.like_animation.custom` | "İçe aktarıldı" is a finite verb ("was imported"); "İçe aktarılan" would read as a name. Fine as a status label. |
| uk | `settings.like_animation.imported` | "... тепер є анімацією «Подобається»": the explicit "є" is a calque; "Тепер ваша анімація — анімація «Подобається»" is smoother. |
| zh-TW | `settings.like_animation.import_failed` | "動圖" is colloquial; "動畫" (used everywhere else in zh-TW) would be more formal. |
| ko | `settings.download_name_format.pick` | Mixed construction ("눌러 ... 추가하고, 다시 누르면 제거됩니다"); "라벨을 누르면 이름에 추가되고, 다시 누르면 제거됩니다." is smoother. |
| kn | `settings.download_name_format.token.date / .posted` | Chips say "ದಿನ" (day) where the summary and the catalogue say "ದಿನಾಂಕ" (date); chosen for width. |
| ta | `settings.download_name_format.token.date / .posted` | Chips and summary say "நாள்" where the old catalogue entry said "தேதி"; "நாள்" is also the usual word for "date" on Tamil forms, so acceptable. |
| pl | `navigation.screen.default (shortened)` | "Ustawienie domyślne" no longer names Instagram, while navigation.screen.help/.imported keep "Ustawienie domyślne Instagramu". The label is a prefix of that phrase, so the help still points at it. The value is a row value and a full-width sheet row (not a fixed-width control); the shortening only spares the row title. |
| sk | `navigation.screen.default (shortened)` | Same as pl: "Predvolené nastavenie" vs help texts "Predvolené nastavenie Instagramu"; acceptable. |
| bg | `navigation.screen.default (shortened)` | Same pattern: "По подразбиране на Instagram" vs help texts "настройката по подразбиране на Instagram"; acceptable. |
| el | `navigation.layout.zones.navbar / .toolbar (shortened)` | Not needed for width: the old "Γραμμή πλοήγησης" / "Γραμμή εργαλείων" fit at about 10 sp. The new "Πλοήγηση" / "Εργαλεία" are fine. |
| kn | `navigation.layout.not_allowed` | Embeds the shortened navbar label ("... ನ್ಯಾವಿಗೇಶನ್ ನಲ್ಲಿ ..."); still understandable, left as is. |
| ta | `navigation.layout.not_allowed` | Embeds the shortened navbar label ("வழிசெலுத்தல்-இல்"); still understandable, left as is. |
| hu | `fonts.emoji_in_use_chip (shortened)` | The pill now says "Aktív" inside the group headed "HASZNÁLATBAN" (fonts.emoji_in_use), and the pack sheet status still says "Használatban". Synonyms, not a contradiction; the shorter pill leaves room for the pack name. |
| ro | `fonts.emoji_in_use_chip (shortened)` | Pill "Activ" under the group header "ÎN FOLOSINȚĂ" and the sheet status "În folosință"; synonyms, acceptable. |
| uk | `fonts.emoji_in_use_chip (shortened)` | Pill "Активно" under the group header "ВИКОРИСТОВУЄТЬСЯ" and the sheet status "Використовується"; synonyms, acceptable ("Активний" would agree with набір/шрифт). |

Cross-locale note (no change): the shortened navbar segment label now equals the Navigation page title (`settings.navigation_tabs_settings.title`) in es, it, fr, pt-BR, ro, bg, sr, hr, el, kn and ta. Acceptable: the segment sits on each item card under the full group heading ("Barra de navegación" etc.).

## Shortenings and "kept" decisions

- 28 shortenings applied in 17 locales and 112 "kept" decisions reviewed (plus 2 shortenings rejected by the merge because help texts quote the old label: cs and fr `navigation.screen.default` - correctly left unchanged). All are natural and keep the meaning except it `navigation.screen.direct` (corrected above). The navbar/toolbar segment pattern "Navigation / Tools" (es, it, pt-BR, ro, bg, el, sr, hr, fr, kn, ta) reads well in the segment, but `navigation.layout.not_allowed` inserts the same label into a sentence (corrected above for es, it, pt-BR, ro, fr; kn and ta left as LOW).
- Emoji "In use" pills shortened in hu ("Aktív"), ro ("Activ"), te ("వాడుకలో"), uk ("Активно"): acceptable. The pill is wrap-content (not fixed width), so the old values fitted too, but the shorter pill leaves more room for the font or pack name. In hu, ro and uk it now differs from the group header `fonts.emoji_in_use` and the pack-sheet status `fonts.emoji_status_in_use` (synonyms, listed as LOW); te keeps the same word.
- ja `settings.about_settings.title` "アプリについて": fine.
- Kept decisions: all reasonable; none will clearly overflow. Segments kept long (for example de "Navigationsleiste", tr "Gezinme çubuğu", nb "Navigasjonslinje", pl "Pasek nawigacji") measure 11-14 sp in about 88 dp. Dock labels (12 sp, no line limit) wrap at spaces; navigation section tabs and Unsent filter chips scroll horizontally; appearance options are Spinner entries; `navigation.screen.*` values are wrap-content row values and full-width sheet rows.
- Factual slips in translator rationales (conclusions still hold): nb and sv describe `navigation.layout.icons.magnifier` as a two-segment control - it is a full-width row in the icon sheet (`NavigationLayoutEditor` line 310). `inputs.py` labelled `navigation.layout.icons.*` and `navigation.layout.title_feeds_preview` as segments.

## Could not judge reliably

- Selected-state width of the download-date chip in bn ("ডাউনলোড তারিখ"), kn ("ಡೌನ್‌ಲೋಡ್ ದಿನ") and ta ("பதிவிறக்க நாள்"). With the "5 · " prefix and the medium typeface at 9 sp, my estimate is about 88, 92 and 95 dp against about 85 dp available on a 360 dp phone (unselected they fit at 9-10 sp). The estimate uses Nirmala UI without shaping, so the real Android or Samsung fonts may differ by about 10%. If it overflows, `maxLines(1)` hides the last word, for example "1 · பதிவிறக்க" without "நாள்". I found no clearly better shorter wording, so I made no change. Worth one device look with Tamil, Kannada and Bengali (the test phone was not connected during this review); a code-side fallback would be allowing two lines or an 8 sp minimum for these chips.
- Native-speaker nuance in the Indic, Thai and Persian catalogues: I checked meaning, register, catalogue terminology and agreement, but subtle naturalness would need a native reviewer.

## Files

- `qa/corrections.json`: {"<locale>": {"<key>": "<corrected value>"}} for the MEDIUM findings (UTF-8, no BOM).
- `qa/check.py` (structure vs git HEAD), `qa/dump.py` and `qa/dump/<locale>.txt` (review sheets with chip widths and context), `qa/segments.py` (segment width scan), `qa/write_corrections.py`, `qa/write_report.py`.
