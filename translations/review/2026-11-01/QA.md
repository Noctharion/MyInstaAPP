# Translation QA: settings reorganization delta (119 keys × 43 locales)

Reviewer: independent QA pass, 2026-11-01. Scope: the `new` + `changed` keys of `delta.json`, in the 43 distinct locales under `translations/source/`. Identity copies, en, pt-PT and context.json were not edited.

## Counts

| Severity | Findings | Values corrected |
|---|---|---|
| CRITICAL | 0 | 0 |
| HIGH | 4 | 7 |
| MEDIUM | 38 | 41 |
| LOW (left as is) | ~20 | 0 |
| **Total corrected** | | **48** |

Values corrected per locale: ar 1, bn 1, de 1, el 3, es 3, fr 1, gu 1, he 1, hr 3, hu 2, id 1, it 1, kn 1, ko 2, mr 2, nb 2, pt-BR 2, ro 1, sr 3, sv 1, te 1, th 4, tl 1, tr 1, uk 3, vi 2, zh-CN 1, zh-HK 1, zh-TW 1. The other 14 locales had no changes: af bg cs da fa fi hi ja ms nl pl ru sk ta.

## HIGH (fixed)

- **vi** Ghost page “Ẩn” means “Hide” and is the verb in many rows (“Ẩn nút…”). Changed to the catalogue's own term “Chế độ ẩn”, and updated the Messages summary that quotes it.
- **nb** Messages page had two sections called SAMTALER (conversations and calls). Calls is now ANROP, and the Messages caption says “anrop”. “Samtale” stays for chats, as in “Skjulte samtaler”.
- **he** Messages page had two sections called שיחות. Calls is now “שיחות קוליות ווידאו”.
- **es** The Feed page title “Inicio” was the same word as its own HOME section, INICIO. It is now “Feed” (the catalogue already uses “feed”), and “feed” was added to its aliases.

## MEDIUM (fixed)

- **Page names**: ar Unsent title “الملغى إرسالها” was a fragment. It is now the convention name “الرسائل الملغى إرسالها”, which the Messages summary already quoted. th Focus “สมาธิ” is now “โฟกัส” and uk “Зосередженість” is now “Фокус”; the old words were kept as aliases.
- **Heading collisions**: the BROWSING home heading used the same word as the Appearance NAVIGATION section in es, pt-BR, ro and tr. It is now CONTENIDO / CONTEÚDO / CONȚINUT / İÇERİK, in line with nb “INNHOLD”.
- **Wrong meaning**: el CACHE heading “ΜΝΗΜΗ ΕΝΔΙΑΜΕΣΗΣ” was a truncated phrase. It is now the catalogue term “ΚΡΥΦΗ ΜΝΗΜΗ”, in the heading and the Downloads caption. zh-CN/HK/TW LIBRARY on the Emoji page said “font library” (字库/字體庫/字型庫). It is now 资源库/資源庫.
- **Quoted names must match exactly**: in uk, hr, sr, bn, th, te and mr the Messages summary inflected or merged the Ghost/Unsent page names. They are now quoted exactly: uk «…», hr/sr “na stranici …”, and quote marks in bn/th/te/mr. The `fonts.emoji_choice_more` quote of “App emoji” was fixed the same way in hr, sr and mr.
- **Labels and grammar**: de „Aktiv“ is now Instagram's „Gerade aktiv“. hu article “az „Most aktív”” is now “a „Most aktív””. sr “Активни сте сада” (“you are active now”) is now ознаку „Активно сада“. hr “MyInstaine” and el “τα δικά του του MyInsta” were reworded. pt-BR “Pinça para ampliar” is now “Pinçar para ampliar”. tl “Kung paano mukhang Instagram” is now “Ang hitsura ng Instagram”.
- **Ambiguous “Receipts” in the Ghost caption**: fr “Accusés” is now “Accusés de lecture”, ko “확인” is now “읽음 확인”, sv “Kvitton” is now “Läskvitton”, and th “ใบอ่านแล้ว” is now the catalogue term “ใบตอบรับการอ่าน”.
- **Aliases missing the former page name**: added the old translated title in gu, hu and kn (Distraction Free) and in id, it and ko (Unsent Messages).

## LOW (left, for the owner to decide if wanted)

