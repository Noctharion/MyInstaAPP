# MyInsta

Public release and membership metadata maintained by Noctharion. Application source code is maintained separately.

## Releases

Installable APKs will be published in GitHub Releases. No APK release has been published here yet.

`updates.json` is the app's OTA feed. An empty `releases` list means no release is currently offered. Each published entry uses `version`, `channel` (`stable`, `beta`, `alpha`, or `rc`), `package`, `architecture`, `changelog`, and an HTTPS `link` to its release asset. Publish only tested artifacts and keep the metadata consistent with the APK. The app filters preview channels and does not offer older versions as updates.

## Membership

`roles.json` preserves the existing MyInsta membership list at migration, including Internal and Verified members. Group keys and username values remain unchanged. Future membership changes are controlled here.

No Instagram credentials or GitHub access tokens are required by the app to read these public files.