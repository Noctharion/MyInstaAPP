package app.myinsta.runtime.i18n;

import java.util.*;

/** Only paths beneath the fixed MyInstaAPP translations directory are accepted. */
public final class TranslationIndex {
    public static final int MAX_BYTES = 256 * 1024;
    public final Map<String, String> defaults;
    public final Map<String, Entry> entries;
    public static final class Entry {
        public final String locale, path, sha256;
        public final long revision, size;
        Entry(String locale, long revision, String path, long size, String sha256) { this.locale = locale; this.revision = revision; this.path = path; this.size = size; this.sha256 = sha256; }
        public TranslationPack validate(byte[] bytes, TranslationPack english) {
            if (bytes.length != size || !TranslationPack.sha256(bytes).equals(sha256)) throw new IllegalArgumentException("Pack integrity mismatch");
            TranslationPack pack = TranslationPack.parse(bytes, english);
            if (!pack.locale.equals(locale) || pack.revision != revision) throw new IllegalArgumentException("Pack identity mismatch");
            return pack;
        }
    }
    private TranslationIndex(Map<String, String> defaults, Map<String, Entry> entries) { this.defaults = Collections.unmodifiableMap(defaults); this.entries = Collections.unmodifiableMap(entries); }
    public static TranslationIndex parse(byte[] bytes) {
        Map<String, Object> root = StrictJson.object(TranslationPack.decode(bytes, MAX_BYTES));
        if (StrictJson.integer(root.get("schemaVersion")) != 1 || !TranslationPack.CATALOG.equals(root.get("catalogId"))) throw new IllegalArgumentException("Unsupported index");
        Map<String, String> defaults = new LinkedHashMap<>(); Map<String, Entry> entries = new LinkedHashMap<>();
        Object packs = root.get("packs"); if (!(packs instanceof List)) throw new IllegalArgumentException("Expected packs");
        for (Object object : (List<?>) packs) {
            Map<String, Object> item = StrictJson.map(object); String locale = TranslationPack.canonical(StrictJson.string(item.get("locale")));
            String path = StrictJson.string(item.get("path")), hash = StrictJson.string(item.get("sha256"));
            long revision = StrictJson.integer(item.get("revision")), size = StrictJson.integer(item.get("size"));
            if (revision < 1 || size < 1 || size > TranslationPack.MAX_BYTES || !hash.matches("[a-f0-9]{64}") ||
                    !path.equals("packs/" + locale + "/" + revision + "-" + hash + ".json")) throw new IllegalArgumentException("Invalid immutable pack path or metadata");
            if (entries.put(locale, new Entry(locale, revision, path, size, hash)) != null) throw new IllegalArgumentException("Duplicate pack locale");
        }
        for (Map.Entry<String, Object> item : StrictJson.map(root.get("defaults")).entrySet()) {
            String family = TranslationPack.canonical(item.getKey()), target = TranslationPack.canonical(StrictJson.string(item.getValue()));
            Locale requested = Locale.forLanguageTag(family), resolved = Locale.forLanguageTag(target);
            String expectedFamily = requested.getLanguage() + (requested.getScript().isEmpty() ? "" : "-" + requested.getScript());
            if (!family.equals(expectedFamily) || !requested.getLanguage().equals(resolved.getLanguage()) ||
                    !requested.getScript().equals(resolved.getScript()) || !entries.containsKey(target)) throw new IllegalArgumentException("Invalid language default");
            defaults.put(family, target);
        }
        return new TranslationIndex(defaults, entries);
    }
    public String resolve(Locale locale) {
        return resolve(locale, "");
    }
    /** The runtime may supply ICU's likely script for native language/region locales. */
    public String resolve(Locale locale, String likelyScript) {
        String exact = locale.toLanguageTag(); if (entries.containsKey(exact)) return exact;
        String family = locale.getLanguage() + (locale.getScript().isEmpty() ? "" : "-" + locale.getScript());
        if (defaults.containsKey(family)) return defaults.get(family);
        // An explicit script is authoritative; inference only fills an absent script.
        if (locale.getScript().isEmpty() && likelyScript != null && likelyScript.matches("[A-Z][a-z]{3}"))
            return defaults.getOrDefault(locale.getLanguage() + "-" + likelyScript, "en");
        return "en";
    }
}
