package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XmlElementFragment;

public class HibernateXmlUtils {

    private static final String HbmClassTagName = "class";
    private static final String HbmIdTagName = "id";
    private static final String HbmPropertyTagName = "property";
    private static final String HbmBagTagName = "bag";
    private static final String HbmListTagName = "list";
    private static final String HbmSetTagName = "set";
    private static final String HbmMapTagName = "map";

    public static boolean isHbmClassTag(XmlElementFragment xmlElementFragment) {
        return XmlFragmentUtils.isTag(xmlElementFragment, HbmClassTagName);
    }

    public static boolean isHbmIdTag(XmlElementFragment xmlElementFragment) {
        return XmlFragmentUtils.isTag(xmlElementFragment, HbmIdTagName);
    }

    public static boolean isHbmPropertyTag(XmlElementFragment xmlElementFragment) {
        return XmlFragmentUtils.isTag(xmlElementFragment, HbmPropertyTagName);
    }

    public static boolean isHbmBagTag(XmlElementFragment xmlElementFragment) {
        return XmlFragmentUtils.isTag(xmlElementFragment, HbmBagTagName);
    }

    public static boolean isHbmListTag(XmlElementFragment xmlElementFragment) {
        return XmlFragmentUtils.isTag(xmlElementFragment, HbmListTagName);
    }

    public static boolean isHbmSetTag(XmlElementFragment xmlElementFragment) {
        return XmlFragmentUtils.isTag(xmlElementFragment, HbmSetTagName);
    }

    public static boolean isHbmMapTag(XmlElementFragment xmlElementFragment) {
        return XmlFragmentUtils.isTag(xmlElementFragment, HbmMapTagName);
    }

}
