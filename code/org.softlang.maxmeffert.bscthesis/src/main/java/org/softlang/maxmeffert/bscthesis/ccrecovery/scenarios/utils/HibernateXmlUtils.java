package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragment;

public class HibernateXmlUtils {

    private static final String HbmClassTagName = "class";

    public static boolean isHbmClassTag(XMLElementFragment xmlElementFragment) {
        return XmlFragmentUtils.isTag(xmlElementFragment, HbmClassTagName);
    }
}
