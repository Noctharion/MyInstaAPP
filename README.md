# MyInsta

Public release and membership metadata maintained by Noctharion. Application source code is maintained separately.

## Releases

The OTA feed currently offers **V27 beta 1** through eight entries: Instagram and MyInsta clone packages for arm64-v8a, armeabi-v7a, x86 and x86_64. Use each entry's download link. V27 beta 2 remains in development and has no published OTA entry.

`updates.json` is the app's OTA feed. Each published entry identifies its version, channel (`stable`, `beta`, `alpha`, or `rc`), package, architecture, changelog and HTTPS download link, with the APK's SHA-256 and size. Publish only tested artifacts and keep the metadata consistent with the APK. An empty `releases` list means no release is offered. The app filters preview channels and does not offer older versions as updates.

## Membership

`roles.json` preserves the existing MyInsta membership list at migration, including Internal and Verified members. Group keys and username values remain unchanged. Future membership changes are controlled here.

No Instagram credentials or GitHub access tokens are required by the app to read these public files.
