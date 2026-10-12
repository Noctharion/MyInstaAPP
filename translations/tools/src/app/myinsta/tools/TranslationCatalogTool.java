package app.myinsta.tools;

import app.myinsta.runtime.i18n.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

/** Portable authoring tool; uses the exact strict validation code shipped in the APK. */
public final class TranslationCatalogTool {
    public static void main(String[] args) throws Exception {
        if (args.length < 3) throw new IllegalArgumentException("validate|generate|export|prepare <English.json> <file-or-directory> [output] [default]");
        Path sourcePath = Paths.get(args[1]); TranslationPack english = TranslationPack.parse(Files.readAllBytes(sourcePath), null);
        if (!english.locale.equals("en")) throw new IllegalArgumentException("The source catalogue must be English");
        switch (args[0]) {
            case "generate": {
                Path directory = Paths.get(args[2]);
                TranslationPack pt = TranslationPack.parse(Files.readAllBytes(sourcePath.resolveSibling("pt-PT.json")), english);
                TranslationPack.requireComplete(pt, english);
                StringBuilder code = new StringBuilder("package app.myinsta.runtime.i18n;\n\n/** Generated from the English source catalogue. */\npublic final class TranslationKeys {\n    private TranslationKeys() {}\n");
                Set<String> names = new HashSet<>(); Set<String> keys = new TreeSet<>(english.strings.keySet()); keys.addAll(english.plurals.keySet());
                if (args.length > 3) {
                    Pattern reference = Pattern.compile("\\.(?:text|plural|english)\\(\\s*\"([a-z][a-z0-9_]*(?:\\.[a-z0-9_]+)+)\"");
                    Pattern convenience = Pattern.compile("\\bI18n\\.(?:text|plural)\\([^;\\n]*?,\\s*\"([a-z][a-z0-9_]*(?:\\.[a-z0-9_]+)+)\"");
                    try (java.util.stream.Stream<Path> sources = Files.walk(Paths.get(args[3]))) {
                        for (Path path : (Iterable<Path>) sources.filter(p -> p.toString().endsWith(".java"))::iterator) {
                            String source = Files.readString(path);
                            Matcher matcher = reference.matcher(source);
                            while (matcher.find()) if (!keys.contains(matcher.group(1))) throw new IllegalArgumentException("Unknown UI key " + matcher.group(1) + " in " + path);
                            matcher = convenience.matcher(source);
                            while (matcher.find()) if (!keys.contains(matcher.group(1))) throw new IllegalArgumentException("Unknown context UI key " + matcher.group(1) + " in " + path);
                            if (path.getFileName().toString().equals("SettingsCatalog.java") || path.getFileName().toString().equals("AboutCatalog.java")) {
                                String quoted = "\"(?:\\\\.|[^\"\\\\])*\"";
                                Matcher nodes = Pattern.compile("new\\s+Node\\(\\s*\"([a-z0-9_]+)\"\\s*,\\s*" + quoted + "\\s*,\\s*(" + quoted + ")\\s*,\\s*(" + quoted + ")").matcher(source);
                                while (nodes.find()) {
                                    for (int part = 2; part <= 3; part++) {
                                        String original = StrictJson.string(StrictJson.object("{\"value\":" + nodes.group(part) + "}").get("value"));
                                        if (part == 3 && original.isEmpty()) continue;
                                        String key = "settings." + nodes.group(1) + (part == 2 ? ".title" : ".summary");
                                        if (!original.equals(english.strings.get(key))) throw new IllegalArgumentException("Missing/drifting settings source key: " + key);
                                    }
                                }
                            }
                        }
                    }
                }
                for (String key : keys) {
                    // Encode separators independently; a node ID may itself contain underscores.
                    String constant = key.toUpperCase(Locale.ROOT).replace("_", "_U").replace(".", "_D");
                    if (!names.add(constant)) throw new IllegalArgumentException("Constant collision: " + key);
                    code.append("    public static final String ").append(constant).append(" = ").append(quote(key)).append(";\n");
                }
                code.append("}\n");
                Path target = directory.resolve("app/myinsta/runtime/i18n/TranslationKeys.java"); Files.createDirectories(target.getParent());
                Files.write(target, code.toString().getBytes(StandardCharsets.UTF_8));
                System.out.println("Validated complete en/pt-PT catalogues; generated " + keys.size() + " stable key constants."); break;
            }
            case "validate": report(TranslationPack.parse(Files.readAllBytes(Paths.get(args[2])), english), english); break;
            case "export": {
                Map<String, Object> root = StrictJson.object(TranslationPack.decode(Files.readAllBytes(sourcePath), TranslationPack.MAX_BYTES));
                root.put("locale", TranslationPack.canonical(args.length > 4 ? args[4] : "pt-PT")); root.put("revision", 1L);
                Path out = Paths.get(args[2]); Files.createDirectories(out);
                write(out.resolve("template.json"), root);
                Path context = sourcePath.resolveSibling("context.json"); if (Files.exists(context)) Files.copy(context, out.resolve("context.json"), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Translator template exported to " + out); break;
            }
            case "prepare": {
                if (args.length < 4) throw new IllegalArgumentException("prepare requires a MyInstaAPP directory");
                byte[] bytes = publicationBytes(Files.readAllBytes(Paths.get(args[2]))); TranslationPack pack = TranslationPack.parse(bytes, english);
                if (pack.locale.equals("en") || pack.locale.equals("pt-PT")) TranslationPack.requireComplete(pack, english);
                Path repo = Paths.get(args[3]).toAbsolutePath().normalize();
                if (!Files.isDirectory(repo.resolve(".git"))) throw new IllegalArgumentException("Expected MyInstaAPP Git checkout");
                Path indexFile = repo.resolve("translations/index.json"); Map<String, Object> root;
                if (Files.exists(indexFile)) {
                    TranslationIndex.parse(Files.readAllBytes(indexFile)); root = StrictJson.object(new String(Files.readAllBytes(indexFile), StandardCharsets.UTF_8));
                } else {
                    root = new LinkedHashMap<>(); root.put("schemaVersion", 1L); root.put("catalogId", TranslationPack.CATALOG);
                    root.put("defaults", new TreeMap<String, Object>()); root.put("packs", new ArrayList<>());
                }
                @SuppressWarnings("unchecked") List<Object> packs = (List<Object>) root.get("packs");
                String hash = TranslationPack.sha256(bytes), relative = "packs/" + pack.locale + "/" + pack.revision + "-" + hash + ".json";
                for (Object entry : packs) {
                    Map<String, Object> old = StrictJson.map(entry);
                    if (pack.locale.equals(old.get("locale")) && (pack.revision < StrictJson.integer(old.get("revision")) || pack.revision == StrictJson.integer(old.get("revision")) && !hash.equals(old.get("sha256")))) throw new IllegalArgumentException("Increase the locale revision before publishing changes");
                }
                packs.removeIf(value -> pack.locale.equals(StrictJson.map(value).get("locale")));
                Map<String, Object> entry = new LinkedHashMap<>(); entry.put("locale", pack.locale); entry.put("revision", pack.revision);
                entry.put("path", relative); entry.put("size", (long) bytes.length); entry.put("sha256", hash); packs.add(entry);
                packs.sort(Comparator.comparing(value -> String.valueOf(StrictJson.map(value).get("locale"))));
                if (args.length > 4 && args[4].equals("default")) {
                    Locale locale = Locale.forLanguageTag(pack.locale);
                    StrictJson.map(root.get("defaults")).put(locale.getLanguage() + (locale.getScript().isEmpty() ? "" : "-" + locale.getScript()), pack.locale);
                }
                byte[] nextIndex = (json(root, 0) + "\n").getBytes(StandardCharsets.UTF_8); TranslationIndex.parse(nextIndex);
                Path packFile = repo.resolve("translations").resolve(relative).normalize();
                if (!packFile.startsWith(repo.resolve("translations/packs"))) throw new IllegalArgumentException("Invalid pack destination");
                Files.createDirectories(packFile.getParent());
                if (Files.exists(packFile) && !Arrays.equals(Files.readAllBytes(packFile), bytes)) throw new IllegalArgumentException("Immutable pack already exists with different content");
                Files.write(packFile, bytes); atomic(indexFile, nextIndex); report(pack, english);
                System.out.println("Prepared " + relative + " (" + bytes.length + " bytes). Commit and push translations/ to publish."); break;
            }
            default: throw new IllegalArgumentException("Unknown command");
        }
    }
    private static void report(TranslationPack pack, TranslationPack english) {
        int total = english.strings.size() + english.plurals.size(), count = pack.strings.size() + pack.plurals.size();
        System.out.printf(Locale.ROOT, "%s revision %d: %d/%d entries (%.1f%% coverage)%n", pack.locale, pack.revision, count, total, total == 0 ? 100d : 100d * count / total);
    }
    private static byte[] publicationBytes(byte[] input) {
        // Hash the bytes that Git and HTTP will publish, independent of author checkout endings.
        // Escaped JSON \r and \n sequences remain literal; raw newlines inside strings still fail parsing.
        String json = TranslationPack.decode(input, TranslationPack.MAX_BYTES);
        return json.replace("\r\n", "\n").replace('\r', '\n').getBytes(StandardCharsets.UTF_8);
    }
    private static void write(Path path, Object root) throws Exception { atomic(path, (json(root, 0) + "\n").getBytes(StandardCharsets.UTF_8)); }
    private static void atomic(Path path, byte[] bytes) throws Exception {
        Files.createDirectories(path.toAbsolutePath().getParent()); Path temp = Files.createTempFile(path.toAbsolutePath().getParent(), "translation-", ".tmp");
        try { Files.write(temp, bytes); Files.move(temp, path, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE); }
        catch (AtomicMoveNotSupportedException ex) { Files.move(temp, path, StandardCopyOption.REPLACE_EXISTING); }
        finally { Files.deleteIfExists(temp); }
    }
    private static String quote(String value) {
        StringBuilder out = new StringBuilder("\"");
        for (char c : value.toCharArray()) switch (c) {
            case '"': out.append("\\\""); break; case '\\': out.append("\\\\"); break;
            case '\n': out.append("\\n"); break; case '\r': out.append("\\r"); break; case '\t': out.append("\\t"); break;
            default: if (c < 32) out.append(String.format(Locale.ROOT, "\\u%04x", (int) c)); else out.append(c);
        }
        return out.append('"').toString();
    }
    private static String json(Object value, int depth) {
        if (value instanceof String) return quote((String) value);
        if (value instanceof Number || value instanceof Boolean) return value.toString();
        if (value == null) return "null";
        String indent = "  ".repeat(depth), child = indent + "  "; List<String> parts = new ArrayList<>();
        if (value instanceof Map) {
            for (Map.Entry<String, Object> entry : StrictJson.map(value).entrySet()) parts.add(child + quote(entry.getKey()) + ": " + json(entry.getValue(), depth + 1));
            return parts.isEmpty() ? "{}" : "{\n" + String.join(",\n", parts) + "\n" + indent + "}";
        }
        for (Object item : (List<?>) value) parts.add(child + json(item, depth + 1));
        return parts.isEmpty() ? "[]" : "[\n" + String.join(",\n", parts) + "\n" + indent + "]";
    }
}
