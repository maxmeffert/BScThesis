package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fragments.Java8ClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fragments.Java8FieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fragments.Java8Fragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments.XMLAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments.XMLElementFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments.XMLFragment;

public class JaxbJavaXmlSimilarity  {

    private boolean lowerCaseEquals(String a, String b) {
        return a.toLowerCase().equals(b.toLowerCase());
    }

    private boolean checkJavaClassXMLElementSimilarity(Java8ClassFragment java8ClassFragment, XMLElementFragment xmlElementFragment) {
        return lowerCaseEquals(java8ClassFragment.getIdentifier(), xmlElementFragment.getName());
    }

    private boolean checkJavaFieldXMLElementSimiliarity(Java8FieldFragment java8FieldFragment, XMLElementFragment xmlElementFragment) {
        return lowerCaseEquals(java8FieldFragment.getIdentifier(), xmlElementFragment.getName());
    }

    private boolean checkJavaFieldXMLAttributeSimilarity(Java8FieldFragment java8FieldFragment, XMLAttributeFragment xmlAttributeFragment) {
        return false;
    }

    private boolean areSimilar(Java8Fragment java8Fragment, XMLFragment xmlFragment) {
        if (java8Fragment instanceof Java8ClassFragment && xmlFragment instanceof XMLElementFragment) {
            Java8ClassFragment java8ClassFragment = (Java8ClassFragment) java8Fragment;
            XMLElementFragment xmlElementFragment = (XMLElementFragment) xmlFragment;
            return checkJavaClassXMLElementSimilarity(java8ClassFragment, xmlElementFragment);
        }
        else if (java8Fragment instanceof Java8FieldFragment && xmlFragment instanceof XMLElementFragment) {
            Java8FieldFragment java8FieldFragment = (Java8FieldFragment) java8Fragment;
            XMLElementFragment xmlElementFragment = (XMLElementFragment) xmlFragment;
            return checkJavaFieldXMLElementSimiliarity(java8FieldFragment, xmlElementFragment);
        }
        else if (java8Fragment instanceof Java8FieldFragment && xmlFragment instanceof XMLAttributeFragment) {
            Java8FieldFragment java8FieldFragment = (Java8FieldFragment) java8Fragment;
            XMLAttributeFragment xmlAttributeFragment = (XMLAttributeFragment) xmlFragment;
            return checkJavaFieldXMLAttributeSimilarity(java8FieldFragment, xmlAttributeFragment);
        }
        return false;
    }

    public boolean contains(IFragment fragment1, IFragment fragment2) {
        if (fragment1 instanceof Java8Fragment && fragment2 instanceof XMLFragment) {
            return areSimilar((Java8Fragment)fragment1, (XMLFragment)fragment2);
        }
        return false;
    }
}
