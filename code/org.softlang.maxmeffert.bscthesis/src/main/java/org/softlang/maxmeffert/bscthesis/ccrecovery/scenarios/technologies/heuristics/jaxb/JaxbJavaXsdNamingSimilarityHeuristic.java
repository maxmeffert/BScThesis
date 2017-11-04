package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.IdentifiedJavaFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaFieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaMethodFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlElementFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.BaseJavaXmlSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.XmlFragmentUtils;

public class JaxbJavaXsdNamingSimilarityHeuristic extends BaseJavaXmlSimilarityHeuristic {

    private boolean hasXsComplexTypeSimilarity(IdentifiedJavaFragment identifiedJavaFragment, XmlElementFragment xmlElementFragment) {
        return XmlFragmentUtils.hasAttribute(xmlElementFragment, "name", identifiedJavaFragment.getIdentifier());
    }

    private boolean hasXsElementSimilarity(IdentifiedJavaFragment identifiedJavaFragment, XmlElementFragment xmlElementFragment) {
        return XmlFragmentUtils.hasAttribute(xmlElementFragment, "name", identifiedJavaFragment.getIdentifier());
    }

    private boolean hasXsAttributeSimilarity(IdentifiedJavaFragment identifiedJavaFragment, XmlElementFragment xmlElementFragment) {
        return XmlFragmentUtils.hasAttribute(xmlElementFragment, "name", identifiedJavaFragment.getIdentifier());
    }

    private boolean hasJaxbNamingSimilarity(IdentifiedJavaFragment identifiedJavaFragment, XmlElementFragment xmlElementFragment) {
        if (XmlFragmentUtils.isXsComplexTypeTag(xmlElementFragment)) {
            return hasXsComplexTypeSimilarity(identifiedJavaFragment, xmlElementFragment);
        }
        else if (XmlFragmentUtils.isXsElementTag(xmlElementFragment)) {
            return hasXsElementSimilarity(identifiedJavaFragment, xmlElementFragment);
        }
        else if (XmlFragmentUtils.isXsAttributeTag(xmlElementFragment)) {
            return hasXsAttributeSimilarity(identifiedJavaFragment, xmlElementFragment);
        }
        return false;
    }

    @Override
    protected boolean areSimilar(JavaClassFragment javaClassFragment, XmlElementFragment xmlElementFragment) {
        return hasJaxbNamingSimilarity(javaClassFragment, xmlElementFragment);
    }

    @Override
    protected boolean areSimilar(JavaFieldFragment javaFieldFragment, XmlElementFragment xmlElementFragment) {
        return hasJaxbNamingSimilarity(javaFieldFragment, xmlElementFragment);
    }

    @Override
    protected boolean areSimilar(JavaFieldFragment javaFieldFragment, XmlAttributeFragment xmlAttributeFragment) {
        return false;
    }

    @Override
    protected boolean areSimilar(JavaMethodFragment javaMethodFragment, XmlElementFragment xmlElementFragment) {
        return hasJaxbNamingSimilarity(javaMethodFragment, xmlElementFragment);
    }

    @Override
    protected boolean areSimilar(JavaMethodFragment javaMethodFragment, XmlAttributeFragment xmlAttributeFragment) {
        return false;
    }
}
