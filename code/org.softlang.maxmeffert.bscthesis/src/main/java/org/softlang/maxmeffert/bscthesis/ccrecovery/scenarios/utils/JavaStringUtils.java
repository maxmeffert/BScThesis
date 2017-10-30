package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils;

public class JavaStringUtils {

    private static final String[] JavaAccessorPrefixes = new String[] {"get", "set", "is"};

    public static String removeAnyJavaAccessorPrefix(String string) {
        return StringUtils.removeAnyPrefix(string, JavaAccessorPrefixes);
    }

    public static String normalizeMethodName(String string) {
        return StringUtils.removePluralSuffix(removeAnyJavaAccessorPrefix(string));
    }

}
