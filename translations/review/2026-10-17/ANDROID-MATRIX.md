# Android visual acceptance — prepared, not executed

The owner deferred Android language acceptance to v27.0.1 users. No Android UI environment was used for this task. No Instagram installation, personal-device language change, account operation or UI screenshot was performed. The installed SDK/build tools and JVM fixtures do not establish visual acceptance.

Use an isolated authorized test environment with synthetic data. Bind every run to its APK SHA-256, bundle SHA-256, source/context hashes and exact translation pack hash/revision. Test only the next snapshot after a locale/pack revision change; an already-open dialog and edits must retain their original snapshot.

## Representative matrix

Choose English and pt-PT for offline startup; German for expansion; French for typography and 0/1/million plurals; Arabic and Hebrew for RTL and mixed text; Russian and Polish for plural inflection; Hindi and Tamil for combining/shaping and fallback fonts; Thai for line breaking; Japanese, Korean, and all three Chinese regional targets for scripts and terminology. Add every locale with an observed layout or glyph issue.

For each representative locale, exercise widths 360 and 412 dp, font scales 1.0, 1.3 and 1.6, light/dark themes and default/custom fonts. The explicit combinations are fixtures, not performed test results. Do not reduce text size or remove privacy conditions to make a warning fit.

## Implemented surfaces to inspect

1. Current final-v27 Home grouping: artwork grid, icon list, search, grid/list control and fixed footer.
2. Ghost preset and independent local conversation/media markers; inspect the complete manual Seen/view-once warning.
3. Hidden-chat disable/reopen behavior and the local-archive omission warning.
4. All view-once opening/replay/Keep/capture/notification controls, successful reply/reaction descriptions, Story viewing actions and Like Undo.
5. Font/emoji library, import failure/recovery, Story font choices, navbar dimensions and theme import/export/editor dialogs.
6. MyInsta backup preview, standalone DevFlags routing, replace/preserve/overwrite explanations and scoped deletion confirmations.
7. Optional donation buttons with exact recipient identity/URL, notifications and TalkBack descriptions.
8. Clipboard platform label, copied user text, bidirectional mixed names/URLs/counts and standard/custom font glyph coverage.

Check actual start/end alignment and isolation; do not reverse all icons or navbar order. Verify shaping, line wraps, clipped buttons, full accessibility reading, scrollability and color contrast. Keep screenshots labelled with actual locale/pack hash and fixture dimensions.

## Own JSON pseudolocales

Local JSON fixtures for `en-XA` and `ar-XB` contain all 1,598 entries, accent/expansion and bidi-isolation text. The local candidate matrix loaded them with the production JSON parser and formatted all entries. These generated diagnostic fixtures are retained locally, outside this public delivery. That host execution is technical only. These files are not translations, are not in any candidate index and must not be published as real languages. An Android pseudolocale setting alone does not test this JSON path.

## Remaining real-platform checks

Offline first launch; absent/invalid/incompatible pack; last-valid cache after failures; locale switch and revision update; preserved open dialogs and edits; representative plural values on actual Android ICU; glyph coverage and shaping; actual Instagram native locale selection. JVM fake transport/snapshot tests do not replace these UI checks.
