package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.analyzers.IFragmentAnalyzerHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaFieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaMethodFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLDocumentFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragment;

import java.util.List;

public abstract class BaseJavaXmlSimilarityHeuristic implements IFragmentAnalyzerHeuristic {

    protected abstract boolean similar(JavaClassFragment javaClassFragment, XMLElementFragment xmlElementFragment);
    protected abstract boolean similar(JavaFieldFragment javaFieldFragment, XMLElementFragment xmlElementFragment);
    protected abstract boolean similar(JavaFieldFragment javaFieldFragment, XMLAttributeFragment xmlAttributeFragment);
    protected abstract boolean similar(JavaMethodFragment javaMethodFragment, XMLElementFragment xmlElementFragment);
    protected abstract boolean similar(JavaMethodFragment javaMethodFragment, XMLAttributeFragment xmlAttributeFragment);

    private void analyzeJavaFieldXMLElementSimilarities(IBinaryRelation<IFragment> similarity, JavaFieldFragment javaFieldFragment, XMLElementFragment xmlElementFragment) {
        if (similar(javaFieldFragment, xmlElementFragment)) {
            similarity.add(javaFieldFragment, xmlElementFragment);
        }
        analyzeJavaFieldXMLElementSimilarities(similarity, javaFieldFragment, xmlElementFragment.getXmlElementFragments());
    }

    private void analyzeJavaFieldXMLElementSimilarities(IBinaryRelation<IFragment> similarity, JavaFieldFragment javaFieldFragment, List<XMLElementFragment> xmlElementFragments) {
        for (XMLElementFragment xmlElementFragment : xmlElementFragments) {
            analyzeJavaFieldXMLElementSimilarities(similarity, javaFieldFragment, xmlElementFragment);
        }
    }

    private void analyzeJavaMethodXMLElementSimilarities(IBinaryRelation<IFragment> similarity, JavaMethodFragment javaMethodFragment, XMLElementFragment xmlElementFragment) {
        if (similar(javaMethodFragment, xmlElementFragment)) {
            similarity.add(javaMethodFragment, xmlElementFragment);
        }
        analyzeJavaMethodXMLElementSimilarities(similarity, javaMethodFragment, xmlElementFragment.getXmlElementFragments());
    }

    private void analyzeJavaMethodXMLElementSimilarities(IBinaryRelation<IFragment> similarity, JavaMethodFragment javaMethodFragment, List<XMLElementFragment> xmlElementFragments) {
        for (XMLElementFragment xmlElementFragment : xmlElementFragments) {
            analyzeJavaMethodXMLElementSimilarities(similarity, javaMethodFragment, xmlElementFragment);
        }
    }

    private void analyzeJavaFieldXMLAttributeSimilarities(IBinaryRelation<IFragment> similarity, JavaFieldFragment javaFieldFragment, XMLAttributeFragment xmlAttributeFragment) {
        if (similar(javaFieldFragment, xmlAttributeFragment)) {
            similarity.add(javaFieldFragment, xmlAttributeFragment);
        }
    }

    private void analyzeJavaFieldXMLAttributeSimilarities(IBinaryRelation<IFragment> similarity, JavaFieldFragment javaFieldFragment, List<XMLAttributeFragment> xmlAttributeFragments) {
        for (XMLAttributeFragment xmlAttributeFragment : xmlAttributeFragments) {
            analyzeJavaFieldXMLAttributeSimilarities(similarity, javaFieldFragment, xmlAttributeFragment);
        }
    }

    private void analyzeJavaMethodXMLAttributeSimilarities(IBinaryRelation<IFragment> similarity, JavaMethodFragment javaMethodFragment, XMLAttributeFragment xmlAttributeFragment) {
        if (similar(javaMethodFragment, xmlAttributeFragment)) {
            similarity.add(javaMethodFragment, xmlAttributeFragment);
        }
    }

    private void analyzeJavaMethodXMLAttributeSimilarities(IBinaryRelation<IFragment> similarity, JavaMethodFragment javaMethodFragment, List<XMLAttributeFragment> xmlAttributeFragments) {
        for (XMLAttributeFragment xmlAttributeFragment : xmlAttributeFragments) {
            analyzeJavaMethodXMLAttributeSimilarities(similarity, javaMethodFragment, xmlAttributeFragment);
        }
    }

    private void analyzeJavaClassXMLElementSimilarities(IBinaryRelation<IFragment> similarity, JavaClassFragment javaClassFragment, List<XMLElementFragment> xmlElementFragments) {
        for (XMLElementFragment xmlElementFragment : xmlElementFragments) {
            analyzeJavaClassXMLElementSimilarities(similarity, javaClassFragment, xmlElementFragment);
        }
    }

    private void analyzeJavaClassXMLElementSimilarities(IBinaryRelation<IFragment> similarity, JavaClassFragment javaClassFragment, XMLElementFragment xmlElementFragment) {
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

    private void analyzeJavaClassXMLDocumentSimilarities(IBinaryRelation<IFragment> similarity, JavaClassFragment javaClassFragment, XMLDocumentFragment xmlDocumentFragment) {
        XMLElementFragment xmlElementFragment = xmlDocumentFragment.getXmlElementFragment();
        analyzeJavaClassXMLElementSimilarities(similarity, javaClassFragment, xmlElementFragment);
    }

    @Override
    public final void analyze(IBinaryRelation<IFragment> similarity, IFragment fragment1, IFragment fragment2) {
        if (fragment1 instanceof JavaClassFragment && fragment2 instanceof XMLDocumentFragment) {
            JavaClassFragment javaClassFragment = (JavaClassFragment) fragment1;
            XMLDocumentFragment xmlDocumentFragment = (XMLDocumentFragment) fragment2;
            analyzeJavaClassXMLDocumentSimilarities(similarity, javaClassFragment, xmlDocumentFragment);
        }
    }

}
