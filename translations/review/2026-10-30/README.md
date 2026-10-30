# Translation synchronization and QA, 2026-10-30
Authoring catalogues were synchronized with the application bundle at private commit f610c09 (v27.0.1 beta 5) plus the owner's pt-PT “Bloquear conversa” change. English grew from 1,829 to 2,132 entries (2,106 strings, 26 plurals). Each of the 48 non-bundled files lacked 460 entries, had 50 entries whose English changed and 36 obsolete entries no longer in the application catalogue.
Process: missing and stale entries were translated by a Sonnet implementation pass working from each catalogue's existing terminology, then every changed entry was checked by an independent Opus QA pass that also swept the unchanged entries for high-severity problems. Both passes are AI work. No human/native-speaker review and no Android visual review were performed. The 2026-10-17 `review-state.json` is unchanged and its records do not certify these new values.
Columns: preserved = existing values left byte-identical; new = previously missing entries; stale fixed = existing values rewritten because English changed; other edits = QA corrections to unchanged-source values (mostly the Lock Chat label); stale kept = changed-source entries whose existing value already matched. Severity counts are QA findings; every CRITICAL/HIGH/MEDIUM finding is fixed, and the few LOW findings left open are listed in the findings file.
| locale | entries | preserved | new | stale fixed | other edits | stale kept | CRIT | HIGH | MED | LOW | QA | note |
|---|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|---|---|
| af | 2132 | 1629 | 460 | 41 | 2 | 9 | 0 | 3 | 7 | 2 | PASS |  |
| ar | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 10 | 1 | PASS |  |
| bg | 2132 | 1630 | 460 | 41 | 1 | 9 | 0 | 3 | 6 | 7 | PASS |  |
| bn | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 5 | 0 | PASS |  |
| cs | 2132 | 1628 | 460 | 41 | 3 | 9 | 0 | 3 | 9 | 0 | PASS |  |
| da | 2132 | 1630 | 460 | 41 | 1 | 9 | 0 | 2 | 6 | 2 | PASS, 1 LOW open |  |
| de | 2132 | 1630 | 460 | 41 | 1 | 9 | 0 | 2 | 4 | 1 | PASS |  |
| el | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 3 | 7 | 3 | PASS |  |
| es | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 6 | 1 | PASS |  |
| fa | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 4 | 0 | PASS |  |
| fi | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 3 | 12 | 3 | PASS |  |
| fil-PH | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 7 | 4 | PASS | identity of tl |
| fr | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 5 | 1 | PASS |  |
| gu | 2132 | 1625 | 460 | 46 | 1 | 4 | 0 | 0 | 14 | 0 | PASS |  |
| he | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 1 | 6 | 1 | PASS |  |
| hi | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 3 | 0 | PASS |  |
| hr | 2132 | 1629 | 460 | 41 | 2 | 9 | 0 | 3 | 6 | 1 | PASS |  |
| hu | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 3 | 17 | 5 | PASS |  |
| id | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 9 | 0 | PASS |  |
| it | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 5 | 1 | PASS |  |
| ja | 2132 | 1634 | 460 | 37 | 1 | 13 | 0 | 0 | 3 | 0 | PASS |  |
| kn | 2132 | 1625 | 460 | 46 | 1 | 4 | 0 | 0 | 12 | 3 | PASS |  |
| ko | 2132 | 1634 | 460 | 37 | 1 | 13 | 0 | 0 | 4 | 0 | PASS |  |
| mr | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 3 | 0 | PASS |  |
| ms | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 8 | 0 | PASS |  |
| nb | 2132 | 1630 | 460 | 41 | 1 | 9 | 0 | 2 | 3 | 0 | PASS |  |
| nl | 2132 | 1630 | 460 | 41 | 1 | 9 | 0 | 2 | 5 | 2 | PASS, 2 LOW open |  |
| pl | 2132 | 1631 | 460 | 39 | 2 | 11 | 0 | 3 | 5 | 1 | PASS |  |
| pt-BR | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 7 | 2 | PASS |  |
| ro | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 6 | 0 | PASS |  |
| ru | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 3 | 9 | 0 | PASS |  |
| sk | 2132 | 1628 | 460 | 41 | 3 | 9 | 0 | 3 | 7 | 0 | PASS |  |
| sr | 2132 | 1628 | 460 | 41 | 3 | 9 | 0 | 2 | 8 | 2 | PASS |  |
| sr-Cyrl-RS | 2132 | 1628 | 460 | 41 | 3 | 9 | 0 | 2 | 8 | 2 | PASS | identity of sr |
| sv | 2132 | 1630 | 460 | 41 | 1 | 9 | 0 | 2 | 1 | 1 | PASS, 1 LOW open |  |
| ta | 2132 | 1624 | 460 | 47 | 1 | 3 | 0 | 1 | 12 | 1 | PASS |  |
| te | 2132 | 1625 | 460 | 46 | 1 | 4 | 0 | 0 | 28 | 0 | PASS |  |
| th | 2132 | 1625 | 460 | 46 | 1 | 4 | 0 | 0 | 7 | 0 | PASS |  |
| tl | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 7 | 4 | PASS |  |
| tr | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 3 | 13 | 3 | PASS |  |
| uk | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 3 | 11 | 2 | PASS |  |
| vi | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 5 | 0 | PASS |  |
| zh-CN | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 7 | 0 | PASS |  |
| zh-HK | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 19 | 2 | PASS |  |
| zh-Hans-CN | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 7 | 0 | PASS | identity of zh-CN |
| zh-Hant-HK | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 19 | 2 | PASS | identity of zh-HK |
| zh-Hant-TW | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 18 | 2 | PASS | identity of zh-TW |
| zh-TW | 2132 | 1632 | 460 | 39 | 1 | 11 | 0 | 0 | 18 | 2 | PASS |  |

Technical checks run after QA on all 50 files: `tools/Translations.ps1 -Command validate` (strict parser) passed 50/50 at 2,132/2,132; key sets equal to English; placeholder sets equal per entry; every plural has `other` and keeps its arguments; line breaks match English; no empty values. Not run: pack preparation (`prepare`), APK build, `Verify-Translations.ps1` on an APK, device language/layout matrix. Downloadable packs and `index.json` remain revision 1.

Findings per locale are in [qa-findings.json](qa-findings.json).
