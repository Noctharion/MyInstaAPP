# MyInsta

Public release and membership metadata maintained by Noctharion. Application source code is maintained separately.

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

`updates.json` contains eight Beta 3 entries with exact signed-APK hashes and sizes and **empty download links**. The app can display eligible Beta 3 update details or notify about the release while the links are blank; its Download button appears after the matching HTTPS link is supplied. Enable **Include preview releases** to include beta updates. Existing Beta 2 entries, links and artifacts are retained below.

## v27.2.2 (Beta 2)

Released October 3, 2026, based on Instagram 447.0.0.55.81. Eight signed APKs cover Clone and UnClone for ARM64, ARM32, x86 and x86_64.

UnClone uses `com.instagram.android` and retains the Instagram name and icon. Clone uses `com.myinsta.android` with the MyInsta name and icon, allowing a separate installation. Choose the architecture matching your device.

See [release notes](https://github.com/Noctharion/MyInstaAPP/blob/main/RELEASE-NOTES.md) and [SHA-256 checksums](https://github.com/Noctharion/MyInstaAPP/blob/main/SHA256SUMS.txt). Enable **Include preview releases** in MyInsta's update settings to receive beta updates. A development build already identifying as v27.2.2 can be updated manually with the matching release APK.

## Update feed

`updates.json` is the app's OTA feed. Its Beta 3 entries identify version `27.2.3`, channel `beta`, package, architecture, versionCode and changelog, with the signed APK's SHA-256 and size. Only the Beta 3 `link` fields remain blank. The eight preserved Beta 2 entries identify version `27.2.2` and retain their existing links, hashes and sizes. All use Android versionCode `999999999`. Update checks match the installed package, architecture and selected release channel.

All four Beta 3 ABI builds passed **248 JVM tests each**. All eight final APKs applied all **17 patches** and passed signing, exact package/ABI, embedded release/update identity, 16 KB alignment, DEX preservation and serialized branch/runtime/native-reference checks. The final artifact record remains separate from ARM64 Android 16 development device evidence; fresh installation of all eight final variants was not performed in this release run. Broader device and account testing remains ongoing. The 193-test checkpoint and previously tested ARM64 payload comparison belong to the historical Beta 2 release.

## Membership

`roles.json` preserves the existing MyInsta membership list, including Internal and Verified members. Membership data is maintained independently from releases.

No Instagram credentials or GitHub access tokens are required by the app to read these public files.
