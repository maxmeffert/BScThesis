package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlElementFragment;

import java.util.function.Predicate;

public class XmlFragmentUtils {

    private static final String XsComplexTypeTagName = "complexType";
    private static final String XsElementTagName = "element";
    private static final String XsAttributeTagName = "attribute";

    public static boolean isTag(XmlElementFragment xmlElementFragment, String tagName) {
        return XmlStringUtils.areLowerCaseEqual(xmlElementFragment.getName(), tagName);
    }

    public static boolean isXsComplexTypeTag(XmlElementFragment xmlElementFragment) {
        return isTag(xmlElementFragment, XsComplexTypeTagName);
    }

    public static boolean isXsElementTag(XmlElementFragment xmlElementFragment) {
        return isTag(xmlElementFragment, XsElementTagName);
    }

    public static boolean isXsAttributeTag(XmlElementFragment xmlElementFragment) {
        return isTag(xmlElementFragment, XsAttributeTagName);
    }

    public static boolean hasAttribute(XmlElementFragment xmlElementFragment, Predicate<XmlAttributeFragment> predicate) {
        return xmlElementFragment.getXmlAttributeFragments().stream().anyMatch(predicate);
    }

    public static boolean hasAttribute(XmlElementFragment xmlElementFragment, String attributeName, String attributeValue) {
        return hasAttribute(xmlElementFragment,
                attribute -> StringUtils.areLowerCaseEqual(attribute.getName(), attributeName)
                        && StringUtils.areLowerCaseEqual(StringUtils.removeQuotes(attribute.getValue()), attributeValue));
    }

}
