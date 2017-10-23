package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.*;
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

    @Override
    protected boolean similar(JavaClassFragmentAST javaClassFragment, XMLElementFragmentAST xmlElementFragment) {
        String identifier = javaClassFragment.getIdentifier();
        String name = xmlElementFragment.getName();
        return hasJaxbNamingSimilarities(identifier, name);
    }

    @Override
    protected boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLElementFragmentAST xmlElementFragment) {
        String identifier = javaFieldFragment.getIdentifier();
        String name = xmlElementFragment.getName();
        return hasJaxbNamingSimilarities(identifier, name);
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLElementFragmentAST xmlElementFragment) {
        String identifier = javaMethodFragment.getIdentifier();
        String name = xmlElementFragment.getName();
        return hasJaxbNamingSimilarities(identifier, name);
    }

    @Override
    protected boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        String identifier = javaFieldFragment.getIdentifier();
        String name = xmlAttributeFragment.getName();
        return hasJaxbNamingSimilarities(identifier, name);
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        String identifier = javaMethodFragment.getIdentifier();
        String name = xmlAttributeFragment.getName();
        return hasJaxbNamingSimilarities(identifier, name);
    }
}
