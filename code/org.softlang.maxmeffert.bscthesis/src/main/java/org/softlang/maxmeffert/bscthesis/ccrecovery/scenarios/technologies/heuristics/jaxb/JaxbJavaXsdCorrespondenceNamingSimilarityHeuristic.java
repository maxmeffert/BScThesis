package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.IdentifiedJavaFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaFieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaMethodFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlElementFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.BaseJavaXmlSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.XmlFragmentUtils;

public class JaxbJavaXsdCorrespondenceNamingSimilarityHeuristic extends BaseJavaXmlSimilarityHeuristic {

    private boolean hasXsComplexTypeSimilarity(IdentifiedJavaFragment identifiedJavaFragmentAST, XmlElementFragment xmlElementFragmentAST) {
        return XmlFragmentUtils.hasAttribute(xmlElementFragmentAST, "name", identifiedJavaFragmentAST.getIdentifier());
    }

    private boolean hasXsElementSimilarity(IdentifiedJavaFragment identifiedJavaFragmentAST, XmlElementFragment xmlElementFragmentAST) {
        return XmlFragmentUtils.hasAttribute(xmlElementFragmentAST, "name", identifiedJavaFragmentAST.getIdentifier());
    }

    private boolean hasXsAttributeSimilarity(IdentifiedJavaFragment identifiedJavaFragmentAST, XmlElementFragment xmlElementFragmentAST) {
        return XmlFragmentUtils.hasAttribute(xmlElementFragmentAST, "name", identifiedJavaFragmentAST.getIdentifier());
    }

    private boolean hasJaxbNamingSimilarity(IdentifiedJavaFragment identifiedJavaFragmentAST, XmlElementFragment xmlElementFragmentAST) {
        if (XmlFragmentUtils.isXsComplexTypeTag(xmlElementFragmentAST)) {
            return hasXsComplexTypeSimilarity(identifiedJavaFragmentAST, xmlElementFragmentAST);
        }
        else if (XmlFragmentUtils.isXsElementTag(xmlElementFragmentAST)) {
            return hasXsElementSimilarity(identifiedJavaFragmentAST, xmlElementFragmentAST);
        }
        else if (XmlFragmentUtils.isXsAttributeTag(xmlElementFragmentAST)) {
            return hasXsAttributeSimilarity(identifiedJavaFragmentAST, xmlElementFragmentAST);
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
