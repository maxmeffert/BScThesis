package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.hibernate;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaFieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaMethodFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlElementFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.BaseJavaXmlSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.HibernateXmlUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.JavaStringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.XmlFragmentUtils;

public class HibernateJavaXmlNamingSimilarityHeuristic extends BaseJavaXmlSimilarityHeuristic {

    private boolean isMemberTag(XmlElementFragment xmlElementFragment) {
        return HibernateXmlUtils.isHbmIdTag(xmlElementFragment)
                || HibernateXmlUtils.isHbmPropertyTag(xmlElementFragment)
                || HibernateXmlUtils.isHbmBagTag(xmlElementFragment)
                || HibernateXmlUtils.isHbmListTag(xmlElementFragment)
                || HibernateXmlUtils.isHbmSetTag(xmlElementFragment)
                || HibernateXmlUtils.isHbmMapTag(xmlElementFragment);
    }

    @Override
    protected boolean areSimilar(JavaClassFragment javaClassFragment, XmlElementFragment xmlElementFragment) {
        if (HibernateXmlUtils.isHbmClassTag(xmlElementFragment)) {
            return XmlFragmentUtils.hasAttribute(xmlElementFragment, "name", javaClassFragment.getFullName());
        }
        return false;
    }

    @Override
    protected boolean areSimilar(JavaFieldFragment javaFieldFragment, XmlElementFragment xmlElementFragment) {
        if (isMemberTag(xmlElementFragment)) {
            return XmlFragmentUtils.hasAttribute(xmlElementFragment, "name", javaFieldFragment.getIdentifier());
        }
        return false;
    }

    @Override
    protected boolean areSimilar(JavaFieldFragment javaFieldFragment, XmlAttributeFragment xmlAttributeFragment) {
        return false;
    }

    @Override
    protected boolean areSimilar(JavaMethodFragment javaMethodFragment, XmlElementFragment xmlElementFragment) {
        if (isMemberTag(xmlElementFragment)) {
            return XmlFragmentUtils.hasAttribute(xmlElementFragment, "name", JavaStringUtils.removeAnyJavaAccessorPrefix(javaMethodFragment.getIdentifier()));
        }
        return false;
    }

    @Override
    protected boolean areSimilar(JavaMethodFragment javaMethodFragment, XmlAttributeFragment xmlAttributeFragment) {
        return false;
    }
}