- **hr Feed “Sažetak”**: literally “summary”, but it is the hr catalogue's word for feed in every string. Changing it would mean a catalogue-wide rename.
- **cs Feed “Kanál příspěvků”**: long, but plain “Kanál” would clash with “kanály” (broadcast channels).
- **Long Unsent titles**: fr, gu, he, hi, hr, hu, id and kn keep the full name. Each matches its catalogue's recorded convention; gu (“મોકલવાનું રદ કરેલા સંદેશ”) and he (“הודעות ששליחתן בוטלה”) are the longest.
- **bn Unsent “পাঠানো বাতিল”**: reads like an action label, but it equals the existing `media.unsent.unsent` label.
- **AI headings**: hr “UI” and hu “MI” are the standard abbreviations in those languages.
- **sr Ghost “Невидљиви”**: an adjective form, short and acceptable.
- **mr ACTIVITY “कृती”**: matches the existing ACTIVITY & RECEIPTS heading.
- **Same word for two headings on different screens**: nl BERICHTEN (messages/posts), th ข้อความ (messages/text), fi JULKAISUT (releases/posts). These are catalogue conventions.
- **Wording that could be tighter**: da “BROWSING” (English), sv “BLÄDDRA” (a verb), it “NAVIGAZIONE DEI CONTENUTI” (long), tl “Pokus”, ja 「アクティブ」, sk “Aktívny teraz” (masculine only), and ta inflects the quoted page names. The fr Feed summary drops “play” (se lire covers it).
- **English words in aliases**: some locales add the English words and others don't. Both are allowed.

## Follow-up needed

The fixes touched base locales that have identity copies. These now differ from their identity files and need re-copying (only `locale` should differ):

- zh-Hans-CN, zh-Hant-HK, zh-Hant-TW: `fonts.section.library`
- sr-Cyrl-RS: `settings.hide_active_status.summary`, `settings.messages_settings.summary`, `fonts.emoji_choice_more`
- fil-PH: `settings.personalization_settings.summary`

## Verification

`qa_fix.py` loads each file and rewrites it with json (ensure_ascii=False, indent=2, LF, trailing newline). A no-op round trip was byte-identical on all 43 files before any edit.

After the edits, all 43 files were compared with a pre-QA snapshot (`preqa/`):

- Only delta keys changed. Headers (including `revision`) and key order are unchanged.
- The key set equals en.json strings (2129 keys).
- Placeholders and newline counts match English for every key.
- In every locale, the Messages summary contains that locale's Ghost and Unsent titles, and `fonts.emoji_choice_more` contains its `fonts.app_emoji` label.

Result: ALL OK.

## Final short page names

