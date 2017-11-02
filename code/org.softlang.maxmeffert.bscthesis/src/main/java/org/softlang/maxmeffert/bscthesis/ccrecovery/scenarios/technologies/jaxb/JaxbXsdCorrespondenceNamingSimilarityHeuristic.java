package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.IdentifiedJavaFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaFieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaMethodFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.XmlFragmentASTUtils;

public class JaxbXsdCorrespondenceNamingSimilarityHeuristic extends BaseJaxbSimilarityHeuristic {

    private boolean hasXsComplexTypeSimilarity(IdentifiedJavaFragment identifiedJavaFragmentAST, XMLElementFragment xmlElementFragmentAST) {
        return XmlFragmentASTUtils.hasAttribute(xmlElementFragmentAST, "name", identifiedJavaFragmentAST.getIdentifier());
    }

    private boolean hasXsElementSimilarity(IdentifiedJavaFragment identifiedJavaFragmentAST, XMLElementFragment xmlElementFragmentAST) {
        return XmlFragmentASTUtils.hasAttribute(xmlElementFragmentAST, "name", identifiedJavaFragmentAST.getIdentifier());
    }

    private boolean hasXsAttributeSimilarity(IdentifiedJavaFragment identifiedJavaFragmentAST, XMLElementFragment xmlElementFragmentAST) {
        return XmlFragmentASTUtils.hasAttribute(xmlElementFragmentAST, "name", identifiedJavaFragmentAST.getIdentifier());
    }

    private boolean hasJaxbNamingSimilarity(IdentifiedJavaFragment identifiedJavaFragmentAST, XMLElementFragment xmlElementFragmentAST) {
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
    protected boolean similar(JavaClassFragment javaClassFragment, XMLElementFragment xmlElementFragment) {
        return hasJaxbNamingSimilarity(javaClassFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XMLElementFragment xmlElementFragment) {
        return hasJaxbNamingSimilarity(javaFieldFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XMLAttributeFragment xmlAttributeFragment) {
        return false;
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XMLElementFragment xmlElementFragment) {
        return hasJaxbNamingSimilarity(javaMethodFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XMLAttributeFragment xmlAttributeFragment) {
        return false;
    }
}
