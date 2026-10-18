# MyInsta v27.0.1 (Development)

Updated October 18, 2026. Changes since v27.0.0, based on Instagram **447.0.0.55.81**. The current build identifies as **v27.0.1-dev**; this changelog does not announce a final release.

- (Fix) Removed main-thread retry sleeps when native analytics looks up generated view IDs during scrolling. Valid resource lookup, visual effects and existing controls retain their behavior.
- (Fix) Preserved native pixel precision when preparing Home post footers. Fractional display density could make preparation use a different width from the visible item, forcing layout to be repeated during scrolling. Existing margins, content updates and visual effects remain active.

- (Add) MyInsta translations follow Instagram's selected language, with English, Portuguese (Portugal and Brazil), Spanish, German and French packs.
- (Add) Translation updates without reinstalling the app.
- (Add) Independent, default-off device-local conversation-read and opened-media markers in Ghost Mode. Verified automatic observations do not generate additional receipts or alter native consumption/replay; unsupported video players retain native indicators. New incoming items stay unread, including arrivals during an older read observation. Native unread filters, aggregate counts, notifications and launcher badges retain their existing behavior.
- (Add) With local media reading enabled, explicit header Seen and inbox Mark as read actions can send real receipts and consume protected media even with Keep View-Once Media on. Reply and reaction shortcuts retain that protection; conversation reading alone does not enable the header exception. Disabling local reading does not submit its history.
- (Fix) Protected-media Download appears only for a matching full native source with a current URL lease or validated cache bytes. It preserves the existing downloader for leased sources and supports full-photo and complete, committed progressive-MP4 cache recovery. Stale IDs/URLs, thumbnails, partial bodies and unsupported adaptive, fragmented or encrypted cache sources do not qualify. A valid native lease does not guarantee later CDN delivery.
- (Add) Open Home on Following at normal startup, preserving manual feed choices and notification/link destinations.
- (Add) Optional confirmation before starting voice or video calls.
- (Add) Reel seek bar with elapsed time and duration, including short Reels.
- (Add) Video playback quality choices: Auto, Lowest, 480p, 720p, 1080p and Highest available.
- (Add) Independent full-screen modes for Home and Reels, preserving photo and video framing.
- (Add) Higher quality Story video uploads through Instagram's native preparation options.
- (Add) Original post cover downloads and media details, including author, date, caption and available resolution.
- (Add) Independent controls to hide Meta AI in Search and Messages.
- (Add) Separate controls for swipes between tabs, swipes into the camera and double-tap message reactions.
- (Add) Independent shared-link cleanup, including copied links, sharing actions and profile bio redirects.
- (Add) Separate account-suggestion controls for Search, follower lists, Reels and Stories.
- (Add) One import flow for app fonts, chat fonts, Story fonts and emoji packs.
- (Add) Clear font and emoji selectors with Instagram default, a separate native chat font choice and visible loading status.
- (Fix) Fixed startup crashes caused by invalid swipe-navigation jumps and nullable Reel metadata return types.
- (Fix) Removed additional Reel zoom and cropping caused by floating navigation.
- (Fix) Improved Gallery-to-Feed/Reels compatibility with the app's signing identity and theme lifecycle.
- (Fix) Expanded theme handling for late color changes, stateful controls, profiles and inherited Android resources.
- (Fix) Preserved custom conversation themes while applying MyInsta colors to supported default conversations.
- (Fix) Applied AMOLED colors earlier during app startup and corrected Instants background ownership.
- (Fix) Improved Liquid Glass navbar sampling, opacity and blending with visible content behind the bar.
- (Fix) Restored Glass recovery after capture errors and separated capture state between windows.
- (Fix) Reimporting fonts or emoji packs repairs damaged files, including corruption that keeps the original file size.
- (Fix) Preserved native emoji measurements to prevent extra spacing and unexpected line breaks.
- (Fix) Restored custom emoji spans after native Story editor styling while keeping Story fonts independent.
- (Fix) Improved available download sources across supported Feed, Reels, Stories and Direct media.
- (Fix) Supported compatible separate video/audio download tracks without re-encoding.
- (Fix) Improved higher-resolution photo selection while preserving the original framing.
- (Fix) Prevented unavailable videos from silently downloading as cover images.
- (Fix) Improved Direct and View-Once download source selection and refresh, with account and conversation ownership checks.
- (Fix) Restored photo and GIF download actions in supported comment menus and improved supplied GIF variant selection.
- (Fix) Removed the redundant First frame choice from Story downloads.
- (Fix) Preserved received Instagram shares in Unsent Messages and displayed their availability more accurately.
- (Fix) Extended suggestion filtering across profile cards, Story trays, Reels, Stories and Threads promotions.
- (Fix) Reorganized settings into clearer app areas and simplified the Fonts & emojis screen.
- (Fix) Prevented older translation caches from replacing newer bundled text.

