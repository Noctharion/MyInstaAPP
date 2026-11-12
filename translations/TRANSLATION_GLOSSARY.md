# MyInsta translation glossary

Entry point for terminology decisions. It does not replace the existing records: [functional glossary](review/2026-10-17/FUNCTIONAL-GLOSSARY.md) (meaning and distinctions per feature) and [locale conventions](review/2026-10-17/LOCALE-CONVENTIONS.md) (Stories, Ghost Mode, Keep View-Once Media, Unsent archive, Download per locale). This page adds the terms introduced or changed in the 2026-10-30 synchronization. Recorded conventions are not claims of official Instagram wording or native-speaker approval.

## Source of truth

- English in the application bundle (`patches/src/main/resources/myinsta/i18n/en.json` in the private source) is canonical; `source/en.json` here is a byte copy. European Portuguese is the second bundled catalogue and is maintained by the owner.
- 43 distinct translations. Five files are system identities that carry identical text: zh-Hans-CN = zh-CN, zh-Hant-HK = zh-HK, zh-Hant-TW = zh-TW, sr-Cyrl-RS = sr, fil-PH = tl ([sharing decisions](review/2026-10-17/variant-sharing.json)). Edit the base locale and copy it to its identity file; change only `locale`.
- pt-PT and pt-BR, and zh-CN/zh-HK/zh-TW, are separate regional translations. Never convert one into another.

## Names that stay unchanged

Instagram, MyInsta, Meta AI, Threads, Ko-fi, Spartan, Bluepapilte, font names, people's names used as app icon names (Haruko, Felipe, Humberto, Zipeng, Ricky, Uzo), K-pop, Polaroid, Homecoming, devflag/DevFlags, folder paths (Pictures/MyInsta, Music/MyInsta, Movies/MyInsta, Download/MyInsta), units and format codes (dp, MB, Mbps, HDR). Glass is the feature name of MyInsta's material and stays in Latin script; the descriptive part of “Glass & Blur” is translated. Reels, Instants and Direct follow each catalogue's existing convention: some locales use Instagram's local name (pl Rolki, hi DM, gu/hi/bn/mr local script); keep whatever the catalogue already uses.

## Decisions recorded on 2026-10-30

| Concept | Decision |
|---|---|
| Lock Chat (`hidden.hide`) | Means locking a conversation into Hidden Chats, not hiding it and not blocking a person. The owner chose pt-PT “Bloquear conversa”, consistent with the existing “conversas bloqueadas”. Every locale now uses a lock action, and `hidden.empty_help` and `settings.hidden_chats_enabled.summary` must quote exactly the `hidden.hide` label. Where the lock verb also means blocking a user (es, pt-PT, ro, pl, ru, uk), the existing “locked chats” wording of that catalogue decided the choice. |
| Mark as read (`media.direct.mark_*`) | English changed from “seen” to “read”. Use the catalogue's word for read. The separate Seen receipt feature (Remove Seen Status, Sends Seen) keeps its existing words. |
| Help texts that name a control | Quote the exact label of that control in the same catalogue (setting titles, menu actions, the Help & support page). |
| App icon names | Translate ordinary descriptive words (Dark, Purple, Sunset, Flame, Bubble meaning a chat bubble). Keep personal and brand-like names. `app_icon.option.glow` is “Neon” in English and must equal the locale's `app_icon.option.neon`. Group headers (INSTAGRAM, MYINSTA, SOCIAL, MYINSTA LEGACY) follow the catalogue's section header case. |
| Short labels | `follow_back.not_following_back` and similar list badges have a ~14 character budget (see context). Prefer a short natural phrase. |
| Line breaks | Values use real line breaks exactly where English has them. A literal backslash followed by n is shown as text. |
| Search aliases (`*.aliases`) | Comma-separated search words, translated; keeping the English words as extra aliases is allowed. |

## Terms introduced or changed in this pass

