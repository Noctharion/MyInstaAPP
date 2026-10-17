# Executed verification and remaining acceptance

Source discovery and the frozen translation checkpoint are dated 2026-10-17; final integration and verification completed on 2026-10-18. This record describes executed checks, not a native-speaker quality score or Android acceptance.

## Coverage and review

- 45 primary catalogues including canonical English, each with 1,580 strings and 18 plural entries: 1,598 entries, zero missing-English fallback.
- 48 unconditional native selector variants in the exact original Instagram 447.0.0.55.81 ARM64 base, representing 42 languages. Six flag-gated variants remain unconfirmed and outside completed coverage. Other ABIs and the actual Android language selector were not independently exercised.
- Five compatible system identity packs yield 50 active pack identities, without counting extra translated languages. Chinese CN/HK/TW and Portuguese PT/BR remain separate.
- Every translated entry has a saved-value semantic review. Every non-English primary locale has independently reviewed current hashes for all 596 critical entries; targeted extras and full independent passes are counted individually in [COVERAGE.md](COVERAGE.md). Later independent corrections can replace the author-reviewed value, so the two counts need not both be 1,598.
- Exact-English equality was triaged across all 44 non-English primary catalogues. The 125 distinct equal source keys contain preserved brands, argument-only formatting, technical units, local cognates and recorded app loanwords. No long untranslated English prose was found by this equality check. This bounded check does not detect every possible wrong-language phrase or prove naturalness.
- No human/native-speaker approval or Android visual review was performed in this task.

## Technical checks actually executed

| Check | Result and boundary |
|---|---|
| Existing `Translations.ps1 -Command validate` and `-Command prepare` | PASS for all 50 final catalogues and their final revision-1 immutable pack bytes, prepared first in isolated staging. Strict production JSON/schema/arguments; every catalogue 1,598/1,598. |
| Fresh `Translations.ps1 -Command export -Locale en` | PASS; public template/context and complete bundled en/pt-PT/context synchronized. |
| Production StrictJson/TranslationPack/TranslationIndex/TranslationSession matrix | PASS: 229,272 assertions across 50 complete packs, all strings and every authored plural form formatted, category fixtures, exact native/compatible identities, configured defaults, wrong-script/fallback cases and tampered pack rejection. |
| Host plural reference | Node 24.22.0 / ICU 78.3 / CLDR 48. Integer fixtures include 0,1,2,3,4,5,6,10,11,12,20,21,22,25,100,101,102,103,111,1000,1000000. Forced selection additionally checks interpolation in authored fractional-only forms; it does not claim those categories are reachable by integer runtime counts. Android ICU was not measured. |
| English plural fallback | PASS in production session fixture: English grammar selected for missing Arabic plural text while the effective interface locale is retained for formatting. |
| Production TranslationStore integration | PASS: 50 checks using fake transport and private synthetic storage; offline first use, missing pack, daily ETag/304, locale races, strict malformed input, hash/corrupt-cache rejection, last valid cache after failures, atomic/persistence failures and retained old/new translation snapshots. These fixtures do not exercise actual HTTP or Android views/edits. |
| JSON pseudolocalization | PASS: all 1,598 entries of local en-XA expansion/accent and ar-XB bidi-isolation fixtures parsed and formatted through production classes. Neither is indexed or distributed as a real language. No layout screenshot was produced. |
| JVM suite | PASS: 689 tests in 122 suites, zero failures/errors/skips, through `Build.ps1 -Tasks @('buildBundle', ':patches:cleanTest', ':patches:test', '--no-build-cache')`. This executed at the code checkpoint before the final catalogue metadata reset; the final assets were separately rebuilt and checked below. |
| Final bundle build | PASS: `Build.ps1 -Tasks @('buildBundle')` after final en/pt-PT/context synchronization and context LF normalization, 10s. Local bundle only; no APK build, installation or release publication. |
| Final bundle integrity/Morphe | PASS: `VerifyBundle.ps1`, 17 patches loaded by Morphe Desktop 1.18.1; bundle SHA-256 `0cdd7dca09932157d722fc87d037aa74a5f4a325231b60f374d5731c2bdbdf01`. |
| Serialized final DEX/catalogues | PASS: localized clipboard-label lookup and existing copied-text cleanup remain in the exact serialized method; bundled en/pt-PT/context bytes equal the final public sources. No ART/startup/device claim. |
| Per-entry maintenance regression tests | PASS: six Python unittest cases for unchanged values, source/context/target edits, added and deleted keys. A sandbox temporary-directory access failure was resolved by assigning an isolated workspace TMPDIR; the unchanged six tests then passed. |
| Final source/pack/index coherence | PASS: all revisions 1, source/template/context keys and hashes, exact source/pack bytes, index sizes/hashes/paths/defaults, production/public parser equality and exactly one runtime pack per locale. |
| Review maintenance checker | PASS on all 50 final source identities: zero changed source/context keys or entries awaiting renewed review. Review hashes remain outside runtime schemas. |

The owner requested retirement of previous runtime pack files without local copies. 52 old/intermediate files were removed from the public checkout, including 44 historical tracked packs; copies in earlier task staging were also removed. Git history was not rewritten. The frozen shared source checkpoint and review evidence remain separate from runtime pack files. Future changes increment revisions and preserve immutable-path integrity; existing higher-revision development caches are outside the owner's clean-install path.

## Reproduction and Android acceptance

Public contributors can run the existing PowerShell validator/exporter/preparer and `python translations/tools/Review-State.py`; regression cases use `python -m unittest discover -s translations/tools/tests -v`. Full raw build/discovery logs, intermediate inspection programs and generated diagnostics are retained locally, outside this public repository. The source/context hashes and final pack sizes/hashes are public and reproducible.

The owner deferred language acceptance to people using v27.0.1. [ANDROID-MATRIX.md](ANDROID-MATRIX.md) contains the unexecuted 360/412 dp, enlarged-font, RTL, mixed-script, theme, notification, accessibility and custom-font/shaping matrix. No APK installation, cold start, real selector operation, account action, screenshot, glyph/shaping or Android visual check was executed. Source publication and online language packs do not claim those results. No APK release or OTA metadata was changed.
