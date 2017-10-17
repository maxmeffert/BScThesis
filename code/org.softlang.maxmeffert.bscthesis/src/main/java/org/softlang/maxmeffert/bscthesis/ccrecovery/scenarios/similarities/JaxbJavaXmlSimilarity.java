package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ISimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fast.Java8Fragment;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JaxbJavaXmlSimilarity implements ISimilarity {

    private boolean accept(Java8Fragment java8Fragment, Java8Fragment java8Fragment2) {
        return false;
    }

    @Override
    public boolean accept(IFragment fragment1, IFragment fragment2) {
        if (fragment1 instanceof Java8Fragment && fragment2 instanceof Java8Fragment) {
            return accept(fragment1, fragment2);
        }
        return false;
    }
}