| locale | Lock Chat | Hidden Chats | Mark as read | Glass & Blur | Font and Emoji | App icon | Remember who follows you | Scroll break |
|---|---|---|---|---|---|---|---|---|
| af | Sluit klets toe | Versteekte kletse | Merk as gelees | Glass & Blur | Lettertipe en emoji | Toepassingikoon | Onthou wie jou volg | Blaaipouse |
| ar | قفل المحادثة | المحادثات المخفية | وضع علامة مقروءة | Glass والتمويه | الخطوط والرموز التعبيرية | أيقونة التطبيق | تذكّر من يتابعك | استراحة من التمرير |
| bg | Заключване на разговора | Скрити чатове | Маркиране като прочетено | Glass и замъгляване | Шрифт и емоджи | Икона на приложението | Запомняне кой ви следва | Почивка от превъртането |
| bn | চ্যাট লক করুন | লুকানো কথোপকথন | পড়া হয়েছে চিহ্নিত করুন | Glass ও ব্লার | ফন্ট ও ইমোজি | অ্যাপ আইকন | কে আপনাকে অনুসরণ করে মনে রাখুন | স্ক্রল বিরতি |
| cs | Uzamknout chat | Skryté chaty | Označit jako přečtené | Glass a rozostření | Písmo a emoji | Ikona aplikace | Pamatovat si, kdo vás sleduje | Přestávka od posouvání |
| da | Lås chat | Skjulte chats | Markér som læst | Glass & Blur | Skrifttype og emoji | Appikon | Husk, hvem der følger dig | Scrollpause |
| de | Chat sperren | Verborgene Chats | Als gelesen markieren | Glass & Blur | Schrift und Emoji | App-Symbol | Merken, wer dir folgt | Scroll-Pause |
| el | Κλείδωμα συνομιλίας | Κρυφές συνομιλίες | Σήμανση ως αναγνωσμένης | Glass και θόλωση | Γραμματοσειρές και emoji | Εικονίδιο εφαρμογής | Να θυμάσαι ποιος σας ακολουθεί | Διάλειμμα κύλισης |
| en | Lock Chat | Hidden Chats | Mark as read | Glass & Blur | Font and Emoji | App icon | Remember who follows you | Scroll break |
| es | Bloquear chat | Conversaciones ocultas | Marcar como leída | Glass y desenfoque | Fuentes y emojis | Icono de la app | Recordar quién te sigue | Descanso de desplazamiento |
| fa | قفل گفتگو | گفتگوهای پنهان | علامت‌گذاری به‌عنوان خوانده‌شده | Glass و تاری | قلم‌ها و شکلک‌ها | نماد برنامه | به‌خاطر سپردن دنبال‌کنندگان شما | استراحت از پیمایش |
| fi | Lukitse keskustelu | Piilotetut keskustelut | Merkitse luetuksi | Glass ja sumennus | Fontit ja emojit | Sovelluskuvake | Muista, kuka seuraa sinua | Vieritystauko |
| fr | Verrouiller la discussion | Conversations masquées | Marquer comme lu | Glass et flou | Polices et emojis | Icône de l’application | Se souvenir de qui te suit | Pause de défilement |
| gu | ચૅટ લૉક કરો | છુપાવેલી વાતચીત | વાંચેલું ચિહ્નિત કરો | Glass અને બ્લર | ફૉન્ટ અને ઇમોજી | ઍપ આઇકન | કોણ તમને અનુસરે છે તે યાદ રાખો | સ્ક્રોલ બ્રેક |
| he | נעילת שיחה | שיחות מוסתרות | סימון כנקרא | Glass וטשטוש | גופנים ואימוג'י | סמל האפליקציה | זכירת מי עוקב אחריכם | הפסקת גלילה |
| hi | चैट लॉक करें | छिपी बातचीत | पढ़ा हुआ चिह्नित करें | Glass और ब्लर | फ़ॉन्ट और इमोजी | ऐप आइकन | आपको कौन फ़ॉलो करता है, याद रखें | स्क्रॉल ब्रेक |
| hr | Zaključaj razgovor | Skriveni razgovori | Označi kao pročitano | Glass i zamućenje | Font i emoji | Ikona aplikacije | Pamti tko vas prati | Stanka od pomicanja |
| hu | Beszélgetés zárolása | Rejtett csevegések | Megjelölés olvasottként | Glass és elmosás | Betűtípusok és emojik | Alkalmazásikon | Emlékezz, ki követ | Görgetési szünet |
| id | Kunci obrolan | Obrolan Tersembunyi | Tandai sudah dibaca | Glass & Blur | Font dan emoji | Ikon aplikasi | Ingat siapa yang mengikuti Anda | Jeda menggulir |
| it | Proteggi chat | Chat nascoste | Segna come letto | Glass e sfocatura | Caratteri ed emoji | Icona dell'app | Ricorda chi ti segue | Pausa dallo scorrimento |
| ja | チャットをロック | 非表示チャット | 既読にする | Glassとぼかし | フォントと絵文字 | アプリアイコン | フォロワーを記憶 | スクロール休憩 |
| kn | ಚಾಟ್ ಲಾಕ್ ಮಾಡಿ | ಮರೆಮಾಡಿದ ಸಂಭಾಷಣೆಗಳು | ಓದಿದೆ ಎಂದು ಗುರುತಿಸಿ | Glass ಮತ್ತು ಬ್ಲರ್ | ಫಾಂಟ್ ಮತ್ತು ಇಮೋಜಿ | ಆ್ಯಪ್ ಐಕಾನ್ | ನಿಮ್ಮನ್ನು ಯಾರು ಅನುಸರಿಸುತ್ತಾರೆ ಎಂಬುದನ್ನು ನೆನಪಿಡಿ | ಸ್ಕ್ರಾಲ್ ವಿರಾಮ |
| ko | 채팅 잠금 | 숨긴 채팅 | 읽음으로 표시 | Glass 및 흐림 | 글꼴과 이모지 | 앱 아이콘 | 나를 팔로우하는 계정 기억 | 스크롤 휴식 |
| mr | चॅट लॉक करा | लपवलेली संभाषणे | वाचलेले चिन्हांकित करा | Glass आणि ब्लर | फॉन्ट आणि इमोजी | अॅप आयकन | तुम्हाला कोण फॉलो करते ते लक्षात ठेवा | स्क्रोल ब्रेक |
| ms | Kunci sembang | Sembang Tersembunyi | Tandakan sebagai dibaca | Glass & Blur | Fon dan emoji | Ikon apl | Ingat siapa yang mengikuti anda | Rehat menatal |
| nb | Lås samtale | Skjulte samtaler | Merk som lest | Glass & Blur | Skrifttype og emoji | Appikon | Husk hvem som følger deg | Rullepause |
| nl | Chat vergrendelen | Verborgen chats | Markeren als gelezen | Glass & Blur | Lettertype en emoji | App-pictogram | Onthouden wie jou volgt | Scrollpauze |
| pl | Zablokuj czat | Ukryte czaty | Oznacz jako przeczytane | Glass i rozmycie | Czcionki i emoji | Ikona aplikacji | Zapamiętuj, kto cię obserwuje | Przerwa w przewijaniu |
| pt-BR | Trancar conversa | Conversas ocultas | Marcar como lida | Glass e desfoque | Fontes e emojis | Ícone do app | Lembrar quem segue você | Pausa na rolagem |
| pt-PT | Bloquear conversa | Conversas ocultas | Marcar como lida | Glass & Blur | Tipos de letra e emojis | Ícone da app | Lembrar quem te segue | Pausa de scroll |
| ro | Blochează conversația | Conversații ascunse | Marchează ca citit | Glass și estompare | Fonturi și emojiuri | Pictograma aplicației | Reține cine te urmărește | Pauză de derulare |
| ru | Заблокировать чат | Скрытые чаты | Отметить прочитанным | Glass и размытие | Шрифты и эмодзи | Значок приложения | Запоминать подписчиков | Перерыв в прокрутке |
| sk | Uzamknúť čet | Skryté čety | Označiť ako prečítané | Glass a rozostrenie | Písmo a emoji | Ikona aplikácie | Pamätať si, kto vás sleduje | Prestávka od posúvania |
| sr | Закључај разговор | Скривени разговори | Означи као прочитано | Glass и замућење | Фонт и емоџији | Икона апликације | Памти ко вас прати | Пауза од померања |
| sv | Lås chatt | Dolda chattar | Markera som läst | Glass & Blur | Teckensnitt och emoji | Appikon | Kom ihåg vem som följer dig | Scrollpaus |
| ta | அரட்டையைப் பூட்டு | மறைக்கப்பட்ட உரையாடல்கள் | படித்ததாகக் குறி | Glass & மங்கலாக்கம் | எழுத்துருக்கள் மற்றும் எமோஜிகள் | செயலி ஐகான் | உங்களைப் பின்தொடர்பவர்களை நினைவில் வை | ஸ்க்ரோல் இடைவேளை |
| te | చాట్‌ను లాక్ చేయండి | దాచిన సంభాషణలు | చదివినట్లు గుర్తించండి | Glass & బ్లర్ | ఫాంట్‌లు మరియు ఎమోజీలు | యాప్ ఐకాన్ | మిమ్మల్ని ఎవరు అనుసరిస్తున్నారో గుర్తుంచుకో | స్క్రోల్ బ్రేక్ |
| th | ล็อกแชท | แชทที่ซ่อน | ทำเครื่องหมายว่าอ่านแล้ว | Glass และเบลอ | แบบอักษรและอีโมจิ | ไอคอนแอป | จำว่าใครติดตามคุณ | พักการเลื่อน |
| tl | I-lock ang chat | Mga Nakatagong Chat | Markahang nabasa | Glass & Blur | Mga font at emoji | Icon ng app | Tandaan kung sino ang sumusunod sa iyo | Pahinga sa pag-scroll |
| tr | Sohbeti kilitle | Gizli Sohbetler | Okundu olarak işaretle | Glass ve bulanıklık | Yazı tipleri ve emojiler | Uygulama simgesi | Kimin takip ettiğini hatırla | Kaydırma molası |
| uk | Заблокувати розмову | Приховані розмови | Позначити прочитаним | Glass і розмиття | Шрифти й емодзі | Значок застосунку | Запам’ятовувати підписників | Перерва в прокручуванні |
| vi | Khóa cuộc trò chuyện | Trò chuyện ẩn | Đánh dấu đã đọc | Glass & Blur | Phông chữ và biểu tượng cảm xúc | Biểu tượng ứng dụng | Ghi nhớ ai đang theo dõi bạn | Nghỉ cuộn |
| zh-CN | 锁定聊天 | 隐藏聊天 | 标为已读 | Glass 和模糊 | 字体和表情符号 | 应用图标 | 记住谁关注了你 | 滑动休息 |
| zh-HK | 鎖定聊天 | 隱藏聊天室 | 標示為已讀 | Glass 和模糊 | 字體和表情符號 | 應用程式圖示 | 記住誰追蹤了你 | 滑動休息 |
| zh-TW | 鎖定聊天 | 隱藏聊天室 | 標示為已讀 | Glass 和模糊 | 字型和表情符號 | 應用程式圖示 | 記住誰追蹤了你 | 滑動休息 |

