package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragmentAST;

public class XmlFragmentASTUtils {

    public static boolean isXsComplexTypeTag(XMLElementFragmentAST xmlElementFragmentAST) {
        return XmlStringUtils.isXsComplexTypeTag(xmlElementFragmentAST.getName());
    }

    public static boolean isXsElementTag(XMLElementFragmentAST xmlElementFragmentAST) {
        return XmlStringUtils.isXsElementTag(xmlElementFragmentAST.getName());
    }

    public static boolean isXsAttributeTag(XMLElementFragmentAST xmlElementFragmentAST) {
        return XmlStringUtils.isXsAttributeTag(xmlElementFragmentAST.getName());
    }

    public static boolean hasAttribute(XMLElementFragmentAST xmlElementFragmentAST, String attributeName, String attributeValue) {
        return xmlElementFragmentAST.getXmlAttributeFragments().stream()
                .anyMatch(attribute -> StringUtils.areEqual(attribute.getName(), attributeName) && StringUtils.areEqual(StringUtils.removeQuotes(attribute.getValue()), attributeValue));
    }

}
