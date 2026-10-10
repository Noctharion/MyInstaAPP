# MyInsta v27.2.5 (Beta 5)

Prepared October 10, 2026, based on Instagram **447.0.0.55.81**. **Clone and UnClone for arm64-v8a only**; other architectures are reserved for the final release. These updated APKs include the additional likes-list theme correction from source checkpoint [7ebd9ac](https://github.com/Noctharion/MyInsta/commit/7ebd9acef1b98eac24c99671992417bf9850754e). Their internal About label remains **`v27.2.5-dev`**, while the OTA release identity is **`27.2.5 / beta`**. Downloads are managed on the [official releases page](https://myinsta.dev/releases).

- **Like protection:** new opt-in controls in Privacy delay new post and Reel likes by 3, 5 or 10 seconds (default 5), with separate post/Reel switches and an optional Undo notice. The native heart updates immediately; unliking before the timer expires cancels the held request. Leaving the app, switching accounts, closing the originating screen or disabling protection cancels pending likes. Existing double-tap blockers remain independent.
- **Comment media downloads:** Download Center adds a separate, default-off Download comment media option. Long-press a photo or GIF comment and choose Download media. The available animated file is preserved, with GIF, WebP or MP4 choices when supplied by Instagram.
- **Settings backup:** About adds Export and Import for MOD settings, themes and selections. Include developer flags is unchecked by default; when selected, saved overrides for the current account use the existing Developer Options importer. Import validates and previews the file, then offers Restart now or Later. Font/emoji files, media, accounts and Android folder permissions are not included.
- **Direct receipts:** Mark as seen and Seen after reply now update eligible incoming view-once/replayable media already present in the native conversation store when Keep View-Once Media is off. With protection on, the chat can be marked seen while those media and their unopened indicator are preserved. Later incoming messages stay outside the captured read boundary; reaction receipts remain independent.
- **Direct layout and emoji:** conversation lists stay below the pinned inbox header; custom emoji packs preserve native text measurement; Profile precedes Customize in the alternate conversation-details shortcut row.
- **Stories and Reels:** mention indicators follow the visible Story header, including rotating secondary information. Organizer filters and Hide tray highlights cover Friends Story trays; their names, padding and recycled items use the local Reels dark palette. The experimental Stories summary page retains native loading and navigation behavior; its custom behavioral override was removed, with color handling retained.
- **Themes and Home:** expanded native coverage for recent-search cards, follower categories, Discover people sections and requests, Explore accounts and rotating search hints, News filter categories/footer, and rounded Reels menus. Repeated Home theme work is reduced during mounting and drawing. These changes target the reported native layouts; fresh visual confirmation of the latest changes is still pending.
- **Likes list colors:** the list of people who liked a post uses the active palette for its page, search field, names and secondary labels. Theme and AMOLED changes update these colors, including recycled rows, while native Follow controls, avatars and actions retain their behavior. Fresh device appearance confirmation of this correction remains pending.
- **About and developer tools:** a single Developers section lists Spartan and Bluepapilte. The original-developer subtitle omits the redundant Instagram handle and retains its profile link. Current-account tracking survives stale Activity teardown and account changes.

The release bundle passed **370 JVM tests**. The production people renderer passed **198 checks across 25 cases**, including likes-list palette, lifecycle and row-recycling checks and the inner-row overlay regression. Both signed APKs applied all **17 patches** and passed exact package/ABI and embedded identity, established-certificate v1/v2/v3 signature checks, 16 KB alignment and signing payload preservation. Each APK passed **3,556 native screen checks**, serialized checks over **1,756,766 conditional branches**, **14,169 host calls / 327 runtime entry points**, and **588 native references / 466 unique references**. The scoped comment-download, Like protection and Reels tray results are recorded in the artifact manifest.

These checks do not establish fresh visual acceptance of the exact APKs, live receipt delivery or server-side notification behavior. The experimental Stories summary's native loading depends on Instagram's enabled flags and available data. No website editorial build number was supplied: the embedded value remains **`-1`**, and the updater compares release version/channel rather than Android versionCode. Source development moves to **v27.0.0 final** separately from these Beta 5 artifacts.

See the [artifact manifest](https://github.com/Noctharion/MyInstaAPP/blob/main/RELEASE-MANIFEST-v27.2.5.json), [SHA-256 checksums](https://github.com/Noctharion/MyInstaAPP/blob/main/SHA256SUMS-v27.2.5.txt) and [Beta 5 Wiki record](https://github.com/Noctharion/MyInsta/wiki/Release-v27.2.5). Website release creation and APK uploads remain separate from repository publication. Beta 4 and earlier release history follows.

# MyInsta v27.2.4 (Beta 4)

Prepared October 9, 2026. Based on Instagram **447.0.0.55.81**. **Clone and UnClone for arm64-v8a only**; other architectures are reserved for the final release. The release identity is `27.2.4 / beta`, with the established signing certificate. Downloads are managed on the [official releases page](https://myinsta.dev/releases).

- **Ghost Mode:** independent, default-off **Seen after reacting** and **Mark as seen button** options under **Remove Seen Status**. Successful reaction additions/changes can send the conversation receipt; removals and failures do not. Removing a reaction cannot undo Seen. The in-chat double-check button preserves all view-once media while **Keep View-Once Media** is enabled; otherwise it also explicitly marks eligible incoming view-once/replayable media as seen. The existing inbox action remains independent.
- **DM reaction emojis:** locally displayed and received reactions follow the selected emoji style without changing the transmitted reaction.
- **Developer Flag layouts:** fit all four Prism overflow actions without clipping; show mentions in the Compose Story header; apply Story organizer filters and Hide tray highlights to the experimental Reels Stories bar; offer the highlight-cover viewer in the alternate profile long-press menu.
- **Themes:** active colors apply to the Themes screen, Home suggestions, video algorithm footer, Explore recent searches, follower/following search and sorting, Subscriptions, and Direct filters/counters. The pinned Direct filter row replaces the inline row during scrolling. AMOLED preserves native action states and styles, with explicit control-color edits respected.
- **Settings:** matching scene artwork for all ten main cards, centered between the title and description.
- **Privacy:** Disable analytics also suppresses the inspected contacts/location onboarding prompts while retaining Android permission requests and manual management screens.
- **Updates:** official APK update API, installed variant/ABI matching, opt-in foreground checks, and a Home announcement with patch notes and Download/Close alongside Android notifications. Download and installation remain user actions.
- **About and developer tools:** official Report/Releases links, Spartan maintainer and community links, original-developer Instagram credit, and informational Source code/Wiki rows. Obsolete automatic-decryption controls are removed; native metadata, the bundled JSON mapping and experiment import/export remain available. The Wiki adds a practical Developer Flags guide and complete reference with explicit evidence labels.

The native-flag integration experiment was removed. MyInsta follows the active native layout without automatically enabling these layout flags. Phone captures identified layouts; they do not validate the changed release APK. Fresh visual acceptance, recipient-visible receipts, the Home update announcement and the reported onboarding prompts remain pending owner testing. Server delivery and offline receipt behavior remain dependent on Instagram. GitHub metadata publication does not publish the official website release.

The final ARM64 bundle passed **347 JVM tests**. Both signed APKs applied all **17 patches** and passed exact package/ABI and release identity, established-certificate signature, 16 KB alignment, DEX/runtime payload preservation and serialized branch/native-reference gates. See the [artifact manifest](https://github.com/Noctharion/MyInstaAPP/blob/main/RELEASE-MANIFEST-v27.2.4.json), [SHA-256 checksums](https://github.com/Noctharion/MyInstaAPP/blob/main/SHA256SUMS-v27.2.4.txt) and [Beta 4 Wiki record](https://github.com/Noctharion/MyInsta/wiki/Release-v27.2.4). Beta 3 and Beta 2 history follows.

# MyInsta v27.2.3 (Beta 3)

Prepared October 5, 2026. Based on Instagram **447.0.0.55.81**, with Clone and UnClone APKs for **arm64-v8a, armeabi-v7a, x86_64 and x86**. Download links are pending. Beta 3 metadata is published with blank links; eligible update details can appear, and the Download action becomes available when a matching link is supplied.

- **Keep Unsent Messages:** optional local preservation of supported received messages after a confirmed unsend, with inline copies, searchable account-isolated archive, private notifications, attachment readers and confirmed conversation cleanup.
- **Story organizer:** account order, viewed-account handling, Close Friends account selection, Story age, continuous playback and exact unseen counts. Native opening stays immediate; pending native Home pages complete in the background and counters refresh without scrolling.
- **Fonts & emojis:** independent app/chat fonts, Inter/Roboto/Nunito/Lora/Caveat presets, text and color-emoji font import, and downloadable Facebook/JoyPixels/Samsung/iOS emoji styles. Restart applies app/chat/emoji changes.
- **Creative text and Story fonts:** preview explicit styled characters in a Direct draft before sending, or add library fonts to Instagram's Story editor. Local chat font appearance remains independent from transmitted text.
- **Anonymous Story Viewing:** separate optional **Mark as seen** and receipt after a successful like, reaction or reply, restricted to the selected Story and account. Both default off.
- **Story mentions:** optional tappable **@N** below native metadata, configured under **View Story mentions → options** and off by default.
- **Direct audio:** **Upload audio** in the native More menu, with audio-only picking, preview and confirmed native voice sending. Supported received voice messages also have Download.
- **Downloads:** **First frame** and optional **Audio only** advanced video choices across supported Stories, Reels, posts, carousels and Direct. Story **Photo only** remains a separate supplied-image choice.
- **Instants:** independent new UI, photo zoom, swipe advance, download, gallery upload and screenshot controls, all off by default.
- **Updates and settings:** checks on opening/returning from the background, persistent once-per-version notifications, separate conversation receipt options, distinct control icons and improved indicator placement.
- **Developer tools:** experiment files validate before import, merge by parameter, preserve reserved sections and export with readable version/date filenames.

The Story organizer uses the native Home response. An account omitted by Instagram can require a later native response; this release does not guarantee immediate discovery of every new Story. Emoji styles render locally inside MyInsta and do not change Samsung/Gboard. Unsent preservation requires locally available content and does not recover missing media after unsend.

Final artifact checks and the exact APK matrix are recorded in the [Wiki](https://github.com/Noctharion/MyInsta/wiki/Release-v27.2.3). Functional device evidence covers recorded ARM64 Android 16 development checkpoints; it does not imply fresh final-APK installation or full live coverage on every ABI/account. Report the architecture, variant and reproduction steps with any issue.

# MyInsta v27.2.2 (Beta 2)

- New Appearance section with themes, native navigation ordering, recommendations and button visibility controls.
- Eight editable theme presets, Monet and AMOLED, five-color Story rings, live preview, undo/cancel, and theme import/export.
- Expanded theme coverage across profiles, inbox, search, notifications, native settings and conversation details.
- Separate Liquid Glass controls for supported areas, with independent material settings for Monet and Instagram default.
- Improved Reels playback-bar clearance, contextual Reel layout and inbox Instants spacing with Glass navigation.
- Independent Discover people controls for Home, profiles, inbox and Notifications; separate filters for suggested content categories.
- Separate Save and Repost visibility controls for Feed, posts and Reels, including Reel counters.
- Improved Home, Following and Favorites ad filtering, with correct feed completion when every available post is filtered.
- Pull-to-refresh blocking now also covers Explore and retains normal scrolling.
- Floating profile-photo viewer on long press, with native taps and your own profile-photo actions preserved.
- Profile photos use the profile display name, and highlight covers use the highlight title.
- Improved external Instagram link handoff for UnClone builds.
- More consistent English settings text, themed menu outlines and search results.
- Numeric release naming: v27.2.2 identifies Beta 2; preview updates remain controlled by Include preview releases.

Based on Instagram 447.0.0.55.81. Clone and UnClone builds are available for ARM64, ARM32, x86 and x86_64. Broader device and account testing remains ongoing; report the architecture, variant and reproduction steps with any issue.
