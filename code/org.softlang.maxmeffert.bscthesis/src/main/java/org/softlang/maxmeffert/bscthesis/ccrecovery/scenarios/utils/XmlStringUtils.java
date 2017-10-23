package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils;

public class XmlStringUtils {

    private static final String XmlNamespaceSeparator = ":";
    private static final String XsComplexTypeTagName = "complexType";
    private static final String XsElementTagName = "element";
    private static final String XsAttributeTagName = "attribute";

    public static String removeXmlNamespacePrefix(String string) {
        int indexOfXmlNamespaceSeparator = string.indexOf(XmlNamespaceSeparator);
        if (indexOfXmlNamespaceSeparator > -1) {
            return string.substring(indexOfXmlNamespaceSeparator+1, string.length());
        }
        return string;
    }

    public static boolean isXsComplexTypeTag(String string) {
        return StringUtils.areLowerCaseEqual(removeXmlNamespacePrefix(string), XsComplexTypeTagName);
    }

    public static boolean isXsElementTag(String string) {
        return StringUtils.areLowerCaseEqual(removeXmlNamespacePrefix(string), XsElementTagName);
    }

    public static boolean isXsAttributeTag(String string) {
        return StringUtils.areLowerCaseEqual(removeXmlNamespacePrefix(string), XsAttributeTagName);
    }

}
