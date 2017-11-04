package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.hibernate;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaFieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaMethodFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.BaseJavaXmlSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.HibernateXmlUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.JavaStringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.XmlFragmentUtils;

public class HibernateJavaXmlNamingCorrespondenceSimilarityHeuristic extends BaseJavaXmlSimilarityHeuristic {

    private boolean isMemberMapping(XMLElementFragment xmlElementFragment) {
        return HibernateXmlUtils.isHbmIdTag(xmlElementFragment)
                || HibernateXmlUtils.isHbmPropertyTag(xmlElementFragment)
                || HibernateXmlUtils.isHbmBagTag(xmlElementFragment)
                || HibernateXmlUtils.isHbmListTag(xmlElementFragment)
                || HibernateXmlUtils.isHbmSetTag(xmlElementFragment)
                || HibernateXmlUtils.isHbmMapTag(xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaClassFragment javaClassFragment, XMLElementFragment xmlElementFragment) {
        if (HibernateXmlUtils.isHbmClassTag(xmlElementFragment)) {
            return XmlFragmentUtils.hasAttribute(xmlElementFragment, "name", javaClassFragment.getFullName());
        }
        return false;
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XMLElementFragment xmlElementFragment) {
        if (isMemberMapping(xmlElementFragment)) {
            return XmlFragmentUtils.hasAttribute(xmlElementFragment, "name", javaFieldFragment.getIdentifier());
        }
        return false;
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XMLAttributeFragment xmlAttributeFragment) {
        return false;
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XMLElementFragment xmlElementFragment) {
        if (isMemberMapping(xmlElementFragment)) {
            return XmlFragmentUtils.hasAttribute(xmlElementFragment, "name", JavaStringUtils.removeAnyJavaAccessorPrefix(javaMethodFragment.getIdentifier()));
        }
        return false;
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XMLAttributeFragment xmlAttributeFragment) {
        return false;
    }
}
