package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.StringUtils;

public class JaxbXmlCorrespondenceNamingSimilarityHeuristic extends BaseJaxbSimilarityHeuristic {

    private static final String[] JavaAccessorPrefixes = new String[] {"get", "set", "is"};

    private String removeAnyJavaAccessorPrefix(String string) {
        return StringUtils.removeAnyPrefix(string, JavaAccessorPrefixes);
    }

    private boolean areSimilar(String javaIdentifier, String xmlName) {
        return StringUtils.areEqual(javaIdentifier,xmlName)
                || StringUtils.areLowerCaseEqual(javaIdentifier,xmlName)
                || StringUtils.areLowerCaseEqual(StringUtils.removePluralSuffix(javaIdentifier), xmlName)
                || StringUtils.areLowerCaseEqual(removeAnyJavaAccessorPrefix(javaIdentifier), xmlName)
                || StringUtils.areLowerCaseEqual(removeAnyJavaAccessorPrefix(StringUtils.removePluralSuffix(javaIdentifier)), xmlName);
    }

    @Override
    protected boolean similar(JavaClassFragmentAST javaClassFragment, XMLElementFragmentAST xmlElementFragment) {
        String identifier = javaClassFragment.getIdentifier();
        String name = xmlElementFragment.getName();
        return areSimilar(identifier, name);
    }

    @Override
    protected boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLElementFragmentAST xmlElementFragment) {
        String identifier = javaFieldFragment.getIdentifier();
        String name = xmlElementFragment.getName();
        return areSimilar(identifier, name);
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLElementFragmentAST xmlElementFragment) {
        String identifier = javaMethodFragment.getIdentifier();
        String name = xmlElementFragment.getName();
        return areSimilar(identifier, name);
    }

    @Override
    protected boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        String identifier = javaFieldFragment.getIdentifier();
        String name = xmlAttributeFragment.getName();
        return areSimilar(identifier, name);
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        String identifier = javaMethodFragment.getIdentifier();
        String name = xmlAttributeFragment.getName();
        return areSimilar(identifier, name);
    }
}
