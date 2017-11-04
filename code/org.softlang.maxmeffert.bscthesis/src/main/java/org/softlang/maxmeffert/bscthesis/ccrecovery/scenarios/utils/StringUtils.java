package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils;

public class StringUtils {

    private static final String DoubleQuote = "\"";
    private static final String SingleQuote = "'";
    private static final String PluralSuffix = "s";

    public static boolean areEqual(String a, String b) {
        return a.equals(b);
    }

    public static boolean areLowerCaseEqual(String a, String b) {
        return areEqual(a.toLowerCase(), b.toLowerCase());
    }

    public static boolean equalsAny(String a, String[] bs) {
        for(String b : bs) {
            if (areEqual(a,b)) {
                return true;
            }
        }
        return false;
    }

    private static boolean lowerCaseEqualsAny(String a, String[] bs) {
        a = a.toLowerCase();
        for(String b : bs) {
            b = b.toLowerCase();
            if (areEqual(a,b)) {
                return true;
            }
        }
        return false;
    }

    public static String removeQuotes(String string) {
        if (string.startsWith(DoubleQuote) && string.endsWith(DoubleQuote)) {
            return string.substring(DoubleQuote.length(), string.length()-DoubleQuote.length());
        }
        if (string.startsWith(SingleQuote) && string.endsWith(SingleQuote)) {
            return string.substring(SingleQuote.length(), string.length()-SingleQuote.length());
        }
        return string;
    }

    public static boolean startsWith(String string, String prefix) {
        return string.length() >= prefix.length() && string.startsWith(prefix);
    }

    public static boolean lowerCaseStartsWith(String string, String prefix) {
        string = string.toLowerCase();
        prefix = prefix.toLowerCase();
        return startsWith(string, prefix);
    }

    public static boolean endsWith(String string, String suffix) {
        return string.length() >= suffix.length() && string.endsWith(suffix);
    }

    public static boolean lowerCaseEndsWith(String string, String suffix) {
        string = string.toLowerCase();
        suffix = suffix.toLowerCase();
        return endsWith(string, suffix);
    }

    public static String removeAnyPrefix(String string, String[] prefixes) {
        for(String prefix : prefixes) {
            if (startsWith(string, prefix)) {
                return string.substring(prefix.length(), string.length());
            }
        }
        return string;
    }

    public static String removeAnySuffix(String string, String[] suffixes) {
        for(String suffix : suffixes) {
            if (endsWith(string, suffix)) {
                return string.substring(0, string.length()-suffix.length());
            }
        }
        return string;
    }

    public static String removePluralSuffix(String string) {
        return removeAnySuffix(string, new String[] { PluralSuffix });
    }

}
