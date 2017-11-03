package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.JaxbStringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.StringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.XmlFragmentUtils;

public class JaxbXsdCorrespondenceAnnotationSimilarityHeurisitic extends BaseJaxbSimilarityHeuristic {

    private boolean hasXsAttributeSimilarity(JavaAnnotationFragment javaAnnotationFragment, XMLElementFragment xmlElementFragmentAST) {
        return XmlFragmentUtils.hasAttribute(xmlElementFragmentAST, "name", StringUtils.removeQuotes(javaAnnotationFragment.getNamedParamterValue("name")));
    }

    private boolean hasXsElementSimilarity(JavaAnnotationFragment javaAnnotationFragment, XMLElementFragment xmlElementFragmentAST) {
        return XmlFragmentUtils.hasAttribute(xmlElementFragmentAST, "name", StringUtils.removeQuotes(javaAnnotationFragment.getNamedParamterValue("name")));
    }

    private boolean hasXsComplexTypeSimilarity(JavaAnnotationFragment javaAnnotationFragment, XMLElementFragment xmlElementFragmentAST) {
        return XmlFragmentUtils.hasAttribute(xmlElementFragmentAST, "name", StringUtils.removeQuotes(javaAnnotationFragment.getNamedParamterValue("name")));
    }

    private boolean hasJaxbAnnotationSimilarity(JavaAnnotationFragment javaAnnotationFragment, XMLElementFragment xmlElementFragmentAST) {
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

    private boolean hasJaxbAnnotationSimilarity(ModifiedJavaFragment modifiedJavaFragmentAST, XMLElementFragment xmlElementFragmentAST) {
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
    protected boolean similar(JavaClassFragment javaClassFragment, XMLElementFragment xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaClassFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XMLElementFragment xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaFieldFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XMLAttributeFragment xmlAttributeFragment) {
        return false;
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XMLElementFragment xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaMethodFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XMLAttributeFragment xmlAttributeFragment) {
        return false;
    }
}
