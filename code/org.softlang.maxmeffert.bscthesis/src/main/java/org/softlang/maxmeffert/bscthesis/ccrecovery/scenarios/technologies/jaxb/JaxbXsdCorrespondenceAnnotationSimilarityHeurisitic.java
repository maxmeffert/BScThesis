package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlElementFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.BaseJavaXmlSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.JaxbStringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.StringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.XmlFragmentUtils;

public class JaxbXsdCorrespondenceAnnotationSimilarityHeurisitic extends BaseJavaXmlSimilarityHeuristic {

    private boolean hasXsAttributeSimilarity(JavaAnnotationFragment javaAnnotationFragment, XmlElementFragment xmlElementFragmentAST) {
        return XmlFragmentUtils.hasAttribute(xmlElementFragmentAST, "name", StringUtils.removeQuotes(javaAnnotationFragment.getNamedParamterValue("name")));
    }

    private boolean hasXsElementSimilarity(JavaAnnotationFragment javaAnnotationFragment, XmlElementFragment xmlElementFragmentAST) {
        return XmlFragmentUtils.hasAttribute(xmlElementFragmentAST, "name", StringUtils.removeQuotes(javaAnnotationFragment.getNamedParamterValue("name")));
    }

    private boolean hasXsComplexTypeSimilarity(JavaAnnotationFragment javaAnnotationFragment, XmlElementFragment xmlElementFragmentAST) {
        return XmlFragmentUtils.hasAttribute(xmlElementFragmentAST, "name", StringUtils.removeQuotes(javaAnnotationFragment.getNamedParamterValue("name")));
    }

    private boolean hasJaxbAnnotationSimilarity(JavaAnnotationFragment javaAnnotationFragment, XmlElementFragment xmlElementFragmentAST) {
        if (JaxbStringUtils.equalsAnyJaxbAnnotationName(javaAnnotationFragment.getIdentifier())) {
            if (javaAnnotationFragment.hasNamedParameter("name")) {
                if (XmlFragmentUtils.isXsComplexTypeTag(xmlElementFragmentAST)) {
                    return hasXsComplexTypeSimilarity(javaAnnotationFragment, xmlElementFragmentAST);
                }
                else if (XmlFragmentUtils.isXsElementTag(xmlElementFragmentAST)) {
                    return hasXsElementSimilarity(javaAnnotationFragment, xmlElementFragmentAST);
                }
                else if (XmlFragmentUtils.isXsAttributeTag(xmlElementFragmentAST)) {
                    return hasXsAttributeSimilarity(javaAnnotationFragment, xmlElementFragmentAST);
                }
            }
        }
        return false;
    }

    private boolean hasJaxbAnnotationSimilarity(ModifiedJavaFragment modifiedJavaFragmentAST, XmlElementFragment xmlElementFragmentAST) {
        for (JavaModifierFragment javaModifierFragment : modifiedJavaFragmentAST.getJavaModifierFragments()) {
            if (javaModifierFragment.isAnnotation()) {
                if (hasJaxbAnnotationSimilarity(javaModifierFragment.getJavaAnnotationFragment(), xmlElementFragmentAST)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected boolean similar(JavaClassFragment javaClassFragment, XmlElementFragment xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaClassFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XmlElementFragment xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaFieldFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XmlAttributeFragment xmlAttributeFragment) {
        return false;
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XmlElementFragment xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaMethodFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XmlAttributeFragment xmlAttributeFragment) {
        return false;
    }
}