All four ABI development builds (arm64-v8a, armeabi-v7a, x86_64 and x86) passed **689 JVM tests** and **19 exact-APK integration gates** each, plus separate package identity, native packaging and source provenance checks; all **17 foundation patches** load from their bundles. These APKs are unsigned and have not been installed for this validation. English and European Portuguese revision **13** each contain **1,597 entries**; the other four packs retain **1,415 translated entries** with English fallback. Host tests and serialized DEX checks cover local state, receipt/consumption separation, scoped UI hooks and supported cache sources; they do not establish installed Android rendering, live receipt behavior or download delivery. Fresh phone acceptance of this development work remains pending. Earlier ARM64 cold-start evidence belongs to its earlier artifact. Download and playback quality depend on the sources Instagram provides; Story uploads remain subject to Instagram's server compression.

**October 18 ARM64 scroll checkpoint:** 780 JVM tests and all 20 exact-APK integration gates passed for signed Clone and UnClone candidates. On one SM-F966B running Android 17 at 120 Hz, the installed UnClone's warmed scroll samples had fewer missed frame deadlines in Home, Explore and Reels; generated-ID lookup dropped from 3.3–3.8 ms to 0.043–0.176 ms with the same exception result. Current effects and controls remained active. Residual native-list and rendering stalls remain, live content varied, and some FrameTimeline tail metrics did not improve. This is a scoped improvement, not a claim of universally smooth scrolling or device acceptance of the Clone and other ABIs. The four-ABI figures above describe the earlier checkpoint.

**Home follow-up:** 781 JVM tests and all 20 integration gates passed for each updated ARM64 variant. Device traces confirmed that correcting 1078 px preparation to the actual 1080 px eliminated repeated main-thread footer layout; its maximum measurement fell from 23.576 to 0.088 ms. In a fresh Home scroll sample, p99 fell from 24 to 18 ms, but missed deadlines increased from 4.14% to 5.70%, so this does not establish an overall jank-rate improvement. Explore and Reels were checked again with effects and controls active. Live content varied, some stalls remain, and only UnClone received device validation.

The published v27.0.0 APKs and update metadata retain their existing identity. Test APK generation and source publication do not publish a release on the official website.

# MyInsta v27.0.0 (Final)

