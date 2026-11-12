# MyInsta

Public release and membership metadata maintained by Spartan. Application source code is maintained separately.

## Releases and channels

MyInsta builds belong to one of four channels: **Dev** (development and test builds), **Alpha**, **Beta** and **Stable**. The channel is part of the release name, for example **v27.1.0 Beta 1**; the version number no longer encodes a channel, and release candidates are no longer a separate channel. Stable and Dev builds can also be offered the latest beta. An Alpha or Beta build replaced by a newer build of its channel, or by a Beta or Stable release of the same or a newer version, asks to be updated.

The latest stable release is **v27.0.2**; the next release is **v27.1.0 Beta 1**. Downloads, release notes and checksums for current releases are published on the [official website](https://myinsta.dev/releases), and the app checks `https://myinsta.dev/api/version`. The v27.0.0 record below is the stable release published in this repository. Superseded beta records (v27.2.2 to v27.2.5, from the earlier numbering in which the middle number marked a beta) and the v27.0.1 development notes were removed; they remain in the Git history.

## Translations

MyInsta's own interface follows Instagram's chosen language. The authoring source in [translations/](translations/README.md) has **3,082 entries** (3,017 strings and 65 plurals) at revision **10**; English and European Portuguese are bundled in the app, and all 48 other language files are complete and published as downloadable packs (revision 7). Contributors can use the [JSON template](translations/contribute/template.json), [contribution guide](translations/CONTRIBUTING.md) and the standalone tools without private-source access.

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

See the [release notes](https://github.com/Noctharion/MyInstaAPP/blob/main/RELEASE-NOTES.md), [Final SHA-256 checksums](https://github.com/Noctharion/MyInstaAPP/blob/main/SHA256SUMS-v27.0.0.txt), [artifact manifest](https://github.com/Noctharion/MyInstaAPP/blob/main/RELEASE-MANIFEST-v27.0.0.json) and [Final Wiki record](https://github.com/Noctharion/MyInstaAPP/blob/main/RELEASE-NOTES.md). GitHub publication does not create a website release or upload APKs. All `updates.json` download links are empty by owner request; app OTA uses the official API.

## Release metadata and updates

`updates.json` is legacy release metadata in the original schema (version, channel, package, architecture, versionCode, changelog, signed-APK SHA-256, size and link). It lists the eight v27.0.0 stable APKs with their filename, original inputVersionCode, embedded MyInsta/native version names, unknown editorial build number and certificate; download links are blank by owner request. APK Android versionCode is `999999999`; it is separate from the official website's release build number. The app does not read this file: it uses the official API, selects the installed Clone/UnClone variant and ABI, and can download, verify and install official APKs in the app. A release needs to be published with matching assets on the official website before the app can offer it.

## Membership

`roles.json` preserves the existing MyInsta membership list, including Internal and Verified members. Membership data is maintained independently from releases.

No Instagram credentials or GitHub access tokens are required by the app to read these public files.
