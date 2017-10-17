package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences.ISimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fast.Java8FieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fast.Java8Fragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fast.XMLElementFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fast.XMLFragment;

public class JaxbJavaXmlSimilarity implements ISimilarity {

    private boolean areSimilar(Java8Fragment java8Fragment, XMLFragment xmlFragment) {
        if (java8Fragment instanceof Java8FieldFragment && xmlFragment instanceof XMLElementFragment) {
            return java8Fragment.getIdentifier().toLowerCase().equals(((XMLElementFragment) xmlFragment).getName().toLowerCase());
        }
        return false;
    }

    @Override
    public boolean accept(IFragment fragment1, IFragment fragment2) {

        if (fragment1 instanceof Java8Fragment && fragment2 instanceof XMLFragment) {
            return areSimilar((Java8Fragment)fragment1, (XMLFragment)fragment2);
        }
        return false;
    }
}
