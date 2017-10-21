package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.fragments.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments.XMLAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments.XMLElementFragment;

public class JaxbCorrespondenceNamingSimilarityHeuristic extends BaseJaxbSimilarityHeuristic {

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
    protected boolean similar(JavaClassFragment javaClassFragment, XMLElementFragment xmlElementFragment) {
        return lowerCaseEquals(javaClassFragment.getIdentifier(), xmlElementFragment.getName());
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XMLElementFragment xmlElementFragment) {
        return lowerCaseEquals(javaFieldFragment.getIdentifier(), xmlElementFragment.getName());
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XMLElementFragment xmlElementFragment) {
        return lowerCaseEqualsWithoutPrefix(javaMethodFragment.getIdentifier(), xmlElementFragment.getName(), JavaAccessorPrefixes);
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XMLAttributeFragment xmlAttributeFragment) {
        return lowerCaseEquals(javaFieldFragment.getIdentifier(), xmlAttributeFragment.getName());
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XMLAttributeFragment xmlAttributeFragment) {
        return lowerCaseEqualsWithoutPrefix(javaMethodFragment.getIdentifier(), xmlAttributeFragment.getName(), JavaAccessorPrefixes);
    }
}
