package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ISimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JaxbJavaXmlSimilarity implements ISimilarity {

    private Matcher newMatcher(String regex, String contents) {
        return Pattern.compile(regex).matcher(contents);
    }

    private Set<String> matchAll(String regex, String contents) {
        Set<String> matches = new TreeSet<>();
        Matcher matcher = newMatcher(regex, contents);
        while(matcher.find()) {
            matches.add(matcher.group(1));
        }
        return matches;
    }

    @Override
    public boolean accept(IFragment javaFragment, IFragment xmlFragment) {
        Set<String> xmlMatches = matchAll("^<(\\w+)", xmlFragment.getText());
        System.out.println(xmlMatches);
        if (!xmlMatches.isEmpty()) {
//            System.out.println(javaFragment + "         |          " + xmlFragment);
        }
        return false;
    }
}
