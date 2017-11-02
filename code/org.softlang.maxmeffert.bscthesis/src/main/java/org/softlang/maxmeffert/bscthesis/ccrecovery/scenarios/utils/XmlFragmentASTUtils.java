package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragment;

import java.util.function.Predicate;

public class XmlFragmentASTUtils {

    public static boolean isXsComplexTypeTag(XMLElementFragment xmlElementFragmentAST) {
        return XmlStringUtils.isXsComplexTypeTag(xmlElementFragmentAST.getName());
    }

    public static boolean isXsElementTag(XMLElementFragment xmlElementFragmentAST) {
        return XmlStringUtils.isXsElementTag(xmlElementFragmentAST.getName());
    }

    public static boolean isXsAttributeTag(XMLElementFragment xmlElementFragmentAST) {
        return XmlStringUtils.isXsAttributeTag(xmlElementFragmentAST.getName());
    }

    public static boolean hasAttribute(XMLElementFragment xmlElementFragmentAST, Predicate<XMLAttributeFragment> predicate) {
        return xmlElementFragmentAST.getXmlAttributeFragments().stream().anyMatch(predicate);
    }

    public static boolean hasAttribute(XMLElementFragment xmlElementFragmentAST, String attributeName, String attributeValue) {
        return hasAttribute(xmlElementFragmentAST, attribute -> StringUtils.areLowerCaseEqual(attribute.getName(), attributeName) && StringUtils.areLowerCaseEqual(StringUtils.removeQuotes(attribute.getValue()), attributeValue));
    }

}
