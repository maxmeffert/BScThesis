package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragmentAST;

public class JaxbXmlCorrespondenceNamingSimilarityHeuristic extends BaseJaxbSimilarityHeuristic {

    private static final String[] JavaAccessorPrefixes = new String[] {"get", "set", "is"};
    private static final String PluralSuffix = "s";

    private String removeAnyPrefix(String string, String[] prefixes) {
        for(String prefix : prefixes) {
            if (string.length() > prefix.length() && string.startsWith(prefix)) {
                return string.substring(prefix.length(), string.length());
            }
        }
        return string;
    }

    private String removeAnySuffix(String string, String[] suffixes) {
        for(String suffix : suffixes) {
            if (string.length() > suffix.length() && string.endsWith(suffix)) {
                return string.substring(0, string.length()-suffix.length());
            }
        }
        return string;
    }

    private String removeAnyJavaAccessorPrefix(String string) {
        return removeAnyPrefix(string, JavaAccessorPrefixes);
    }

    private String removePluralSuffix(String string) {
        return removeAnySuffix(string, new String[] { PluralSuffix });
    }

    private boolean areEqual(String a, String b) {
        return a.equals(b);
    }

    private boolean areLowerCaseEqual(String a, String b) {
        return areEqual(a.toLowerCase(), b.toLowerCase());
    }

    private boolean areSimilar(String javaIdentifier, String xmlName) {
        return areEqual(javaIdentifier,xmlName)
                || areLowerCaseEqual(javaIdentifier,xmlName)
                || areLowerCaseEqual(removePluralSuffix(javaIdentifier), xmlName)
                || areLowerCaseEqual(removeAnyJavaAccessorPrefix(javaIdentifier), xmlName)
                || areLowerCaseEqual(removeAnyJavaAccessorPrefix(removePluralSuffix(javaIdentifier)), xmlName);
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