Identity files repeat their base locale's values.

## Open terminology questions

- ko uses 탐색 for both Explore and Navigation; separating them would rename every Navigation string.
- nl Home tab is “Startpagina” while many strings say “Start”; pt-BR mixes “Página inicial” and “Início”.
- sv convention table says “Hämta” for Download, while “Ladda ned” is widespread in the catalogue.
- zh-CN uses 主页 for both Home and Profile.
- tl keeps many English UI words (Taglish); a consistency pass would be a catalogue-wide choice.
- kn/ta `home_toolbar.actions.reels_second_opt_in` and te `settings.like_protection_comments.*` predate this pass and use a different Reels/comment form than the rest of their catalogue.

## Decisions recorded on 2026-11-01 (settings reorganization)

Page names became short, single words where the language allows: Ghost (was Ghost Mode), Unsent (was Unsent Messages), Downloads (was Download Center), Focus (was Distraction Free), Feed (was Feed and profiles), Help (was Help & support), Glass (was Glass & Blur), Fonts and Emoji (were one Font and Emoji row), Account suggestions and Suggested content (were Hide Discover people / Hide suggested content). Messages, Reels and Profiles are pages again. Former names live on in each page's `*.aliases`, so search still finds them. Texts that quote a page name (for example `settings.messages_settings.summary` quoting Ghost and Unsent) must use the exact title of that catalogue. Where a short form would be ambiguous or clash with another label, the catalogue keeps its longer existing term (vi Ghost, several Unsent titles).

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

