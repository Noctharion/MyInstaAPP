# 2026-11-02 — v27.0.2 (incremental, plus fixed-width labels)

Scope: the delta between the app catalogue and `source/en.json`: 30 new keys (confirm before refreshing, whole-app lock "Ask again", file name format labels, like animation import, Open in another app, the Navigation restart notice), no changed English values, 3 removed keys (the download-date switch and the old view-pager lock note). Every other entry was left as it was, except the fixed-width labels below.

New this round: a length review of labels drawn in fixed-width UI (2–3 segment controls, chips, the settings dock, tabs), after a French segment label ("Barre de navigation" for "Navbar") broke its button. 52 such keys were measured in every locale; 142 values were much longer than the English (1.6× and at least 5 characters more, CJK counted double).

Process (three roles):
- Lead audit: delta of the app `en.json` against `source/en.json` (plurals unchanged); fixed-width label list from the UI code (segments, chips, dock, tabs) and the length scan.
- Translation: the 30 new entries and the 142 long labels for the 43 distinct locales in four parallel groups, reusing each catalogue's terms. Each long label was shortened only where a natural, common shorter wording exists, or kept with a reason (most fit: segments and chips shrink from 14 to 9 sp on one line, the dock wraps, tabs scroll). Identity copies take their base locale's values.
- Merge: 28 shortenings applied; 2 rejected because help texts name that label (cs and fr `navigation.screen.default`).
- Independent QA on all 43 locales: 0 critical, 0 high, 11 medium, 29 low findings; the 11 medium corrections were applied in 9 locales (see QA.md). Low findings left as they are.

Checks: `tools/Translations.ps1 -Command validate` passed 50/50; key sets, named placeholders and line-break counts match English in every file; the five identity copies match their base. `en`, `pt-PT`, `context.json` and `contribute/` follow the app catalogues. Revisions: locales 6, en/pt-PT 8. Packs and `index.json` prepared with `prepare` (defaults unchanged).

Not checked: rendering on a phone in each language (the width estimates use desktop fonts); QA flags the selected download-date chip in bn, kn and ta as possibly clipping its last word at 360 dp. Native-speaker review remains pending, as for earlier rounds.

## Shortened labels

| Locale | Key | Before | After |
|---|---|---|---|
| bg | `navigation.layout.zones.navbar` | Навигационна лента | Навигация |
| bg | `navigation.layout.zones.toolbar` | Лента с инструменти | Инструменти |
| bg | `navigation.screen.default` | Настройка по подразбиране на Instagram | По подразбиране на Instagram |
| el | `navigation.layout.zones.navbar` | Γραμμή πλοήγησης | Πλοήγηση |
| el | `navigation.layout.zones.toolbar` | Γραμμή εργαλείων | Εργαλεία |
| es | `navigation.layout.zones.navbar` | Barra de navegación | Navegación |
| es | `navigation.layout.zones.toolbar` | Barra de herramientas | Herramientas |
| fr | `navigation.layout.zones.navbar` | Barre de navigation | Navigation |
| fr | `navigation.screen.direct` | Direct dans la barre de navigation | Direct dans les onglets |
| hr | `navigation.layout.zones.navbar` | Navigacijska traka | Navigacija |
| hu | `fonts.emoji_in_use_chip` | Használatban | Aktív |
| it | `navigation.layout.zones.navbar` | Barra di navigazione | Navigazione |
| it | `navigation.layout.zones.toolbar` | Barra degli strumenti | Strumenti |
| it | `navigation.screen.direct` | Direct nella barra di navigazione | Direct tra le schede (QA) |
| ja | `settings.about_settings.title` | このアプリについて | アプリについて |
| kn | `navigation.layout.zones.navbar` | ನ್ಯಾವಿಗೇಶನ್ ಬಾರ್ | ನ್ಯಾವಿಗೇಶನ್ |
| pl | `navigation.screen.default` | Ustawienie domyślne Instagramu | Ustawienie domyślne |
| pt-BR | `navigation.layout.zones.navbar` | Barra de navegação | Navegação |
| pt-BR | `navigation.layout.zones.toolbar` | Barra de ferramentas | Ferramentas |
| ro | `fonts.emoji_in_use_chip` | În folosință | Activ |
| ro | `navigation.layout.zones.navbar` | Bară de navigare | Navigare |
| ro | `navigation.layout.zones.toolbar` | Bară de instrumente | Instrumente |
| sk | `navigation.screen.default` | Predvolené nastavenie Instagramu | Predvolené nastavenie |
| sr | `navigation.layout.zones.navbar` | Навигациона трака | Навигација |
| sr | `navigation.layout.zones.toolbar` | Трака са алаткама | Алатке |
| ta | `navigation.layout.zones.navbar` | வழிசெலுத்தல் பட்டி | வழிசெலுத்தல் |
| te | `fonts.emoji_in_use_chip` | వాడుకలో ఉంది | వాడుకలో |
| uk | `fonts.emoji_in_use_chip` | Використовується | Активно |
