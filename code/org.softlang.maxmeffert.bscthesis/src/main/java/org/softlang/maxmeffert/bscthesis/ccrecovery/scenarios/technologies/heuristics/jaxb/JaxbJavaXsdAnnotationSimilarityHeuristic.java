package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlElementFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.BaseJavaXmlSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.JaxbStringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.StringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.XmlFragmentUtils;

public class JaxbJavaXsdAnnotationSimilarityHeuristic extends BaseJavaXmlSimilarityHeuristic {

    private boolean hasXsAttributeSimilarity(JavaAnnotationFragment javaAnnotationFragment, XmlElementFragment xmlElementFragment) {
        return XmlFragmentUtils.hasAttribute(xmlElementFragment, "name", StringUtils.removeQuotes(javaAnnotationFragment.getNamedParamterValue("name")));
    }

    private boolean hasXsElementSimilarity(JavaAnnotationFragment javaAnnotationFragment, XmlElementFragment xmlElementFragment) {
        return XmlFragmentUtils.hasAttribute(xmlElementFragment, "name", StringUtils.removeQuotes(javaAnnotationFragment.getNamedParamterValue("name")));
    }

    private boolean hasXsComplexTypeSimilarity(JavaAnnotationFragment javaAnnotationFragment, XmlElementFragment xmlElementFragment) {
        return XmlFragmentUtils.hasAttribute(xmlElementFragment, "name", StringUtils.removeQuotes(javaAnnotationFragment.getNamedParamterValue("name")));
    }

    private boolean hasJaxbAnnotationSimilarity(JavaAnnotationFragment javaAnnotationFragment, XmlElementFragment xmlElementFragment) {
        if (JaxbStringUtils.equalsAnyJaxbAnnotationName(javaAnnotationFragment.getIdentifier())) {
            if (javaAnnotationFragment.hasNamedParameter("name")) {
                if (XmlFragmentUtils.isXsComplexTypeTag(xmlElementFragment)) {
                    return hasXsComplexTypeSimilarity(javaAnnotationFragment, xmlElementFragment);
                }
                else if (XmlFragmentUtils.isXsElementTag(xmlElementFragment)) {
                    return hasXsElementSimilarity(javaAnnotationFragment, xmlElementFragment);
                }
                else if (XmlFragmentUtils.isXsAttributeTag(xmlElementFragment)) {
                    return hasXsAttributeSimilarity(javaAnnotationFragment, xmlElementFragment);
                }
            }
        }
        return false;
    }

    private boolean hasJaxbAnnotationSimilarity(ModifiedJavaFragment modifiedJavaFragment, XmlElementFragment xmlElementFragment) {
        for (JavaModifierFragment javaModifierFragment : modifiedJavaFragment.getJavaModifierFragments()) {
            if (javaModifierFragment.isAnnotation()) {
                if (hasJaxbAnnotationSimilarity(javaModifierFragment.getJavaAnnotationFragment(), xmlElementFragment)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected boolean areSimilar(JavaClassFragment javaClassFragment, XmlElementFragment xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaClassFragment, xmlElementFragment);
    }

    @Override
    protected boolean areSimilar(JavaFieldFragment javaFieldFragment, XmlElementFragment xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaFieldFragment, xmlElementFragment);
    }

    @Override
    protected boolean areSimilar(JavaFieldFragment javaFieldFragment, XmlAttributeFragment xmlAttributeFragment) {
        return false;
    }

    @Override
    protected boolean areSimilar(JavaMethodFragment javaMethodFragment, XmlElementFragment xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaMethodFragment, xmlElementFragment);
    }

    @Override
    protected boolean areSimilar(JavaMethodFragment javaMethodFragment, XmlAttributeFragment xmlAttributeFragment) {
        return false;
    }
}
