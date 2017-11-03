package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragment;

import java.util.function.Predicate;

public class XmlFragmentUtils {

    public static boolean isTag(XMLElementFragment xmlElementFragment, String tagName) {
        return XmlStringUtils.areLowerCaseEqual(xmlElementFragment.getName(), tagName);
    }

    public static boolean isXsComplexTypeTag(XMLElementFragment xmlElementFragment) {
        return XmlStringUtils.isXsComplexTypeTag(xmlElementFragment.getName());
    }

    public static boolean isXsElementTag(XMLElementFragment xmlElementFragment) {
        return XmlStringUtils.isXsElementTag(xmlElementFragment.getName());
    }

    public static boolean isXsAttributeTag(XMLElementFragment xmlElementFragment) {
        return XmlStringUtils.isXsAttributeTag(xmlElementFragment.getName());
    }

    public static boolean hasAttribute(XMLElementFragment xmlElementFragment, Predicate<XMLAttributeFragment> predicate) {
        return xmlElementFragment.getXmlAttributeFragments().stream().anyMatch(predicate);
    }

    public static boolean hasAttribute(XMLElementFragment xmlElementFragment, String attributeName, String attributeValue) {
        return hasAttribute(xmlElementFragment,
                attribute -> StringUtils.areLowerCaseEqual(attribute.getName(), attributeName)
                        && StringUtils.areLowerCaseEqual(StringUtils.removeQuotes(attribute.getValue()), attributeValue));
    }

}
