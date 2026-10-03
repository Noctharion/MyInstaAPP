# MyInsta

Public release and membership metadata maintained by Noctharion. Application source code is maintained separately.

## v27.2.2 (Beta 2)

Released October 3, 2026, based on Instagram 447.0.0.55.81. Eight signed APKs cover Clone and UnClone for ARM64, ARM32, x86 and x86_64.

UnClone uses `com.instagram.android` and retains the Instagram name and icon. Clone uses `com.myinsta.android` with the MyInsta name and icon, allowing a separate installation. Choose the architecture matching your device.

| Architecture | UnClone (Instagram) | Clone (MyInsta) |
| --- | --- | --- |
| arm64-v8a | [Download](https://mega.nz/file/0bpgyBIA#YtYdKD1r38IDSod5vQM6UM4kpW4L3CV4FJLp1ZQ4ZOI) | [Download](https://mega.nz/file/hTRnBQBK#AX6ikAD8SL7CkJsVN636-yKQ4c6cHkmR_p7JTmHrfxU) |
| armeabi-v7a | [Download](https://mega.nz/file/Ib4jQCyD#zEO34mS9ffrP9ivcJQyGoHHHl0kgSEai1bjoXl5gzmc) | [Download](https://mega.nz/file/tGxSATID#CADGfD9UW-mA4CVcmUE3vfMJoN-_zVUStrldBwaaIEA) |
| x86 | [Download](https://mega.nz/file/4bYXUKLS#Mf6vOzUeA5OigmGD74RCDu9nCQ2LDTA02DfyX5O1xH0) | [Download](https://mega.nz/file/5ThR0a7K#YqkIoNxfi-5m_86-Aaw2lzbbXSKk64T5RrdKkOb0Rug) |
| x86_64 | [Download](https://mega.nz/file/xDxUDKLS#AtmnhOps_CSM0vbKH6ZdSW0ZaG76ZZU5tmHyPH4sxxM) | [Download](https://mega.nz/file/JOQERZYa#dsbNtD65uct1zk4ji-4EuO2OLm-nT3fW2ntE-DH1WKM) |

See [release notes](https://github.com/Noctharion/MyInstaAPP/blob/main/RELEASE-NOTES.md) and [SHA-256 checksums](https://github.com/Noctharion/MyInstaAPP/blob/main/SHA256SUMS.txt). Enable **Include preview releases** in MyInsta's update settings to receive beta updates. A development build already identifying as v27.2.2 can be updated manually with the matching release APK.

## Update feed

`updates.json` is the app's OTA feed. Each of the eight entries identifies version `27.2.2`, channel `beta`, package, architecture, versionCode, changelog and HTTPS download link, with the signed APK's SHA-256 and size. All eight use Android versionCode `999999999`. Update checks match the installed package, architecture and selected release channel.

All four builds passed 193 JVM tests. All eight APKs passed signing, package/ABI, embedded update identity, 16 KB alignment, DEX preservation and serialized runtime/native-reference checks. The ARM64 UnClone DEX, manifest and resources match the previously tested Android 16 build. Broader device and account testing remains ongoing.

## Membership

`roles.json` preserves the existing MyInsta membership list, including Internal and Verified members. Membership data is maintained independently from releases.

No Instagram credentials or GitHub access tokens are required by the app to read these public files.
