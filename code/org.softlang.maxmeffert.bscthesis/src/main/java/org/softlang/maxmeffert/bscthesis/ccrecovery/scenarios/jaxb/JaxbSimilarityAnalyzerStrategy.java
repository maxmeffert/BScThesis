package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarityAnalyzerStrategy;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.fragments.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.fragments.JavaFieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments.XMLAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments.XMLDocumentFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments.XMLElementFragment;

import java.util.List;

public class JaxbSimilarityAnalyzerStrategy implements ISimilarityAnalyzerStrategy{

    private boolean lowerCaseEquals(String a, String b) {
        return a.toLowerCase().equals(b.toLowerCase());
    }

    private boolean similar(JavaClassFragment java8ClassFragment, XMLElementFragment xmlElementFragment) {
        return lowerCaseEquals(java8ClassFragment.getIdentifier(), xmlElementFragment.getName());
    }

    private boolean similar(JavaFieldFragment java8FieldFragment, XMLElementFragment xmlElementFragment) {
        return lowerCaseEquals(java8FieldFragment.getIdentifier(), xmlElementFragment.getName());
    }

    private boolean similar(JavaFieldFragment java8FieldFragment, XMLAttributeFragment xmlAttributeFragment) {
        return lowerCaseEquals(java8FieldFragment.getIdentifier(), xmlAttributeFragment.getName());
    }

    private void analyzeJavaFieldsXMLElementSimilarities(ISimilarity similarity, JavaFieldFragment java8FieldFragment, List<XMLElementFragment> xmlElementFragments) {
        for (XMLElementFragment xmlElementFragment : xmlElementFragments) {
            if (similar(java8FieldFragment, xmlElementFragment)) {
                similarity.add(java8FieldFragment, xmlElementFragment);
            }
        }
    }

    private void analyzeJavaFieldXMLAttributeSimilarities(ISimilarity similarity, JavaFieldFragment java8FieldFragment, List<XMLAttributeFragment> xmlAttributeFragments) {
        for (XMLAttributeFragment xmlAttributeFragment : xmlAttributeFragments) {
            if (similar(java8FieldFragment, xmlAttributeFragment)) {
                similarity.add(java8FieldFragment, xmlAttributeFragment);
            }
        }
    }

    private void analyzeJavaClassXMLElementSimilarities(ISimilarity similarity, JavaClassFragment java8ClassFragment, List<XMLElementFragment> xmlElementFragments) {
        for (XMLElementFragment xmlElementFragment : xmlElementFragments) {
            analyzeJavaClassXMLElementSimilarities(similarity, java8ClassFragment, xmlElementFragment);
        }
    }

    private void analyzeJavaClassXMLElementSimilarities(ISimilarity similarity, JavaClassFragment java8ClassFragment, XMLElementFragment xmlElementFragment) {
        if (similar(java8ClassFragment, xmlElementFragment)) {
            similarity.add(java8ClassFragment, xmlElementFragment);
            for (JavaFieldFragment java8FieldFragment : java8ClassFragment.getJava8FieldFragments()) {
                analyzeJavaFieldXMLAttributeSimilarities(similarity, java8FieldFragment, xmlElementFragment.getXmlAttributeFragments());
                analyzeJavaFieldsXMLElementSimilarities(similarity, java8FieldFragment, xmlElementFragment.getXmlElementFragments());
            }
        }
        analyzeJavaClassXMLElementSimilarities(similarity, java8ClassFragment, xmlElementFragment.getXmlElementFragments());
    }

    private void analyzeJavaClassXMLDocumentSimilarities(ISimilarity similarity, JavaClassFragment java8ClassFragment, XMLDocumentFragment xmlDocumentFragment) {
        XMLElementFragment xmlElementFragment = xmlDocumentFragment.getXmlElementFragment();
        analyzeJavaClassXMLElementSimilarities(similarity, java8ClassFragment, xmlElementFragment);
    }

    @Override
    public void analyze(ISimilarity similarity, IFragment fragment1, IFragment fragment2) {
        if (fragment1 instanceof JavaClassFragment && fragment2 instanceof XMLDocumentFragment) {
            JavaClassFragment java8ClassFragment = (JavaClassFragment) fragment1;
            XMLDocumentFragment xmlDocumentFragment = (XMLDocumentFragment) fragment2;
            analyzeJavaClassXMLDocumentSimilarities(similarity, java8ClassFragment, xmlDocumentFragment);
        }
    }
}
