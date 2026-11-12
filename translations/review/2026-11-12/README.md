# 2026-11-12 — History, Analyzer, Foldable and the new updater

Scope: the delta between the app catalogue (`en.json` revision 10, 3,082 entries: 3,017 strings and 65 plurals) and `source/en.json` revision 8: 899 new keys, 18 entries whose English changed, 2 removed keys (`media.release.channel.rc`, `media.release.unlock_browser`). New areas: History, Analyzer and its settings, Foldable settings, follow/unfollow confirmation, iOS Story fonts, like animation import (Lottie and video), Instants gallery video and animation, and the updater (channels Dev, Alpha, Beta and Stable, the beta offer and password unlock, in-app download and install, the update-required screen for superseded builds, automatic updates). Every other entry was left as it was: 93,095 existing translations unchanged.

Process:
- Lead: delta and work packages (English, context note, placeholders, the locale's plural categories, the previous translation of revised entries, a width budget for short labels).
- Translation: the 917 entries for the 43 distinct locales in 15 parallel groups, reusing each catalogue's terms (Followers/Following as Instagram names them, Stories, Reels, Direct). Each text that names a setting quotes that setting's label in the same catalogue. Identity copies take their base locale's values.
- Lead review: width scan of every short label, abbreviations expanded where the surface wraps, Off/On aligned with each catalogue (see [LENGTH.md](LENGTH.md)).

Channel names: Dev stays “Dev” in every locale; Alpha, Beta and Stable use the local word where the catalogue or Instagram has one. The old “rc” (release candidate) channel string is gone with its key.

Checks: `tools/Translations.ps1 -Command validate` (and the same `TranslationCatalogTool validate` for every file) passed 50/50 at 3,082/3,082 entries. A separate script confirmed for all 50 files: valid JSON and header, key set and order equal to `en.json`, identical named placeholders per entry, `{count}` in every plural form, valid plural categories, line-break counts equal to English, no literal backslash-n, identity copies equal to their base, unchanged existing translations, `en`, `pt-PT` and `context.json` byte-equal to the app. Revisions: locales 7, en/pt-PT 10. Packs and `index.json` prepared with `prepare` (defaults unchanged); every index entry matches its file's size, SHA-256 and source.

Not checked: rendering on a phone in each language (widths are character estimates). Native-speaker review remains pending, as for earlier rounds. `context.json` was copied again from the app after the app removed 24 context entries for keys it no longer has; `source/` and `contribute/` stay byte-equal to the app (validate 50/50 rerun).

## Terms for the new features

| locale | History | Analyzer | Quick check | Full update | Keep list | Lost followers | Foldable | Stable | Remember your lists |
|---|---|---|---|---|---|---|---|---|---|
| en | History | Analyzer | Quick check | Full update | Keep list | Lost followers | Foldable | Stable | Remember your lists |
| af | Historie | Analyzer | Kitskontrole | Vol opdatering | Behoudlys | Verlore volgers | Opvoubaar | Stabiel | Onthou jou lyste |
| ar | السجل | المحلل | فحص سريع | تحديث كامل | قائمة الإبقاء | متابعون مفقودون | قابل للطي | مستقر | تذكّر قوائمك |
| bg | Хронология | Анализатор | Бърза проверка | Пълна проверка | Запазени | Загубени | Сгъваеми | Стабилна | Запомняне на списъците |
| bn | ইতিহাস | অ্যানালাইজার | দ্রুত যাচাই | পূর্ণ আপডেট | রাখার তালিকা | হারানো অনুসরণকারী | ফোল্ডেবল | স্থিতিশীল | আপনার তালিকা মনে রাখুন |
| cs | Historie | Analyzátor | Rychlý test | Úplný test | Ponechané | Ztracení | Skládací | Stabilní | Pamatovat si seznamy |
| da | Historik | Analyzer | Hurtigtjek | Fuldtjek | Behold-liste | Mistede følgere | Foldbar | Stabil | Husk dine lister |
| de | Verlauf | Analyzer | Schnellcheck | Vollupdate | Merkliste | Follower-Verluste | Faltbar | Stabil | Listen merken |
| el | Ιστορικό | Αναλυτής | Γρήγορη σάρωση | Πλήρης σάρωση | Κρατημένοι | Χαμένοι ακόλουθοι | Πτυσσόμενη | Σταθερή | Απομνημόνευση λιστών |
| es | Historial | Analizador | Revisión rápida | Actualización completa | Guardadas | Perdidos | Plegable | Estable | Recordar tus listas |
| fa | تاریخچه | تحلیلگر | بررسی سریع | به‌روزرسانی کامل | فهرست حفظ | ازدست‌رفته‌ها | تاشو | پایدار | به‌خاطر سپردن فهرست‌ها |
| fi | Historia | Analyysi | Pikatarkistus | Täyspäivitys | Pidetyt | Menetetyt | Taittuva | Vakaa | Muista luettelosi |
| fr | Historique | Analyseur | Vérification rapide | Mise à jour complète | Liste Garder | Abonnés perdus | Pliable | Stable | Mémoriser tes listes |
| gu | ઇતિહાસ | વિશ્લેષક | ઝડપી તપાસ | સંપૂર્ણ અપડેટ | રાખેલી યાદી | ગુમાવેલા અનુયાયીઓ | ફોલ્ડેબલ | સ્થિર | તમારી યાદીઓ યાદ રાખો |
| he | היסטוריה | מנתח | בדיקה מהירה | עדכון מלא | רשימת שמירה | עוקבים שאבדו | מתקפל | יציב | זכירת הרשימות |
| hi | इतिहास | एनालाइज़र | त्वरित जाँच | पूरा अपडेट | रखी गई सूची | खोए फ़ॉलोअर्स | फ़ोल्डेबल | स्थिर | आपकी सूचियाँ याद रखें |
| hr | Povijest | Analizator | Brza provjera | Puni prolaz | Zadržani | Izgubljeni | Sklopivi | Stabilno | Pamti vaše popise |
| hu | Előzmények | Elemző | Gyorskontroll | Teljes frissítés | Megtartottak | Elveszett követők | Hajtható | Stabil | Emlékezz a listáidra |
| id | Riwayat | Analisis | Cek cepat | Pembaruan penuh | Daftar simpan | Pengikut hilang | Layar lipat | Stabil | Ingat daftar Anda |
| it | Cronologia | Analyzer | Check rapido | Aggiornamento completo | Lista Tieni | Follower persi | Pieghevole | Stabile | Ricorda i tuoi elenchi |
| ja | 履歴 | 分析 | クイック確認 | 完全更新 | 保持リスト | 失ったフォロワー | 折りたたみ | 安定版 | リストを記憶 |
| kn | ಇತಿಹಾಸ | ವಿಶ್ಲೇಷಕ | ತ್ವರಿತ ಪರಿಶೀಲನೆ | ಪೂರ್ಣ ನವೀಕರಣ | ಇರಿಸಿದ ಪಟ್ಟಿ | ಕಳೆದುಕೊಂಡ ಅನುಯಾಯಿಗಳು | ಫೋಲ್ಡೆಬಲ್ | ಸ್ಥಿರ | ನಿಮ್ಮ ಪಟ್ಟಿಗಳನ್ನು ನೆನಪಿಡಿ |
| ko | 기록 | 분석기 | 빠른 확인 | 전체 업데이트 | 유지 목록 | 떠난 팔로워 | 폴더블 | 안정 버전 | 내 목록 기억 |
| mr | इतिहास | अॅनालायझर | जलद तपासणी | पूर्ण अद्यतन | ठेवलेली यादी | गमावलेले फॉलोअर्स | फोल्डेबल | स्थिर | तुमच्या याद्या लक्षात ठेवा |
| ms | Sejarah | Analisis | Semakan pantas | Imbasan penuh | Senarai jaga | Pengikut hilang | Boleh lipat | Stabil | Ingat senarai anda |
| nb | Historikk | Analyzer | Hurtigsjekk | Fullsjekk | Behold-liste | Tapte følgere | Foldbar | Stabil | Husk listene dine |
| nl | Historie | Analyzer | Snelle check | Volle update | Bewaarlijst | Verloren volgers | Opvouwbaar | Stabiel | Je lijsten onthouden |
| pl | Historia | Analizator | Szybki test | Pełny test | Zostawione | Utraceni | Składany | Stabilna | Zapamiętuj listy |
| pt-BR | Histórico | Analisador | Verificação rápida | Atualização completa | Mantidos | Perdidos | Dobrável | Estável | Lembrar suas listas |
| ro | Istoric | Analizor | Verificare rapidă | Actualizare completă | Păstrate | Pierduți | Pliabil | Stabilă | Reține listele tale |
| ru | Просмотры | Анализатор | Быстрая проверка | Полное обновление | Оставленные | Потерянные | Складной | Стабильная | Запоминать списки |
| sk | História | Analyzátor | Rýchly test | Úplný test | Ponechané | Stratení | Skladací | Stabilný | Pamätať si zoznamy |
| sr | Историја | Анализатор | Брза провера | Пуни пролаз | Задржани | Изгубљени | Савитљиви | Стабилно | Памти ваше спискове |
| sv | Historik | Analyzer | Snabbkontroll | Helkontroll | Behåll-lista | Förlorade följare | Vikbar | Stabil | Kom ihåg dina listor |
| ta | வரலாறு | பகுப்பாய்வி | விரைவுச் சோதனை | முழு அப்டேட் | தக்கவைத்தவை | இழந்த பின்தொடர்பவர்கள் | மடிப்புப் போன் | நிலையானது | பட்டியல்களை நினைவில் வை |
| te | చరిత్ర | విశ్లేషకం | త్వరిత తనిఖీ | పూర్తి నవీకరణ | ఉంచే జాబితా | కోల్పోయిన అనుచరులు | ఫోల్డబుల్ | స్థిరమైనది | మీ జాబితాలను గుర్తుంచుకో |
| th | ประวัติ | ตัววิเคราะห์ | ตรวจแบบเร็ว | อัปเดตทั้งหมด | รายการที่เก็บไว้ | ผู้ติดตามที่หายไป | จอพับ | เสถียร | จำรายชื่อของคุณ |
| tl | Kasaysayan | Analyzer | Quick check | Full update | Mga tinabi | Nawalang follower | Foldable | Matatag | Tandaan ang listahan mo |
| tr | Geçmiş | Analizör | Hızlı kontrol | Tam güncelleme | Saklananlar | Kaybedilenler | Katlanır | Kararlı | Listelerimi hatırla |
| uk | Перегляди | Аналізатор | Швидка перевірка | Повне оновлення | Залишені | Втрачені | Складаний | Стабільна | Запам’ятовувати списки |
| vi | Lịch sử | Phân tích | Kiểm tra nhanh | Cập nhật đầy đủ | Danh sách giữ | Lượt theo dõi mất | Màn gập | Ổn định | Ghi nhớ danh sách bạn |
| zh-CN | 历史记录 | 分析器 | 快速检查 | 完整更新 | 保留名单 | 流失的粉丝 | 折叠屏 | 稳定版 | 记住你的列表 |
| zh-HK | 歷史記錄 | 分析器 | 快速檢查 | 完整更新 | 保留列表 | 流失的粉絲 | 摺疊裝置 | 穩定版 | 記住你的列表 |
| zh-TW | 歷史紀錄 | 分析器 | 快速檢查 | 完整更新 | 保留清單 | 流失的粉絲 | 摺疊裝置 | 穩定版 | 記住你的清單 |
