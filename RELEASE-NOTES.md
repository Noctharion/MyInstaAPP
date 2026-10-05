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
