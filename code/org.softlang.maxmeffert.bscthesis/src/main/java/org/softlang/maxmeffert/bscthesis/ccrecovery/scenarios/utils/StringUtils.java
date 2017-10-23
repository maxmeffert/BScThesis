package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils;

public class StringUtils {

    private static final String DoubleQuote = "\"";
    private static final String SingleQuote = "'";

    public static String removeQuotes(String string) {
        if (string.startsWith(DoubleQuote) && string.endsWith(DoubleQuote)) {
            return string.substring(DoubleQuote.length(), string.length()-DoubleQuote.length());
        }
        if (string.startsWith(SingleQuote) && string.endsWith(SingleQuote)) {
            return string.substring(SingleQuote.length(), string.length()-SingleQuote.length());
        }
        return string;
    }

}
