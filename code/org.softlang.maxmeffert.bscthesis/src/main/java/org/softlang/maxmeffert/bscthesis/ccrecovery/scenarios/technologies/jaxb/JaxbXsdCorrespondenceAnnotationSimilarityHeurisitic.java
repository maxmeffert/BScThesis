package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.JaxbStringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.StringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.XmlFragmentASTUtils;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

public class JaxbXsdCorrespondenceAnnotationSimilarityHeurisitic extends BaseJaxbSimilarityHeuristic {

    private boolean hasJaxbAnnotationSimilarity(JavaAnnotationFragmentAST javaAnnotationFragment, XMLElementFragmentAST xmlElementFragmentAST) {
        if (JaxbStringUtils.equalsAnyJaxbAnnotationName(javaAnnotationFragment.getIdentifier())) {
            if (javaAnnotationFragment.hasNamedParameter("name")) {
                if (XmlFragmentASTUtils.isXsComplexTypeTag(xmlElementFragmentAST)) {
                    return XmlFragmentASTUtils.hasAttribute(xmlElementFragmentAST, "name", StringUtils.removeQuotes(javaAnnotationFragment.getNamedParamterValue("name")));
                }
                else if (XmlFragmentASTUtils.isXsElementTag(xmlElementFragmentAST)) {
                    return XmlFragmentASTUtils.hasAttribute(xmlElementFragmentAST, "name", StringUtils.removeQuotes(javaAnnotationFragment.getNamedParamterValue("name")));
                }
                else if (XmlFragmentASTUtils.isXsAttributeTag(xmlElementFragmentAST)) {
                    return XmlFragmentASTUtils.hasAttribute(xmlElementFragmentAST, "name", StringUtils.removeQuotes(javaAnnotationFragment.getNamedParamterValue("name")));
                }
            }
        }
        return false;
    }

    private boolean hasJaxbAnnotationSimilarity(ModifiedJavaFragmentAST modifiedJavaFragmentAST, XMLElementFragmentAST xmlElementFragmentAST) {
        for (JavaModifierFragmentAST javaModifierFragment : modifiedJavaFragmentAST.getJavaModifierFragments()) {
            if (javaModifierFragment.isAnnotation()) {
                if (hasJaxbAnnotationSimilarity(javaModifierFragment.getJavaAnnotationFragment(), xmlElementFragmentAST)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected boolean similar(JavaClassFragmentAST javaClassFragment, XMLElementFragmentAST xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaClassFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLElementFragmentAST xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaFieldFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        return false;
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLElementFragmentAST xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaMethodFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        return false;
    }
}
