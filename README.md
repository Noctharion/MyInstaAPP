# MyInsta

Public release and membership metadata maintained by Spartan. Application source code is maintained separately.

## v27.0.0 (Final)

Prepared October 10, 2026, based on Instagram **447.0.0.55.81**, for Android **9 (API 28) and later**. This release contains **eight APKs**: Clone and UnClone for **arm64-v8a, armeabi-v7a, x86_64 and x86**. Release information and delivery are managed on the [official website](https://myinsta.dev/releases).

| Architecture | Original Instagram versionCode | UnClone package | Clone package |
| --- | ---: | --- | --- |
| arm64-v8a | 385311922 | `com.instagram.android` | `com.myinsta.android` |
| armeabi-v7a | 385311936 | `com.instagram.android` | `com.myinsta.android` |
| x86_64 | 385311888 | `com.instagram.android` | `com.myinsta.android` |
| x86 | 385311887 | `com.instagram.android` | `com.myinsta.android` |

UnClone retains Instagram's package, name and launcher icon. Clone uses MyInsta's separate package, name and icon. Filenames use `MyInsta-v27.0.0-Final-{UnClone|Clone}-{abi}-baseVC{original}.apk`. The original native code is recorded as `inputVersionCode`; the installed Android versionCode is **999999999**. Android's native versionName remains **447.0.0.55.81**, while the embedded MyInsta identity is **27.0.0 / v27.0.0 / stable**.

V27 consolidates the privacy, download, appearance and content controls developed through Beta 3, Beta 4 and Beta 5: Keep Unsent Messages, the Story organizer, Fonts & emojis, creative Direct text, native audio upload, advanced downloads, Instants controls, Direct receipt controls, Like protection, photo/GIF comment downloads and MOD settings backup with optional developer flags. It also includes the supported alternate-layout, native-theme, Story mention/header and Direct layout corrections. The full Stories summary retains native behavior, with scoped colors only.

**Signing transition:** these APKs use certificate SHA-256 `5f2dc419cd20d0f12ca2f0311c3be6f53f317ee7547de51d9866f0699c4ff431`, different from the Beta 5 certificate. Android requires removal of an existing same-package installation signed with the earlier certificate before installing this final release. Export desired MOD settings first. About backups do not preserve accounts, message archives, media files, font files or Android folder permissions. Clone and UnClone remain separate installations.

No website editorial build number was supplied; the embedded **releaseBuildNumber is -1 (unknown)**. The updater omits `installedBuildNumber` and compares version/channel. Neither the original native code nor the installed Android override is the website's editorial build number. The official release must receive its own editorial metadata when published.

All four ABI bundles passed **370 JVM tests per ABI**. Each exact signed APK applied **17 patches** and passed package/ABI and embedded identity, v1/v2/v3 signature checks against the final certificate, 16 KB alignment, signing payload/DEX preservation, serialized branch/runtime/native-reference checks and scoped screen, comment-download, Like protection and Reels tray gates. Per-artifact counts are recorded in the release notes and manifest. **Fresh device acceptance of the exact final APKs remains pending.**

See the [release notes](https://github.com/Noctharion/MyInstaAPP/blob/main/RELEASE-NOTES.md), [Final SHA-256 checksums](https://github.com/Noctharion/MyInstaAPP/blob/main/SHA256SUMS-v27.0.0.txt), [artifact manifest](https://github.com/Noctharion/MyInstaAPP/blob/main/RELEASE-MANIFEST-v27.0.0.json) and [Final Wiki record](https://github.com/Noctharion/MyInsta/wiki/Release-v27.0.0). GitHub publication does not create a website release or upload APKs. All `updates.json` download links are empty by owner request; app OTA uses the official API.

## v27.2.5 (Beta 5)

Prepared October 10, 2026, based on Instagram **447.0.0.55.81**. **Clone and UnClone for arm64-v8a only**; other architectures are reserved for the final release. These updated APKs were rebuilt with the additional likes-list correction. They retain the internal **`v27.2.5-dev`** label and OTA identity **`27.2.5 / beta`**, Android versionCode `999999999`, unknown editorial build number `-1` and the established signing certificate.

| Architecture | UnClone (Instagram) | Clone (MyInsta) |
| --- | --- | --- |
| arm64-v8a | Download link pending | Download link pending |

Beta 5 adds **Like protection**, photo/GIF comment downloads and MOD settings backup with optional developer flags. It corrects Direct media-read bookkeeping, emoji measurement and shortcut ordering, Story mention/header alignment, and native theme coverage across discovery, search, News filters and Reels menus/trays. Home theme work is reduced during drawing. The Stories summary page retains native behavior, with color handling only.

See [release notes](https://github.com/Noctharion/MyInstaAPP/blob/main/RELEASE-NOTES.md), [Beta 5 SHA-256 checksums](https://github.com/Noctharion/MyInstaAPP/blob/main/SHA256SUMS-v27.2.5.txt), the [artifact manifest](https://github.com/Noctharion/MyInstaAPP/blob/main/RELEASE-MANIFEST-v27.2.5.json) and the [Wiki release record](https://github.com/Noctharion/MyInsta/wiki/Release-v27.2.5). The bundle passed **370 JVM tests**, the production people renderer passed **198 checks**, and both exact APKs passed signature, package/ABI, identity, 16 KB alignment, payload and serialized integration checks. Fresh device confirmation of the latest visual changes remains pending.

The owner publishes the matching APKs on the [official website](https://myinsta.dev/releases). Repository updates do not create the website release. The app uses `https://myinsta.dev/api/version`; this repository's `updates.json` remains legacy release metadata. Source development moves to **v27.0.0 final**, while these APKs remain Beta 5.

## v27.2.4 (Beta 4)

Prepared October 9, 2026, based on Instagram **447.0.0.55.81**. This release contains **Clone and UnClone for arm64-v8a only**. Other architectures are reserved for the final release. Release identity is `27.2.4 / beta`, with Android versionCode `999999999` and the established signing certificate.

| Architecture | UnClone (Instagram) | Clone (MyInsta) |
| --- | --- | --- |
| arm64-v8a | Download link pending | Download link pending |

Beta 4 adds an optional in-chat **Mark as seen** button and **Seen after reacting**, corrects alternate Developer Flag layouts and theme coverage, suppresses contacts/location onboarding with Disable analytics, refreshes settings artwork and About links, and migrates update checks to the official API with a Home announcement. See [release notes](https://github.com/Noctharion/MyInstaAPP/blob/main/RELEASE-NOTES.md), [Beta 4 SHA-256 checksums](https://github.com/Noctharion/MyInstaAPP/blob/main/SHA256SUMS-v27.2.4.txt), the [artifact manifest](https://github.com/Noctharion/MyInstaAPP/blob/main/RELEASE-MANIFEST-v27.2.4.json) and the [Wiki release record](https://github.com/Noctharion/MyInsta/wiki/Release-v27.2.4).

Both final signed APKs applied all **17 patches** and passed package/ABI, embedded release identity, established-certificate signature, 16 KB alignment, DEX/runtime payload preservation, serialized branches and native references. The ARM64 bundle passed **347 JVM tests**. The final manifest records **no fresh device validation**; visual acceptance, recipient-visible receipts, Home announcements and onboarding behavior remain pending owner testing.

Downloads and release publication are managed on the [official website](https://myinsta.dev/releases). Starting with Beta 4, the app uses `https://myinsta.dev/api/version`; `updates.json` remains historical release metadata and is no longer the app's OTA source. Publishing this repository does not publish an official website release or upload its APKs. Beta 3 and Beta 2 entries remain available below.

## v27.2.3 (Beta 3)

Prepared October 5, 2026, based on Instagram **447.0.0.55.81**. Eight final APKs cover Clone and UnClone for **arm64-v8a, armeabi-v7a, x86_64 and x86**. Download links will be added by the owner.

| Architecture | UnClone (Instagram) | Clone (MyInsta) |
| --- | --- | --- |
| arm64-v8a | Download link pending | Download link pending |
| armeabi-v7a | Download link pending | Download link pending |
| x86_64 | Download link pending | Download link pending |
| x86 | Download link pending | Download link pending |

UnClone uses `com.instagram.android` and retains Instagram's name and icon. Clone uses `com.myinsta.android` with the MyInsta name and icon for a separate installation. Each final APK declares MyInsta `27.2.3`, channel `beta` and Android versionCode `999999999`.

Beta 3 adds Keep Unsent Messages, the Home Story organizer, Fonts & emojis, creative Direct text, Story fonts, native audio upload, first-frame/audio download choices, Story receipt/mention options, Instants controls and foreground update checks. See [release notes](https://github.com/Noctharion/MyInstaAPP/blob/main/RELEASE-NOTES.md), [Beta 3 SHA-256 checksums](https://github.com/Noctharion/MyInstaAPP/blob/main/SHA256SUMS-v27.2.3.txt), the [artifact manifest](https://github.com/Noctharion/MyInstaAPP/blob/main/RELEASE-MANIFEST-v27.2.3.json) and the [Wiki release record](https://github.com/Noctharion/MyInsta/wiki/Release-v27.2.3).

`updates.json` contains eight Beta 3 entries with exact signed-APK hashes and sizes and **empty download links**. The Beta 3 updater can display eligible update details while the links are blank; its Download button appears after a matching HTTPS link is supplied. Beta 4 uses the official API instead. Existing Beta 2 entries and artifacts are retained below; all legacy download links are now blank.

## v27.2.2 (Beta 2)

Released October 3, 2026, based on Instagram 447.0.0.55.81. Eight signed APKs cover Clone and UnClone for ARM64, ARM32, x86 and x86_64.

UnClone uses `com.instagram.android` and retains the Instagram name and icon. Clone uses `com.myinsta.android` with the MyInsta name and icon, allowing a separate installation. Choose the architecture matching your device.

See [release notes](https://github.com/Noctharion/MyInstaAPP/blob/main/RELEASE-NOTES.md) and [SHA-256 checksums](https://github.com/Noctharion/MyInstaAPP/blob/main/SHA256SUMS.txt). Enable **Include preview releases** in MyInsta's update settings to receive beta updates. A development build already identifying as v27.2.2 can be updated manually with the matching release APK.

## Release metadata and updates

`updates.json` retains the legacy release schema: version, channel, package, architecture, versionCode, changelog, signed-APK SHA-256, size and link. Final v27 prepends eight verified entries. The 20 prior Beta 5, Beta 4, Beta 3 and Beta 2 entries retain their existing metadata, with all download links blank by owner request. Final entries also record their filename, original inputVersionCode, embedded MyInsta/native version names, unknown editorial build number and final certificate. APK Android versionCode is `999999999`; it is separate from the official website's editorial release build number.

Final v27 and Beta 4/5 update checks use the public official API, select the installed Clone/UnClone variant and ABI, and accept compatible universal assets. **Automatic checks** is opt-in; when enabled, it checks on opening or returning from the background. A newer eligible release can show an Android notification and a themed **Home** announcement with patch notes and **Download / Close**. A release needs to be published with matching assets on the official website before the app can offer it. When an installed editorial build number is unknown, the app omits it from the API query and uses release-version comparison.

All four Beta 3 ABI builds passed **248 JVM tests each**. All eight final APKs applied all **17 patches** and passed signing, exact package/ABI, embedded release/update identity, 16 KB alignment, DEX preservation and serialized branch/runtime/native-reference checks. The final artifact record remains separate from ARM64 Android 16 development device evidence; fresh installation of all eight final variants was not performed in this release run. Broader device and account testing remains ongoing. The 193-test checkpoint and previously tested ARM64 payload comparison belong to the historical Beta 2 release.

## Membership

`roles.json` preserves the existing MyInsta membership list, including Internal and Verified members. Membership data is maintained independently from releases.

No Instagram credentials or GitHub access tokens are required by the app to read these public files.
