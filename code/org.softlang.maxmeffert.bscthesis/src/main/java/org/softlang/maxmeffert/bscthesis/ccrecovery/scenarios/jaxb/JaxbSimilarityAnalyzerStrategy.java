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

    private boolean similar(JavaClassFragment javaClassFragment, XMLElementFragment xmlElementFragment) {
        return lowerCaseEquals(javaClassFragment.getIdentifier(), xmlElementFragment.getName());
    }

    private boolean similar(JavaFieldFragment javaFieldFragment, XMLElementFragment xmlElementFragment) {
        return lowerCaseEquals(javaFieldFragment.getIdentifier(), xmlElementFragment.getName());
    }

    private boolean similar(JavaFieldFragment javaFieldFragment, XMLAttributeFragment xmlAttributeFragment) {
        return lowerCaseEquals(javaFieldFragment.getIdentifier(), xmlAttributeFragment.getName());
    }

    private void analyzeJavaFieldsXMLElementSimilarities(ISimilarity similarity, JavaFieldFragment javaFieldFragment, List<XMLElementFragment> xmlElementFragments) {
        for (XMLElementFragment xmlElementFragment : xmlElementFragments) {
            if (similar(javaFieldFragment, xmlElementFragment)) {
                similarity.add(javaFieldFragment, xmlElementFragment);
            }
        }
    }

    private void analyzeJavaFieldXMLAttributeSimilarities(ISimilarity similarity, JavaFieldFragment javaFieldFragment, List<XMLAttributeFragment> xmlAttributeFragments) {
        for (XMLAttributeFragment xmlAttributeFragment : xmlAttributeFragments) {
            if (similar(javaFieldFragment, xmlAttributeFragment)) {
                similarity.add(javaFieldFragment, xmlAttributeFragment);
            }
        }
    }

    private void analyzeJavaClassXMLElementSimilarities(ISimilarity similarity, JavaClassFragment javaClassFragment, List<XMLElementFragment> xmlElementFragments) {
        for (XMLElementFragment xmlElementFragment : xmlElementFragments) {
            analyzeJavaClassXMLElementSimilarities(similarity, javaClassFragment, xmlElementFragment);
        }
    }

    private void analyzeJavaClassXMLElementSimilarities(ISimilarity similarity, JavaClassFragment javaClassFragment, XMLElementFragment xmlElementFragment) {
        if (similar(javaClassFragment, xmlElementFragment)) {
            similarity.add(javaClassFragment, xmlElementFragment);
            for (JavaFieldFragment javaFieldFragment : javaClassFragment.getJavaFieldFragments()) {
                analyzeJavaFieldXMLAttributeSimilarities(similarity, javaFieldFragment, xmlElementFragment.getXmlAttributeFragments());
                analyzeJavaFieldsXMLElementSimilarities(similarity, javaFieldFragment, xmlElementFragment.getXmlElementFragments());
            }
        }
        analyzeJavaClassXMLElementSimilarities(similarity, javaClassFragment, xmlElementFragment.getXmlElementFragments());
    }

    private void analyzeJavaClassXMLDocumentSimilarities(ISimilarity similarity, JavaClassFragment javaClassFragment, XMLDocumentFragment xmlDocumentFragment) {
        XMLElementFragment xmlElementFragment = xmlDocumentFragment.getXmlElementFragment();
        analyzeJavaClassXMLElementSimilarities(similarity, javaClassFragment, xmlElementFragment);
    }

    @Override
    public void analyze(ISimilarity similarity, IFragment fragment1, IFragment fragment2) {
        if (fragment1 instanceof JavaClassFragment && fragment2 instanceof XMLDocumentFragment) {
            JavaClassFragment javaClassFragment = (JavaClassFragment) fragment1;
            XMLDocumentFragment xmlDocumentFragment = (XMLDocumentFragment) fragment2;
            analyzeJavaClassXMLDocumentSimilarities(similarity, javaClassFragment, xmlDocumentFragment);
        }
    }
}
