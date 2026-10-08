# MyInsta

Public release and membership metadata maintained by Spartan. Application source code is maintained separately.

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

`updates.json` contains eight Beta 3 entries with exact signed-APK hashes and sizes and **empty download links**. The Beta 3 updater can display eligible update details while the links are blank; its Download button appears after a matching HTTPS link is supplied. Beta 4 uses the official API instead. Existing Beta 2 entries, links and artifacts are retained below.

## v27.2.2 (Beta 2)

Released October 3, 2026, based on Instagram 447.0.0.55.81. Eight signed APKs cover Clone and UnClone for ARM64, ARM32, x86 and x86_64.

UnClone uses `com.instagram.android` and retains the Instagram name and icon. Clone uses `com.myinsta.android` with the MyInsta name and icon, allowing a separate installation. Choose the architecture matching your device.

See [release notes](https://github.com/Noctharion/MyInstaAPP/blob/main/RELEASE-NOTES.md) and [SHA-256 checksums](https://github.com/Noctharion/MyInstaAPP/blob/main/SHA256SUMS.txt). Enable **Include preview releases** in MyInsta's update settings to receive beta updates. A development build already identifying as v27.2.2 can be updated manually with the matching release APK.

## Release metadata and updates

`updates.json` retains the legacy release schema: version, channel, package, architecture, versionCode, changelog, signed-APK SHA-256, size and link. Beta 4 adds only the two ARM64 variants. All eight Beta 3 entries and all eight Beta 2 entries remain unchanged, including existing links. APK Android versionCode is `999999999`; it is separate from the official website's editorial release build number.

Beta 4 update checks use the public official API, select the installed Clone/UnClone variant and ABI, and accept compatible universal assets. **Automatic checks** is opt-in; when enabled, it checks on opening or returning from the background. A newer eligible release can show an Android notification and a themed **Home** announcement with patch notes and **Download / Close**. A release needs to be published with matching assets on the official website before the app can offer it. When an installed editorial build number is unknown, the app omits it from the API query and uses release-version comparison.

All four Beta 3 ABI builds passed **248 JVM tests each**. All eight final APKs applied all **17 patches** and passed signing, exact package/ABI, embedded release/update identity, 16 KB alignment, DEX preservation and serialized branch/runtime/native-reference checks. The final artifact record remains separate from ARM64 Android 16 development device evidence; fresh installation of all eight final variants was not performed in this release run. Broader device and account testing remains ongoing. The 193-test checkpoint and previously tested ARM64 payload comparison belong to the historical Beta 2 release.

## Membership

`roles.json` preserves the existing MyInsta membership list, including Internal and Verified members. Membership data is maintained independently from releases.

No Instagram credentials or GitHub access tokens are required by the app to read these public files.