| locale | Ghost | Unsent | Downloads | Focus | Feed | Help | Fonts | Emoji |
|---|---|---|---|---|---|---|---|---|
| af | Spook | Teruggetrek | Aflaaie | Fokus | Stroom | Hulp | Lettertipes | Emoji |
| ar | الشبح | الرسائل الملغى إرسالها | التنزيلات | التركيز | الخلاصة | المساعدة | الخطوط | الرموز التعبيرية |
| bg | Призрак | Оттеглени | Изтегляния | Фокус | Емисия | Помощ | Шрифтове | Емоджи |
| bn | ঘোস্ট | পাঠানো বাতিল | ডাউনলোড | ফোকাস | ফিড | সহায়তা | ফন্ট | ইমোজি |
| cs | Duch | Odvolané | Stahování | Soustředění | Kanál příspěvků | Nápověda | Písma | Emoji |
| da | Spøgelse | Tilbagekaldt | Downloads | Fokus | Feed | Hjælp | Skrifttyper | Emojis |
| de | Geist | Zurückgerufen | Downloads | Fokus | Feed | Hilfe | Schriften | Emojis |
| el | Φάντασμα | Ανακληθέντα | Λήψεις | Εστίαση | Ροή | Βοήθεια | Γραμματοσειρές | Emoji |
| es | Fantasma | Anulados | Descargas | Enfoque | Feed | Ayuda | Fuentes | Emojis |
| fa | روح | لغو ارسال | بارگیری‌ها | تمرکز | فید | راهنما | قلم‌ها | شکلک‌ها |
| fi | Haamu | Perutut | Lataukset | Keskittyminen | Syöte | Ohje | Fontit | Emojit |
| fr | Fantôme | Messages retirés | Téléchargements | Concentration | Fil | Aide | Polices | Emojis |
| gu | ઘોસ્ટ | મોકલવાનું રદ કરેલા સંદેશ | ડાઉનલોડ | ફોકસ | ફીડ | મદદ | ફૉન્ટ | ઇમોજી |
| he | רפאים | הודעות ששליחתן בוטלה | הורדות | ריכוז | פיד | עזרה | גופנים | אימוג'י |
| hi | घोस्ट | वापस लिए गए संदेश | डाउनलोड | फ़ोकस | फ़ीड | मदद | फ़ॉन्ट | इमोजी |
| hr | Nevidljivost | Povučene poruke | Preuzimanja | Fokus | Sažetak | Pomoć | Fontovi | Emojiji |
| hu | Szellem | Visszavont üzenetek | Letöltések | Fókusz | Hírfolyam | Súgó | Betűtípusok | Emojik |
| id | Hantu | Pesan Ditarik | Unduhan | Fokus | Feed | Bantuan | Font | Emoji |
| it | Fantasma | Invio annullato | Download | Concentrazione | Feed | Assistenza | Caratteri | Emoji |
| ja | ゴースト | 送信取り消し | ダウンロード | 集中 | フィード | ヘルプ | フォント | 絵文字 |
| kn | ಘೋಸ್ಟ್ | ಹಿಂಪಡೆದ ಸಂದೇಶಗಳು | ಡೌನ್‌ಲೋಡ್‌ಗಳು | ಫೋಕಸ್ | ಫೀಡ್ | ಸಹಾಯ | ಫಾಂಟ್‌ಗಳು | ಇಮೋಜಿ |
| ko | 고스트 | 전송 취소 | 다운로드 | 집중 | 피드 | 도움말 | 글꼴 | 이모지 |
| mr | घोस्ट | मागे घेतलेले | डाउनलोड | फोकस | फीड | मदत | फॉन्ट | इमोजी |
| ms | Hantu | Ditarik Balik | Muat turun | Fokus | Suapan | Bantuan | Fon | Emoji |
| nb | Spøkelse | Tilbakekalte | Nedlastinger | Fokus | Feed | Hjelp | Skrifttyper | Emoji |
| nl | Spook | Ingetrokken | Downloads | Focus | Feed | Hulp | Lettertypen | Emoji |
| pl | Duch | Cofnięte | Pobieranie | Skupienie | Kanał | Pomoc | Czcionki | Emoji |
| pt-BR | Fantasma | Envio cancelado | Downloads | Foco | Feed | Ajuda | Fontes | Emojis |
| ro | Fantomă | Retrase | Descărcări | Concentrare | Flux | Ajutor | Fonturi | Emojiuri |
| ru | Невидимка | Отозванные | Скачивание | Фокус | Лента | Помощь | Шрифты | Эмодзи |
| sk | Duch | Odvolané | Sťahovanie | Sústredenie | Kanál | Pomoc | Písma | Emoji |
| sr | Невидљиви | Повучене | Преузимања | Фокус | Фид | Помоћ | Фонтови | Емоџији |
| sv | Spöke | Återkallade | Nedladdningar | Fokus | Flöde | Hjälp | Teckensnitt | Emoji |
| ta | மறைநிலை | திரும்பப் பெறப்பட்டவை | பதிவிறக்கங்கள் | கவனம் | ஊட்டம் | உதவி | எழுத்துருக்கள் | எமோஜி |
| te | ఘోస్ట్ | వెనక్కి తీసుకున్నవి | డౌన్‌లోడ్‌లు | ఏకాగ్రత | ఫీడ్ | సహాయం | ఫాంట్‌లు | ఎమోజీ |
| th | ผี | ยกเลิกส่ง | ดาวน์โหลด | โฟกัส | ฟีด | ความช่วยเหลือ | แบบอักษร | อีโมจิ |
| tl | Multo | Binawi | Mga download | Pokus | Feed | Tulong | Mga font | Emoji |
| tr | Hayalet | Geri alınanlar | İndirmeler | Odak | Akış | Yardım | Yazı tipleri | Emoji |
| uk | Невидимка | Відкликані | Завантаження | Фокус | Стрічка | Довідка | Шрифти | Емодзі |
| vi | Chế độ ẩn | Đã thu hồi | Tải xuống | Tập trung | Bảng tin | Trợ giúp | Phông chữ | Biểu tượng cảm xúc |
| zh-CN | 幽灵 | 已撤回 | 下载 | 专注 | 动态流 | 帮助 | 字体 | 表情符号 |
| zh-HK | 幽靈 | 已撤回 | 下載 | 專注 | 動態流 | 幫助 | 字體 | 表情符號 |
| zh-TW | 幽靈 | 已收回 | 下載 | 專注 | 動態消息 | 幫助 | 字型 | 表情符號 |
