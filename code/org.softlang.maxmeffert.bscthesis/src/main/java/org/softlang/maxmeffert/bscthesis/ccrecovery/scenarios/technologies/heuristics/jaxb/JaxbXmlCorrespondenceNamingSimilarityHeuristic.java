package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.NamedXmlFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlElementFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.BaseJavaXmlSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.JavaStringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.StringUtils;

public class JaxbXmlCorrespondenceNamingSimilarityHeuristic extends BaseJavaXmlSimilarityHeuristic {

    private boolean hasJaxbNamingSimilarities(String javaIdentifier, String xmlName) {
        return StringUtils.areEqual(javaIdentifier,xmlName)
                || StringUtils.areLowerCaseEqual(javaIdentifier,xmlName)
                || StringUtils.areLowerCaseEqual(StringUtils.removePluralSuffix(javaIdentifier), xmlName)
                || StringUtils.areLowerCaseEqual(JavaStringUtils.removeAnyJavaAccessorPrefix(javaIdentifier), xmlName)
                || StringUtils.areLowerCaseEqual(JavaStringUtils.removeAnyJavaAccessorPrefix(StringUtils.removePluralSuffix(javaIdentifier)), xmlName);
    }

    private boolean hasJaxbNamingSimilarities(IdentifiedJavaFragment identifiedJavaFragmentAST, NamedXmlFragment namedXMLFragmentAST) {
        return hasJaxbNamingSimilarities(identifiedJavaFragmentAST.getIdentifier(), namedXMLFragmentAST.getName());
    }

    @Override
    protected boolean similar(JavaClassFragment javaClassFragment, XmlElementFragment xmlElementFragment) {
        return hasJaxbNamingSimilarities(javaClassFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XmlElementFragment xmlElementFragment) {
        return hasJaxbNamingSimilarities(javaFieldFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XmlElementFragment xmlElementFragment) {
        return hasJaxbNamingSimilarities(javaMethodFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XmlAttributeFragment xmlAttributeFragment) {
        return hasJaxbNamingSimilarities(javaFieldFragment, xmlAttributeFragment);
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XmlAttributeFragment xmlAttributeFragment) {
        return hasJaxbNamingSimilarities(javaMethodFragment, xmlAttributeFragment);
    }
}
