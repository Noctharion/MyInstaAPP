# Functional terminology constraints

The English catalogue and public context are canonical. These constraints summarize implemented presentation contracts; they do not introduce features.

| Concept | Meaning and distinctions |
|---|---|
| Local reading | Device-only conversation/read and viewed-media markers are independent. Local display does not itself send a receipt. Unsupported players retain native indicators. |
| Manual read/seen | Explicit actions can send Seen and consume eligible available view-once media. Preserve the warning about Keep View-Once Media and the local-media-reading exception. |
| Seen after reply/reaction | Requires successful completion. Removing a reaction later does not undo Seen. Reply/reaction shortcuts retain view-once protection. |
| Screenshots | Allowing capture and suppressing screenshot notification are separate controls. |
| View-once media | Opened receipts, replay receipts, continued availability and downloads are separate actions. Do not promise eternal access or retroactive recovery. |
| Unsent archive | Device-local captured received copies; not a guarantee to recover content never captured. Clearing copies does not delete Instagram originals or other people's messages. Preserve account/conversation/item scope. |
| Analytics | Known telemetry route blocking; no absolute anonymity or account-safety guarantee. |
| Like protection | Delay plus Undo before transmission, distinct from blocking double taps or hiding buttons. |
| Download / Save | Writing to the Android destination differs from Instagram's Save/bookmark library. |
| MyInsta backup / DevFlags | Separate import routes. Preserve optional flags, restart warnings and account/session checks. Replace differs from merge; preserve which side wins conflicts. |
| Donations | Optional support for the chosen named developer. No purchase or feature unlock. |
| Clipboard label | Describe the copied clip; never translate or modify the selected user's text. |
| Conversation cleanup name | In `media.unsent.remove_from` and `media.unsent.remove_count`, `{name}` is the conversation title, including a group title. The action removes that conversation's saved local copies; do not narrow it to messages from one sender or imply deletion of Instagram originals. |
| Instants screen capture | Generic screen-capture descriptions include screenshots and screen recording. Screenshot-specific DM controls retain their own scope. Reopen Instants when the setting requires it. |
| Glass input controls | The video/Story wording concerns input fields and controls over media. It does not apply the material to video pixels. Search and DM composers retain opaque material for readability. |

Preserve MyInsta, Instagram, Spartan, Bluepapilte, Ko-fi, recipient URLs, DevFlags identities, IDs, versions, hashes, protocol values and user-defined content. Choose consistent local conventions for Stories/Reels/Direct/Instants; a chosen convention is not a claim of official Instagram terminology.

Spartan: https://ko-fi.com/spartanpt

Bluepapilte: https://ko-fi.com/bluepapilte

Plural selection follows the text entry's language. English fallback uses English grammatical rules; numbers retain the effective interface locale. Target forms depend on integer counts supported by the consumer. Host plural reference used in this batch: Node 24.22.0, ICU 78.3, CLDR 48.0 ([Unicode rules](https://unicode.org/cldr/charts/48/supplemental/language_plural_rules.html)); this is not evidence of a particular Android ICU version.
