package app.myinsta.runtime.i18n;

import java.nio.ByteBuffer;
import java.nio.charset.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.regex.*;

/** Immutable validated catalogue. Unknown keys in newer packs are ignored by older clients. */
public final class TranslationPack {
    public static final String CATALOG = "myinsta-ui-v1";
    public static final int MAX_BYTES = 1024 * 1024;
    private static final Pattern ARG = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_]*)\\}");
    private static final Set<String> CATEGORIES = new HashSet<>(Arrays.asList("zero", "one", "two", "few", "many", "other"));
    public final String locale;
    public final long revision;
    public final Map<String, String> strings;
    public final Map<String, Map<String, String>> plurals;
    private TranslationPack(String locale, long revision, Map<String, String> strings, Map<String, Map<String, String>> plurals) {
        this.locale = locale; this.revision = revision;
        this.strings = Collections.unmodifiableMap(strings); this.plurals = Collections.unmodifiableMap(plurals);
    }
    public static String decode(byte[] bytes, int max) {
        if (bytes.length > max) throw new IllegalArgumentException("Catalogue too large");
        try { return StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bytes)).toString(); }
        catch (CharacterCodingException ex) { throw new IllegalArgumentException("Invalid UTF-8", ex); }
    }
    public static TranslationPack parse(byte[] bytes, TranslationPack english) {
        Map<String, Object> root = StrictJson.object(decode(bytes, MAX_BYTES));
        if (StrictJson.integer(root.get("schemaVersion")) != 1 || !CATALOG.equals(root.get("catalogId"))) throw new IllegalArgumentException("Unsupported catalogue");
        String locale = canonical(StrictJson.string(root.get("locale")));
        long revision = StrictJson.integer(root.get("revision")); if (revision < 1) throw new IllegalArgumentException("Invalid revision");
        Map<String, String> strings = new LinkedHashMap<>();
        Map<String, Map<String, String>> plurals = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entry : StrictJson.map(root.get("strings")).entrySet()) {
            key(entry.getKey()); String value = StrictJson.string(entry.getValue()); Set<String> args = arguments(value);
            if (english != null && !english.strings.containsKey(entry.getKey())) continue;
            if (english != null && !args.equals(arguments(english.strings.get(entry.getKey())))) throw new IllegalArgumentException("Changed placeholders: " + entry.getKey());
            strings.put(entry.getKey(), value);
        }
        for (Map.Entry<String, Object> entry : StrictJson.map(root.get("plurals")).entrySet()) {
            key(entry.getKey()); if (strings.containsKey(entry.getKey())) throw new IllegalArgumentException("Conflicting key: " + entry.getKey());
            Map<String, Object> forms = StrictJson.map(entry.getValue());
            if (!forms.containsKey("other")) throw new IllegalArgumentException("Missing other: " + entry.getKey());
            Map<String, String> validated = new LinkedHashMap<>(); Set<String> args = null;
            for (Map.Entry<String, Object> form : forms.entrySet()) {
                if (!CATEGORIES.contains(form.getKey())) throw new IllegalArgumentException("Invalid plural category");
                String value = StrictJson.string(form.getValue()); Set<String> current = arguments(value);
                if (!current.contains("count") || args != null && !args.equals(current)) throw new IllegalArgumentException("Invalid plural placeholders: " + entry.getKey());
                args = current; validated.put(form.getKey(), value);
            }
            if (english != null && !english.plurals.containsKey(entry.getKey())) continue;
            if (english != null && !args.equals(arguments(english.plurals.get(entry.getKey()).get("other")))) throw new IllegalArgumentException("Changed plural placeholders: " + entry.getKey());
            plurals.put(entry.getKey(), Collections.unmodifiableMap(validated));
        }
        return new TranslationPack(locale, revision, strings, plurals);
    }
    public static void requireComplete(TranslationPack translated, TranslationPack english) {
        if (!translated.strings.keySet().equals(english.strings.keySet()) || !translated.plurals.keySet().equals(english.plurals.keySet())) throw new IllegalArgumentException("Incomplete bundled catalogue: " + translated.locale);
    }
    private static void key(String key) { if (!key.matches("[a-z][a-z0-9_]*(\\.[a-z0-9_]+)+")) throw new IllegalArgumentException("Invalid key: " + key); }
    public static Set<String> arguments(String text) {
        Set<String> result = new TreeSet<>(); Matcher matcher = ARG.matcher(text); StringBuffer rest = new StringBuffer();
        while (matcher.find()) { result.add(matcher.group(1)); matcher.appendReplacement(rest, ""); }
        matcher.appendTail(rest);
        if (rest.indexOf("{") >= 0 || rest.indexOf("}") >= 0) throw new IllegalArgumentException("Invalid placeholder");
        return result;
    }
    public static String format(String text, Map<String, String> values) {
        Matcher matcher = ARG.matcher(text); StringBuffer out = new StringBuffer();
        while (matcher.find()) {
            String value = values.get(matcher.group(1)); if (value == null) throw new IllegalArgumentException("Missing argument: " + matcher.group(1));
            matcher.appendReplacement(out, Matcher.quoteReplacement(value));
        }
        matcher.appendTail(out); return out.toString();
    }
    public static String canonical(String tag) {
        if (tag == null || !tag.matches("[A-Za-z]{2,3}(-[A-Za-z0-9]{2,8})*")) throw new IllegalArgumentException("Invalid locale");
        Locale locale = Locale.forLanguageTag(tag); String normalized = locale.toLanguageTag();
        if (locale.getLanguage().isEmpty() || !normalized.equalsIgnoreCase(tag)) throw new IllegalArgumentException("Invalid locale");
        return normalized;
    }
    public static String sha256(byte[] bytes) {
        try { StringBuilder out = new StringBuilder(); for (byte b : MessageDigest.getInstance("SHA-256").digest(bytes)) out.append(String.format(Locale.ROOT, "%02x", b & 255)); return out.toString(); }
        catch (Exception ex) { throw new IllegalStateException(ex); }
    }
}
