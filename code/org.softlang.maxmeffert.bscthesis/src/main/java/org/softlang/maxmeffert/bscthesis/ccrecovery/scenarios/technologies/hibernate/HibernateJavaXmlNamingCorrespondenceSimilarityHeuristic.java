package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.hibernate;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaFieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaMethodFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XmlAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XmlElementFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.BaseJavaXmlSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.HibernateXmlUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.JavaStringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.XmlFragmentUtils;

public class HibernateJavaXmlNamingCorrespondenceSimilarityHeuristic extends BaseJavaXmlSimilarityHeuristic {

    private boolean isMemberMapping(XmlElementFragment xmlElementFragment) {
        return HibernateXmlUtils.isHbmIdTag(xmlElementFragment)
                || HibernateXmlUtils.isHbmPropertyTag(xmlElementFragment)
                || HibernateXmlUtils.isHbmBagTag(xmlElementFragment)
                || HibernateXmlUtils.isHbmListTag(xmlElementFragment)
                || HibernateXmlUtils.isHbmSetTag(xmlElementFragment)
                || HibernateXmlUtils.isHbmMapTag(xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaClassFragment javaClassFragment, XmlElementFragment xmlElementFragment) {
        if (HibernateXmlUtils.isHbmClassTag(xmlElementFragment)) {
            return XmlFragmentUtils.hasAttribute(xmlElementFragment, "name", javaClassFragment.getFullName());
        }
        return false;
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XmlElementFragment xmlElementFragment) {
        if (isMemberMapping(xmlElementFragment)) {
            return XmlFragmentUtils.hasAttribute(xmlElementFragment, "name", javaFieldFragment.getIdentifier());
        }
        return false;
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XmlAttributeFragment xmlAttributeFragment) {
        return false;
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XmlElementFragment xmlElementFragment) {
        if (isMemberMapping(xmlElementFragment)) {
            return XmlFragmentUtils.hasAttribute(xmlElementFragment, "name", JavaStringUtils.removeAnyJavaAccessorPrefix(javaMethodFragment.getIdentifier()));
        }
        return false;
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XmlAttributeFragment xmlAttributeFragment) {
        return false;
    }
}
