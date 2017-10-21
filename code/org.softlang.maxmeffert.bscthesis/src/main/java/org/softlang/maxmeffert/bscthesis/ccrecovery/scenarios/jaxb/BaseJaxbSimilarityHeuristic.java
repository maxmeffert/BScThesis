package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaFieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaMethodFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XMLAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XMLDocumentFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XMLElementFragment;

import java.util.List;

public abstract class BaseJaxbSimilarityHeuristic implements ISimilarityHeuristic{

    protected abstract boolean similar(JavaClassFragment javaClassFragment, XMLElementFragment xmlElementFragment);
    protected abstract boolean similar(JavaFieldFragment javaFieldFragment, XMLElementFragment xmlElementFragment);
    protected abstract boolean similar(JavaFieldFragment javaFieldFragment, XMLAttributeFragment xmlAttributeFragment);
    protected abstract boolean similar(JavaMethodFragment javaMethodFragment, XMLElementFragment xmlElementFragment);
    protected abstract boolean similar(JavaMethodFragment javaMethodFragment, XMLAttributeFragment xmlAttributeFragment);

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
    public final void analyze(ISimilarity similarity, IFragment fragment1, IFragment fragment2) {
        if (fragment1 instanceof JavaClassFragment && fragment2 instanceof XMLDocumentFragment) {
            JavaClassFragment javaClassFragment = (JavaClassFragment) fragment1;
            XMLDocumentFragment xmlDocumentFragment = (XMLDocumentFragment) fragment2;
            analyzeJavaClassXMLDocumentSimilarities(similarity, javaClassFragment, xmlDocumentFragment);
        }
    }

}