## Fixed-width labels (v27.0.2)

Some labels are drawn in controls that cannot grow: the Navbar / Toolbar / Off and Left / Centre / Right segments of the Navigation editor, the file name format chips (three per row), the In use / Use emoji chips, the Fonts tabs and the three labels of the settings dock. Segments and chips stay on one line and shrink from 14 to 9 sp, so a label more than about 1.6 times the English length (CJK counted double) can still clip.

- Use the shortest natural term native apps use for these labels (e.g. fr "Navigation" for the Navbar segment, es "Navegación" / "Herramientas", pt-BR "Navegação" / "Ferramentas"). Descriptions and help texts keep the full term ("barre de navigation"); the segment is only its short form.
- Do not shorten a label that a help text names as a choice (e.g. the "Instagram default" screen type in `navigation.screen.help`); change both together or neither.
- File name format chips: a short noun or participle is fine where "date of …" does not fit ("Téléchargé le", "Publicado em", "Descargado").
- The 2026-11-02 review lists every shortened label per locale.

## Decisions recorded on 2026-11-12 (History, Analyzer, Foldable, updater)

- Update channels: Dev stays “Dev” everywhere; Alpha, Beta and Stable use the catalogue's or Instagram's local word, kept short. Legacy is the label of the server's legacy release channel and is kept short too. Release candidates (“rc”) are no longer a channel.
- History must not collide with Story: where the local word for History is the word Instagram uses for a Story, another word is used (ru “Просмотры”, uk “Перегляди”, bg “Хронология”).
- Quick check and Full update are two kinds of Analyzer update. Where “full update” does not fit a 14-character card, the locale names it a full check or pass (da “Fuldtjek”, pl “Pełny test”, hr “Puni prolaz”, el “Πλήρης σάρωση”). Abbreviations (es “Act. completa”, it “Agg. completo”) are used only on tiles, card labels and chips; settings rows, sheet buttons, menus, headings and screen-reader labels use the full wording.
- Off/On values of settings rows use the catalogue's existing word (fr “Désactivé” / “Activé”), never an English or abbreviated form; only the tiny “Off” under a History tab may be abbreviated.
- The [2026-11-12 record](review/2026-11-12/README.md) has the per-locale term table; [LENGTH.md](review/2026-11-12/LENGTH.md) lists every abbreviated label and every label kept over its width budget.
