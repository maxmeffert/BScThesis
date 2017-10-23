package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragmentAST;

import java.util.function.Predicate;

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

    public static boolean hasAttribute(XMLElementFragmentAST xmlElementFragmentAST, Predicate<XMLAttributeFragmentAST> predicate) {
        return xmlElementFragmentAST.getXmlAttributeFragments().stream().anyMatch(predicate);
    }

    public static boolean hasAttribute(XMLElementFragmentAST xmlElementFragmentAST, String attributeName, String attributeValue) {
        return hasAttribute(xmlElementFragmentAST, attribute -> StringUtils.areLowerCaseEqual(attribute.getName(), attributeName) && StringUtils.areLowerCaseEqual(StringUtils.removeQuotes(attribute.getValue()), attributeValue));
    }

}