Prepared October 10, 2026, based on Instagram **447.0.0.55.81**, for Android **9 (API 28) and later**. Eight APKs cover **Clone and UnClone** for **arm64-v8a, armeabi-v7a, x86_64 and x86**. This final release consolidates the features and corrections developed through Beta 3, Beta 4 and Beta 5. Downloads and website publication are managed on the [official releases page](https://myinsta.dev/releases).

- **Ghost Mode and Direct:** independent typing, conversation Seen, Story/live and inspected view-once controls. Seen after reply and the optional in-chat Mark as seen button use the selected conversation's captured incoming boundary. When Keep View-Once Media is on, eligible media and its unopened indicator are preserved; when off, eligible incoming media already available in the native snapshot uses native consumption/store/receipt bookkeeping. Later incoming, outgoing, expired and already opened items are excluded. Seen after reacting remains a separate conversation-only option; failed or removed reactions do not send a new receipt, and removing a reaction cannot undo Seen.
- **Keep Unsent Messages:** optional local preservation after confirmed unsend, inline copies, an account-isolated searchable archive, private notifications, attachment readers and confirmed conversation cleanup. Content must already be available locally; missing or expired media is not recovered.
- **Stories:** independent normal Story, Close Friends and highlight controls; organizer order, viewed-state handling, age filters, continuous playback and exact unseen counts when native details are complete. Native Story opening stays immediate while pending Home pages load in the background. Accounts absent from a native response require a later response. Manual Story receipts and receipts after confirmed interactions remain separately configurable.
- **Alternate Story layouts:** mention indicators follow visible headers and reserve space beside the username, independently of rotating time/music/filter text. Supported Reels Stories bars, including Friends, use organizer filters and Hide tray highlights, settings/cache refresh handling and the local Reels dark palette for wrappers, padding and recycled names. The alternate highlight-cover menu is supported. The full Stories summary keeps native loading, navigation, uploading, touch and empty/error behavior; custom behavioral overrides were removed, retaining scoped colors only.
- **Download Center:** supported post, Reel, Story and Direct downloads, received voice downloads, First frame and independently visible Audio only choices, Story Photo only and carousel selection. The Prism four-action row fits its first and last actions. The separate, default-off Download comment media control adds Download media to supported photo/GIF comment menus, with supplied GIF/WebP/MP4 alternatives preserving animation. Downloads use the configured folder, queue, notifications and retry actions.
- **Fonts, emojis and audio:** independent app/chat fonts, font imports, downloadable emoji packs, native Story editor fonts and previewed creative Direct drafts. Local emoji packs preserve native text measurement and reaction rendering; they do not change transmitted Unicode or the system keyboard. Restart-required typography choices offer Restart now or Later. Upload audio in the native Direct More menu picks, previews and confirms sending to the captured conversation.
- **Instants:** six independent, default-off controls cover the new UI, photo zoom, swipe advancement, downloads, gallery upload and screenshots. Reopen Instants after changing session options.
- **Like protection:** opt-in Privacy controls independently delay new post/Reel likes by 3, 5 or 10 seconds (default 5), with optional Undo. The native heart/count updates immediately. Unlike or Undo before dispatch cancels the held request; leaving the foreground, account changes, originating-screen destruction or disabling the applicable protection cancels pending likes. Existing double-tap blockers remain independent; unknown native metadata follows the normal native path.
- **Themes and layout:** editable themes, Monet/AMOLED and separate Liquid Glass controls. Scoped corrections cover Home/video controls, Explore search/recent cards, follower categories, Subscriptions, discovery/account lists and requests, News filter categories/footer, Direct and supported rounded Reels menus. Likes-list search, names and secondary labels follow the active palette, AMOLED and row recycling while native Follow controls, avatars and actions are preserved. Home avoids repeated unrelated theme classification/drawing work. Direct conversations stay below the fixed inbox header, and Profile precedes Customize in the supported details row.
- **Privacy and content:** inspected ads/analytics/video-cache paths, independent gestures, selective recommendations, Discover people locations, Save/Repost visibility and Distraction Free controls remain separately configurable. Disable analytics also suppresses the inspected contacts/location onboarding prompts while retaining Android permission requests and manual management screens.
- **Main settings cards:** all ten cards use title, centered scene artwork and description.
- **Backup and About:** About adds Export/Import for MOD settings, theme recipes and selections; Include developer flags is unchecked by default and uses the current-account Developer Options importer/exporter. Import validates and previews the backup, attempts rollback on failure and offers Restart now or Later. Accounts, archives, downloaded media, runtime caches, font files and Android folder permissions are excluded. One Developers section credits Spartan and Bluepapilte; official Report/Releases and community links remain, with informational Source code/Wiki rows. Deprecated automatic-decryption controls are removed, while the readable mapping and validated flag import/export remain.
- **Official OTA:** installed variant and exact ABI select the official API's compatible assets. Automatic checks are opt-in and run on opening or returning from the background, once per foreground visit. Eligible newer releases can show a notification and a Home announcement with patch notes and Download/Close. Download and installation remain user actions.

## Identity and installation

The embedded MyInsta identity is **27.0.0 / v27.0.0 / stable**, with installed Android versionCode **999999999** and native Android versionName **447.0.0.55.81**. The original native versionCode is retained separately in filenames and `inputVersionCode`: ARM64 **385311922**, ARM32 **385311936**, x86_64 **385311888**, x86 **385311887**. These original codes are artifact/base metadata, not the installed override or the website editorial build number.

The final signing certificate is SHA-256 **`5f2dc419cd20d0f12ca2f0311c3be6f53f317ee7547de51d9866f0699c4ff431`**, different from Beta 5. Android cannot perform an ordinary same-package update from that earlier certificate. Export desired MOD settings before removing the earlier installation; install the matching final variant afterward. MOD backups exclude accounts, archives, media/font files and Android folder permissions. Clone and UnClone use separate packages.

No website editorial build number was supplied, so the embedded value remains **-1 (unknown)**. The updater omits `installedBuildNumber` and compares release version/channel. The official website must assign its own editorial release metadata; Android versionCode and original native versionCode must not be substituted for it.

## Verification and remaining acceptance

All four ABI bundles passed **370 JVM tests per ABI**. Each exact signed APK applied **17 patches** and passed package/ABI and embedded identity, v1/v2/v3 signature checks against the final certificate, 16 KB alignment, signing payload/DEX preservation, serialized branch/runtime/native-reference checks and scoped screen, comment-download, Like protection and Reels tray gates. Per-artifact counts are recorded in the release notes and manifest. **Fresh device acceptance of the exact final APKs remains pending.**

| Variant | ABI | Native screens | Comments | Like protection | Reels tray |
| --- | --- | ---: | ---: | ---: | ---: |
| UnClone | arm64-v8a | 3556 | 691 | 4190 | 386 |
| Clone | arm64-v8a | 3556 | 691 | 4190 | 386 |
| UnClone | armeabi-v7a | 3652 | 690 | 4250 | 286 |
| Clone | armeabi-v7a | 3652 | 690 | 4250 | 286 |
| UnClone | x86_64 | 3561 | 691 | 4187 | 386 |
| Clone | x86_64 | 3561 | 691 | 4187 | 386 |
| UnClone | x86 | 3600 | 693 | 4154 | 461 |
| Clone | x86 | 3600 | 693 | 4154 | 461 |

These checks establish source/native/serialized artifact contracts. They do not establish fresh visual acceptance of the exact final APKs, Home scroll smoothness, recipient-visible Seen/opened/replayed delivery, server-side notification behavior for cancelled likes, or every backup/storage-provider flow. Earlier ARM64 phone evidence belongs to its recorded artifact and scope. Native Stories summary loading still depends on enabled Instagram flags and available data; missing native sections are not reconstructed. Developer Flag documentation retains code-verified, name-inferred and unresolved evidence labels.

See the [Final artifact manifest](https://github.com/Noctharion/MyInstaAPP/blob/main/RELEASE-MANIFEST-v27.0.0.json), [Final SHA-256 checksums](https://github.com/Noctharion/MyInstaAPP/blob/main/SHA256SUMS-v27.0.0.txt) and [Final Wiki record](https://github.com/Noctharion/MyInsta/wiki/Release-v27.0.0). All legacy `updates.json` download links are blank by owner request. GitHub publication does not create the official website release or upload APKs. Dated beta release history follows unchanged.

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
