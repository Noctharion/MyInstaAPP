package app.myinsta.runtime.i18n;

import java.util.*;

/** Small strict parser shared by runtime, publication tools and tests. Rejects duplicate keys. */
public final class StrictJson {
    private final String input;
    private int at;
    private StrictJson(String input) { this.input = input; }
    public static Map<String, Object> object(String input) {
        StrictJson parser = new StrictJson(input);
        Object result = parser.value(0);
        parser.space();
        if (parser.at != input.length() || !(result instanceof Map)) throw parser.error();
        return map(result);
    }
    @SuppressWarnings("unchecked") public static Map<String, Object> map(Object value) {
        if (!(value instanceof Map)) throw new IllegalArgumentException("Expected JSON object");
        return (Map<String, Object>) value;
    }
    public static String string(Object value) {
        if (!(value instanceof String)) throw new IllegalArgumentException("Expected JSON string");
        return (String) value;
    }
    public static long integer(Object value) {
        if (!(value instanceof Long)) throw new IllegalArgumentException("Expected JSON integer");
        return (Long) value;
    }
    private IllegalArgumentException error() { return new IllegalArgumentException("Invalid JSON at " + at); }
    private void space() { while (at < input.length() && " \t\n\r".indexOf(input.charAt(at)) >= 0) at++; }
    private boolean take(char c) { space(); if (at < input.length() && input.charAt(at) == c) { at++; return true; } return false; }
    private void require(char c) { if (!take(c)) throw error(); }
    private static boolean digit(char c) { return c >= '0' && c <= '9'; }
    private Object value(int depth) {
        if (depth > 32) throw error();
        space(); if (at == input.length()) throw error();
        char c = input.charAt(at);
        if (c == '"') return quoted();
        if (take('{')) {
            Map<String, Object> result = new LinkedHashMap<>();
            if (take('}')) return result;
            do {
                space(); if (at == input.length() || input.charAt(at) != '"') throw error();
                String key = quoted(); require(':');
                if (result.containsKey(key)) throw new IllegalArgumentException("Duplicate JSON key: " + key);
                result.put(key, value(depth + 1));
                if (take('}')) return result;
            } while (take(','));
            throw error();
        }
        if (take('[')) {
            List<Object> result = new ArrayList<>();
            if (take(']')) return result;
            do { result.add(value(depth + 1)); if (take(']')) return result; } while (take(','));
            throw error();
        }
        for (String literal : new String[]{"true", "false", "null"}) {
            if (input.startsWith(literal, at)) { at += literal.length(); return "null".equals(literal) ? null : "true".equals(literal); }
        }
        int start = at;
        if (c == '-') at++;
        if (at == input.length()) throw error();
        if (input.charAt(at) == '0') at++;
        else {
            if (input.charAt(at) < '1' || input.charAt(at) > '9') throw error();
            while (at < input.length() && digit(input.charAt(at))) at++;
        }
        boolean decimal = false;
        if (at < input.length() && input.charAt(at) == '.') {
            decimal = true; at++; int digits = at;
            while (at < input.length() && digit(input.charAt(at))) at++;
            if (digits == at) throw error();
        }
        if (at < input.length() && (input.charAt(at) == 'e' || input.charAt(at) == 'E')) {
            decimal = true; at++;
            if (at < input.length() && (input.charAt(at) == '+' || input.charAt(at) == '-')) at++;
            int digits = at; while (at < input.length() && digit(input.charAt(at))) at++;
            if (digits == at) throw error();
        }
        try { if (decimal) return Double.valueOf(input.substring(start, at)); return Long.valueOf(input.substring(start, at)); }
        catch (NumberFormatException ex) { throw error(); }
    }
    private String quoted() {
        require('"'); StringBuilder result = new StringBuilder();
        while (at < input.length()) {
            char c = input.charAt(at++);
            if (c == '"') {
                for (int i = 0; i < result.length(); i++) {
                    char u = result.charAt(i);
                    if (Character.isHighSurrogate(u)) { if (++i >= result.length() || !Character.isLowSurrogate(result.charAt(i))) throw error(); }
                    else if (Character.isLowSurrogate(u)) throw error();
                }
                return result.toString();
            }
            if (c < 32) throw error();
            if (c == '\\') {
                if (at == input.length()) throw error(); c = input.charAt(at++);
                switch (c) {
                    case '"': case '\\': case '/': break;
                    case 'b': c = '\b'; break; case 'f': c = '\f'; break;
                    case 'n': c = '\n'; break; case 'r': c = '\r'; break; case 't': c = '\t'; break;
                    case 'u':
                        if (at + 4 > input.length()) throw error();
                        for (int i = at; i < at + 4; i++) { char hex = input.charAt(i); if (!digit(hex) && !(hex >= 'a' && hex <= 'f') && !(hex >= 'A' && hex <= 'F')) throw error(); }
                        try { c = (char) Integer.parseInt(input.substring(at, at + 4), 16); } catch (NumberFormatException ex) { throw error(); }
                        at += 4; break;
                    default: throw error();
                }
            }
            result.append(c);
        }
        throw error();
    }
}
