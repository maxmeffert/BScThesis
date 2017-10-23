package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.IdentifiedJavaFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaClassFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaFieldFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaMethodFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.StringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.XmlFragmentASTUtils;

public class JaxbXsdCorrespondenceNamingSimilarityHeuristic extends BaseJaxbSimilarityHeuristic {

    private boolean hasXsComplexTypeSimilarity(IdentifiedJavaFragmentAST identifiedJavaFragmentAST, XMLElementFragmentAST xmlElementFragmentAST) {
        return XmlFragmentASTUtils.hasAttribute(xmlElementFragmentAST, "name", identifiedJavaFragmentAST.getIdentifier());
    }

    private boolean hasXsElementSimilarity(IdentifiedJavaFragmentAST identifiedJavaFragmentAST, XMLElementFragmentAST xmlElementFragmentAST) {
        return XmlFragmentASTUtils.hasAttribute(xmlElementFragmentAST, "name", identifiedJavaFragmentAST.getIdentifier());
    }

    private boolean hasXsAttributeSimilarity(IdentifiedJavaFragmentAST identifiedJavaFragmentAST, XMLElementFragmentAST xmlElementFragmentAST) {
        return XmlFragmentASTUtils.hasAttribute(xmlElementFragmentAST, "name", identifiedJavaFragmentAST.getIdentifier());
    }

    private boolean hasJaxbNamingSimilarity(IdentifiedJavaFragmentAST identifiedJavaFragmentAST, XMLElementFragmentAST xmlElementFragmentAST) {
        if (XmlFragmentASTUtils.isXsComplexTypeTag(xmlElementFragmentAST)) {
            return hasXsComplexTypeSimilarity(identifiedJavaFragmentAST, xmlElementFragmentAST);
        }
        else if (XmlFragmentASTUtils.isXsElementTag(xmlElementFragmentAST)) {
            return hasXsElementSimilarity(identifiedJavaFragmentAST, xmlElementFragmentAST);
        }
        else if (XmlFragmentASTUtils.isXsAttributeTag(xmlElementFragmentAST)) {
            return hasXsAttributeSimilarity(identifiedJavaFragmentAST, xmlElementFragmentAST);
        }
        return false;
    }

    @Override
    protected boolean similar(JavaClassFragmentAST javaClassFragment, XMLElementFragmentAST xmlElementFragment) {
        return hasJaxbNamingSimilarity(javaClassFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLElementFragmentAST xmlElementFragment) {
        return hasJaxbNamingSimilarity(javaFieldFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        return false;
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLElementFragmentAST xmlElementFragment) {
        return hasJaxbNamingSimilarity(javaMethodFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        return false;
    }
}
