package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.NamedXMLFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragment;
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

    private boolean hasJaxbNamingSimilarities(IdentifiedJavaFragment identifiedJavaFragmentAST, NamedXMLFragment namedXMLFragmentAST) {
        return hasJaxbNamingSimilarities(identifiedJavaFragmentAST.getIdentifier(), namedXMLFragmentAST.getName());
    }

    @Override
    protected boolean similar(JavaClassFragment javaClassFragment, XMLElementFragment xmlElementFragment) {
        return hasJaxbNamingSimilarities(javaClassFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XMLElementFragment xmlElementFragment) {
        return hasJaxbNamingSimilarities(javaFieldFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XMLElementFragment xmlElementFragment) {
        return hasJaxbNamingSimilarities(javaMethodFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XMLAttributeFragment xmlAttributeFragment) {
        return hasJaxbNamingSimilarities(javaFieldFragment, xmlAttributeFragment);
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XMLAttributeFragment xmlAttributeFragment) {
        return hasJaxbNamingSimilarities(javaMethodFragment, xmlAttributeFragment);
    }
}
