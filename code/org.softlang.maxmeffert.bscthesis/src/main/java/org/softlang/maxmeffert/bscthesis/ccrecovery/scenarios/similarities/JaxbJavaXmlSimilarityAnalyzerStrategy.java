package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarityAnalyzerStrategy;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fragments.Java8ClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fragments.Java8FieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments.XMLAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments.XMLDocumentFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments.XMLElementFragment;

import java.util.List;

public class JaxbJavaXmlSimilarityAnalyzerStrategy implements ISimilarityAnalyzerStrategy{

    private boolean lowerCaseEquals(String a, String b) {
        return a.toLowerCase().equals(b.toLowerCase());
    }

    private boolean similar(Java8ClassFragment java8ClassFragment, XMLElementFragment xmlElementFragment) {
        return lowerCaseEquals(java8ClassFragment.getIdentifier(), xmlElementFragment.getName());
    }

    private boolean similar(Java8FieldFragment java8FieldFragment, XMLElementFragment xmlElementFragment) {
        return lowerCaseEquals(java8FieldFragment.getIdentifier(), xmlElementFragment.getName());
    }

    private boolean similar(Java8FieldFragment java8FieldFragment, XMLAttributeFragment xmlAttributeFragment) {
        return lowerCaseEquals(java8FieldFragment.getIdentifier(), xmlAttributeFragment.getName());
    }

    private void analyzeJavaFieldsAndXMLElements(ISimilarity similarity, Java8FieldFragment java8FieldFragment, List<XMLElementFragment> xmlElementFragments) {
        for (XMLElementFragment xmlElementFragment : xmlElementFragments) {
            if (similar(java8FieldFragment, xmlElementFragment)) {
                similarity.add(java8FieldFragment, xmlElementFragment);
            }
        }
    }

    private void analyzeJavaFieldAndXMLAttributes(ISimilarity similarity, Java8FieldFragment java8FieldFragment, List<XMLAttributeFragment> xmlAttributeFragments) {
        for (XMLAttributeFragment xmlAttributeFragment : xmlAttributeFragments) {
            if (similar(java8FieldFragment, xmlAttributeFragment)) {
                similarity.add(java8FieldFragment, xmlAttributeFragment);
            }
        }
    }

    private void analyze(ISimilarity similarity, Java8ClassFragment java8ClassFragment, XMLElementFragment xmlElementFragment) {
        if (similar(java8ClassFragment, xmlElementFragment)) {

            similarity.add(java8ClassFragment, xmlElementFragment);

            for (Java8FieldFragment java8FieldFragment : java8ClassFragment.getJava8FieldFragments()) {
                analyzeJavaFieldAndXMLAttributes(similarity, java8FieldFragment, xmlElementFragment.getXmlAttributeFragments());
                analyzeJavaFieldsAndXMLElements(similarity, java8FieldFragment, xmlElementFragment.getXmlElementFragments());
            }

        }
    }

    private void analyze(ISimilarity similarity, Java8ClassFragment java8ClassFragment, XMLDocumentFragment xmlDocumentFragment) {
        XMLElementFragment xmlElementFragment = xmlDocumentFragment.getXmlElementFragment();
        analyze(similarity, java8ClassFragment, xmlElementFragment);
    }

    @Override
    public void analyze(ISimilarity similarity, IFragment fragment1, IFragment fragment2) {
        if (fragment1 instanceof Java8ClassFragment && fragment2 instanceof XMLDocumentFragment) {
            Java8ClassFragment java8ClassFragment = (Java8ClassFragment) fragment1;
            XMLDocumentFragment xmlDocumentFragment = (XMLDocumentFragment) fragment2;
            analyze(similarity, java8ClassFragment, xmlDocumentFragment);
        }
    }
}
