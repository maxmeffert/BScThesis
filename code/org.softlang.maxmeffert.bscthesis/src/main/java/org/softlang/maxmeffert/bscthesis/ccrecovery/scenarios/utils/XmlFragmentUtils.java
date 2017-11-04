package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlElementFragment;

import javax.xml.bind.annotation.XmlElement;
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

    public static boolean hasElement(XmlElementFragment xmlElementFragment, Predicate<XmlElementFragment> predicate) {
        return xmlElementFragment.getXmlElementFragments().stream().anyMatch(predicate);
    }

    public static boolean hasElement(XmlElementFragment xmlElementFragment, String elementName) {
        return hasElement(xmlElementFragment, element -> StringUtils.areLowerCaseEqual(element.getName(), elementName));
    }

    public static boolean hasElement(XmlElementFragment xmlElementFragment, String elementName, Predicate<XmlElementFragment> predicate) {
        return hasElement(xmlElementFragment, element -> StringUtils.areLowerCaseEqual(element.getName(), elementName) && predicate.test(element));
    }

}
