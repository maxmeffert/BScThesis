package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils;

public class XmlStringUtils {

    private static final String XmlNamespaceSeparator = ":";

    public static String removeXmlNamespacePrefix(String string) {
        int indexOfXmlNamespaceSeparator = string.indexOf(XmlNamespaceSeparator);
        if (indexOfXmlNamespaceSeparator > -1) {
            return string.substring(indexOfXmlNamespaceSeparator+1, string.length());
        }
        return string;
    }

    public static boolean areEqual(String a, String b) {
        return StringUtils.areEqual(removeXmlNamespacePrefix(a), b);
    }

    public static boolean areLowerCaseEqual(String a, String b) {
        return StringUtils.areLowerCaseEqual(removeXmlNamespacePrefix(a), b);
    }

}
