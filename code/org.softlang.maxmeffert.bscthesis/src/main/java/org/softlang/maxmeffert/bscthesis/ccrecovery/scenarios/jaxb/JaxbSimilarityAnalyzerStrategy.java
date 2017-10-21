package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarityAnalyzerStrategy;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.fragments.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.fragments.JavaFieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.fragments.JavaMethodFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments.XMLAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments.XMLDocumentFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fragments.XMLElementFragment;

import java.util.List;

public class JaxbSimilarityAnalyzerStrategy implements ISimilarityAnalyzerStrategy{

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

    private boolean similar(JavaClassFragment javaClassFragment, XMLElementFragment xmlElementFragment) {
        return lowerCaseEquals(javaClassFragment.getIdentifier(), xmlElementFragment.getName());
    }

    private boolean similar(JavaFieldFragment javaFieldFragment, XMLElementFragment xmlElementFragment) {
        return lowerCaseEquals(javaFieldFragment.getIdentifier(), xmlElementFragment.getName());
    }

    private boolean similar(JavaMethodFragment javaMethodFragment, XMLElementFragment xmlElementFragment) {
        return lowerCaseEqualsWithoutPrefix(javaMethodFragment.getIdentifier(), xmlElementFragment.getName(), JavaAccessorPrefixes);
    }

    private boolean similar(JavaFieldFragment javaFieldFragment, XMLAttributeFragment xmlAttributeFragment) {
        return lowerCaseEquals(javaFieldFragment.getIdentifier(), xmlAttributeFragment.getName());
    }

    private boolean similar(JavaMethodFragment javaMethodFragment, XMLAttributeFragment xmlAttributeFragment) {
        return lowerCaseEqualsWithoutPrefix(javaMethodFragment.getIdentifier(), xmlAttributeFragment.getName(), JavaAccessorPrefixes);
    }

    private void analyzeJavaFieldXMLElementSimilarities(ISimilarity similarity, JavaFieldFragment javaFieldFragment, XMLElementFragment xmlElementFragment) {
        if (similar(javaFieldFragment, xmlElementFragment)) {
            similarity.add(javaFieldFragment, xmlElementFragment);
        }
    }

    private void analyzeJavaFieldXMLElementSimilarities(ISimilarity similarity, JavaFieldFragment javaFieldFragment, List<XMLElementFragment> xmlElementFragments) {
        for (XMLElementFragment xmlElementFragment : xmlElementFragments) {
            analyzeJavaFieldXMLElementSimilarities(similarity, javaFieldFragment, xmlElementFragment);
        }
    }

    private void analyzeJavaMethodXMLElementSimilarities(ISimilarity similarity, JavaMethodFragment javaMethodFragment, XMLElementFragment xmlElementFragment) {
        if (similar(javaMethodFragment, xmlElementFragment)) {
            similarity.add(javaMethodFragment, xmlElementFragment);
        }
    }

    private void analyzeJavaMethodXMLElementSimilarities(ISimilarity similarity, JavaMethodFragment javaMethodFragment, List<XMLElementFragment> xmlElementFragments) {
        for (XMLElementFragment xmlElementFragment : xmlElementFragments) {
            analyzeJavaMethodXMLElementSimilarities(similarity, javaMethodFragment, xmlElementFragment);
        }
    }

    private void analyzeJavaFieldXMLAttributeSimilarities(ISimilarity similarity, JavaFieldFragment javaFieldFragment, XMLAttributeFragment xmlAttributeFragment) {
        if (similar(javaFieldFragment, xmlAttributeFragment)) {
            similarity.add(javaFieldFragment, xmlAttributeFragment);
        }
    }

    private void analyzeJavaFieldXMLAttributeSimilarities(ISimilarity similarity, JavaFieldFragment javaFieldFragment, List<XMLAttributeFragment> xmlAttributeFragments) {
        for (XMLAttributeFragment xmlAttributeFragment : xmlAttributeFragments) {
            analyzeJavaFieldXMLAttributeSimilarities(similarity, javaFieldFragment, xmlAttributeFragment);
        }
    }

    private void analyzeJavaMethodXMLAttributeSimilarities(ISimilarity similarity, JavaMethodFragment javaMethodFragment, XMLAttributeFragment xmlAttributeFragment) {
        if (similar(javaMethodFragment, xmlAttributeFragment)) {
            similarity.add(javaMethodFragment, xmlAttributeFragment);
        }
    }

    private void analyzeJavaMethodXMLAttributeSimilarities(ISimilarity similarity, JavaMethodFragment javaMethodFragment, List<XMLAttributeFragment> xmlAttributeFragments) {
        for (XMLAttributeFragment xmlAttributeFragment : xmlAttributeFragments) {
            analyzeJavaMethodXMLAttributeSimilarities(similarity, javaMethodFragment, xmlAttributeFragment);
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
                analyzeJavaFieldXMLElementSimilarities(similarity, javaFieldFragment, xmlElementFragment.getXmlElementFragments());
            }
            for (JavaMethodFragment javaMethodFragment : javaClassFragment.getJavaMethodFragments()) {
                analyzeJavaMethodXMLAttributeSimilarities(similarity, javaMethodFragment, xmlElementFragment.getXmlAttributeFragments());
                analyzeJavaMethodXMLElementSimilarities(similarity, javaMethodFragment, xmlElementFragment.getXmlElementFragments());
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
