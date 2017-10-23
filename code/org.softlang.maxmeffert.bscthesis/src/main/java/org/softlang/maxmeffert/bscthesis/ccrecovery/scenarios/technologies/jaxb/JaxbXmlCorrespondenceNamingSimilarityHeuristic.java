package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.NamedXMLFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.JavaStringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.StringUtils;

public class JaxbXmlCorrespondenceNamingSimilarityHeuristic extends BaseJaxbSimilarityHeuristic {

    private boolean hasJaxbNamingSimilarities(String javaIdentifier, String xmlName) {
        return StringUtils.areEqual(javaIdentifier,xmlName)
                || StringUtils.areLowerCaseEqual(javaIdentifier,xmlName)
                || StringUtils.areLowerCaseEqual(StringUtils.removePluralSuffix(javaIdentifier), xmlName)
                || StringUtils.areLowerCaseEqual(JavaStringUtils.removeAnyJavaAccessorPrefix(javaIdentifier), xmlName)
                || StringUtils.areLowerCaseEqual(JavaStringUtils.removeAnyJavaAccessorPrefix(StringUtils.removePluralSuffix(javaIdentifier)), xmlName);
    }

    private boolean hasJaxbNamingSimilarities(IdentifiedJavaFragmentAST identifiedJavaFragmentAST, NamedXMLFragmentAST namedXMLFragmentAST) {
        return hasJaxbNamingSimilarities(identifiedJavaFragmentAST.getIdentifier(), namedXMLFragmentAST.getName());
    }

    @Override
    protected boolean similar(JavaClassFragmentAST javaClassFragment, XMLElementFragmentAST xmlElementFragment) {
        return hasJaxbNamingSimilarities(javaClassFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLElementFragmentAST xmlElementFragment) {
        return hasJaxbNamingSimilarities(javaFieldFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLElementFragmentAST xmlElementFragment) {
        return hasJaxbNamingSimilarities(javaMethodFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        return hasJaxbNamingSimilarities(javaFieldFragment, xmlAttributeFragment);
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        return hasJaxbNamingSimilarities(javaMethodFragment, xmlAttributeFragment);
    }
}
