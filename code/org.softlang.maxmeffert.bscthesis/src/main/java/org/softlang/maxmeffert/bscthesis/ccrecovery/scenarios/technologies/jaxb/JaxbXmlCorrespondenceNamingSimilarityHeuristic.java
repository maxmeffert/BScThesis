package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XMLAttributeFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XMLElementFragmentAST;

public class JaxbXmlCorrespondenceNamingSimilarityHeuristic extends BaseJaxbSimilarityHeuristic {

    private static String[] JavaAccessorPrefixes = new String[] {"get", "set", "is"};

    private boolean lowerCaseEquals(String a, String b) {
        return a.toLowerCase().equals(b.toLowerCase());
    }

    private boolean lowerCaseEqualsWithoutPrefix(String a, String b, String[] prefixes) {
        for(String prefix : prefixes) {
            if (a.length() > prefix.length() && a.startsWith(prefix)) {
                return lowerCaseEquals(a.substring(prefix.length(), a.length()), b);
            }
        }
        return lowerCaseEquals(a,b);
    }

    @Override
    protected boolean similar(JavaClassFragmentAST javaClassFragment, XMLElementFragmentAST xmlElementFragment) {
        return lowerCaseEquals(javaClassFragment.getIdentifier(), xmlElementFragment.getName());
    }

    @Override
    protected boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLElementFragmentAST xmlElementFragment) {
        return lowerCaseEquals(javaFieldFragment.getIdentifier(), xmlElementFragment.getName());
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLElementFragmentAST xmlElementFragment) {
        return lowerCaseEqualsWithoutPrefix(javaMethodFragment.getIdentifier(), xmlElementFragment.getName(), JavaAccessorPrefixes);
    }

    @Override
    protected boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        return lowerCaseEquals(javaFieldFragment.getIdentifier(), xmlAttributeFragment.getName());
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        return lowerCaseEqualsWithoutPrefix(javaMethodFragment.getIdentifier(), xmlAttributeFragment.getName(), JavaAccessorPrefixes);
    }
}
