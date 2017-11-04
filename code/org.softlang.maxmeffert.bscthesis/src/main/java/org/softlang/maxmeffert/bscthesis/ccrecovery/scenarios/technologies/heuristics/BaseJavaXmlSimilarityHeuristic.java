package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.analyzers.IFragmentAnalyzerHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaFieldFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.JavaMethodFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlDocumentFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlElementFragment;

import java.util.List;

public abstract class BaseJavaXmlSimilarityHeuristic implements IFragmentAnalyzerHeuristic {

    protected abstract boolean areSimilar(JavaClassFragment javaClassFragment, XmlElementFragment xmlElementFragment);
    protected abstract boolean areSimilar(JavaFieldFragment javaFieldFragment, XmlElementFragment xmlElementFragment);
    protected abstract boolean areSimilar(JavaFieldFragment javaFieldFragment, XmlAttributeFragment xmlAttributeFragment);
    protected abstract boolean areSimilar(JavaMethodFragment javaMethodFragment, XmlElementFragment xmlElementFragment);
    protected abstract boolean areSimilar(JavaMethodFragment javaMethodFragment, XmlAttributeFragment xmlAttributeFragment);

    private void analyzeJavaFieldXMLElementSimilarities(IBinaryRelation<IFragment> similarity, JavaFieldFragment javaFieldFragment, XmlElementFragment xmlElementFragment) {
        if (areSimilar(javaFieldFragment, xmlElementFragment)) {
            similarity.add(javaFieldFragment, xmlElementFragment);
        }
        analyzeJavaFieldXMLElementSimilarities(similarity, javaFieldFragment, xmlElementFragment.getXmlElementFragments());
    }

    private void analyzeJavaFieldXMLElementSimilarities(IBinaryRelation<IFragment> similarity, JavaFieldFragment javaFieldFragment, List<XmlElementFragment> xmlElementFragments) {
        for (XmlElementFragment xmlElementFragment : xmlElementFragments) {
            analyzeJavaFieldXMLElementSimilarities(similarity, javaFieldFragment, xmlElementFragment);
        }
    }

    private void analyzeJavaMethodXMLElementSimilarities(IBinaryRelation<IFragment> similarity, JavaMethodFragment javaMethodFragment, XmlElementFragment xmlElementFragment) {
        if (areSimilar(javaMethodFragment, xmlElementFragment)) {
            similarity.add(javaMethodFragment, xmlElementFragment);
        }
        analyzeJavaMethodXMLElementSimilarities(similarity, javaMethodFragment, xmlElementFragment.getXmlElementFragments());
    }

    private void analyzeJavaMethodXMLElementSimilarities(IBinaryRelation<IFragment> similarity, JavaMethodFragment javaMethodFragment, List<XmlElementFragment> xmlElementFragments) {
        for (XmlElementFragment xmlElementFragment : xmlElementFragments) {
            analyzeJavaMethodXMLElementSimilarities(similarity, javaMethodFragment, xmlElementFragment);
        }
    }

    private void analyzeJavaFieldXMLAttributeSimilarities(IBinaryRelation<IFragment> similarity, JavaFieldFragment javaFieldFragment, XmlAttributeFragment xmlAttributeFragment) {
        if (areSimilar(javaFieldFragment, xmlAttributeFragment)) {
            similarity.add(javaFieldFragment, xmlAttributeFragment);
        }
    }

    private void analyzeJavaFieldXMLAttributeSimilarities(IBinaryRelation<IFragment> similarity, JavaFieldFragment javaFieldFragment, List<XmlAttributeFragment> xmlAttributeFragments) {
        for (XmlAttributeFragment xmlAttributeFragment : xmlAttributeFragments) {
            analyzeJavaFieldXMLAttributeSimilarities(similarity, javaFieldFragment, xmlAttributeFragment);
        }
    }

    private void analyzeJavaMethodXMLAttributeSimilarities(IBinaryRelation<IFragment> similarity, JavaMethodFragment javaMethodFragment, XmlAttributeFragment xmlAttributeFragment) {
        if (areSimilar(javaMethodFragment, xmlAttributeFragment)) {
            similarity.add(javaMethodFragment, xmlAttributeFragment);
        }
    }

    private void analyzeJavaMethodXMLAttributeSimilarities(IBinaryRelation<IFragment> similarity, JavaMethodFragment javaMethodFragment, List<XmlAttributeFragment> xmlAttributeFragments) {
        for (XmlAttributeFragment xmlAttributeFragment : xmlAttributeFragments) {
            analyzeJavaMethodXMLAttributeSimilarities(similarity, javaMethodFragment, xmlAttributeFragment);
        }
    }

    private void analyzeJavaClassXMLElementSimilarities(IBinaryRelation<IFragment> similarity, JavaClassFragment javaClassFragment, List<XmlElementFragment> xmlElementFragments) {
        for (XmlElementFragment xmlElementFragment : xmlElementFragments) {
            analyzeJavaClassXMLElementSimilarities(similarity, javaClassFragment, xmlElementFragment);
        }
    }

    private void analyzeJavaClassXMLElementSimilarities(IBinaryRelation<IFragment> similarity, JavaClassFragment javaClassFragment, XmlElementFragment xmlElementFragment) {
        if (areSimilar(javaClassFragment, xmlElementFragment)) {
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

    private void analyzeJavaClassXMLDocumentSimilarities(IBinaryRelation<IFragment> similarity, JavaClassFragment javaClassFragment, XmlDocumentFragment xmlDocumentFragment) {
        XmlElementFragment xmlElementFragment = xmlDocumentFragment.getXmlElementFragment();
        analyzeJavaClassXMLElementSimilarities(similarity, javaClassFragment, xmlElementFragment);
    }

    @Override
    public final void analyze(IBinaryRelation<IFragment> similarity, IFragment fragment1, IFragment fragment2) {
        if (fragment1 instanceof JavaClassFragment && fragment2 instanceof XmlDocumentFragment) {
            JavaClassFragment javaClassFragment = (JavaClassFragment) fragment1;
            XmlDocumentFragment xmlDocumentFragment = (XmlDocumentFragment) fragment2;
            analyzeJavaClassXMLDocumentSimilarities(similarity, javaClassFragment, xmlDocumentFragment);
        }
    }

}
