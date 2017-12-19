package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.analyzers.IFragmentAnalyzerHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlDocumentFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlElementFragment;

import java.util.List;

public abstract class BaseXmlXsdSimilarityHeuristic implements IFragmentAnalyzerHeuristic {

    protected abstract boolean areSimilar(XmlElementFragment xmlElementFragment, XmlElementFragment xsdElementFragment);
    protected abstract boolean areSimilar(XmlAttributeFragment xmlAttributeFragment, XmlElementFragment xsdElementFragment);

    private void addSimilarities(IBinaryRelation<IFragment> similarities, XmlAttributeFragment xmlAttributeFragment, XmlElementFragment xsdElementFragment) {
        if (areSimilar(xmlAttributeFragment, xsdElementFragment)) {
            similarities.add(xmlAttributeFragment, xsdElementFragment);
        }
    }

    private void addSimilarities(IBinaryRelation<IFragment> similarities, XmlAttributeFragment xmlAttributeFragment, List<XmlElementFragment> xsdElementFragments) {
        for (XmlElementFragment xsdElementFragment1 : xsdElementFragments) {
            addSimilarities(similarities, xmlAttributeFragment, xsdElementFragment1);
        }
    }

    private void addSimilarities(IBinaryRelation<IFragment> similarities, List<XmlElementFragment> xmlElementFragments, List<XmlElementFragment> xsdElementFragments) {
        for (XmlElementFragment xmlElementFragment : xmlElementFragments) {
            for (XmlElementFragment xsdElementFragment : xsdElementFragments) {
                addSimilarities(similarities, xmlElementFragment, xsdElementFragment);
            }
        }
    }

    private void addSimilarities(IBinaryRelation<IFragment> similarities, XmlElementFragment xmlElementFragment, XmlElementFragment xsdElementFragment) {
        if (areSimilar(xmlElementFragment, xsdElementFragment)) {
            similarities.add(xmlElementFragment, xsdElementFragment);
            for (XmlAttributeFragment xmlAttributeFragment : xmlElementFragment.getXmlAttributeFragments()) {
                addSimilarities(similarities, xmlAttributeFragment, xsdElementFragment.getXmlElementFragments());
            }
        }
        for(XmlElementFragment xsdElementFragment1 : xsdElementFragment.getXmlElementFragments()) {
            addSimilarities(similarities, xmlElementFragment, xsdElementFragment1);
        }
        for(XmlElementFragment xmlElementFragment1 : xmlElementFragment.getXmlElementFragments()) {
            addSimilarities(similarities, xmlElementFragment1, xsdElementFragment);
        }
        addSimilarities(similarities, xmlElementFragment.getXmlElementFragments(), xsdElementFragment.getXmlElementFragments());
    }

    private void addSimilarities(IBinaryRelation<IFragment> similarities, XmlDocumentFragment xmlDocumentFragment, XmlDocumentFragment xsdDocumentFragment) {
        addSimilarities(similarities, xmlDocumentFragment.getXmlElementFragment(), xsdDocumentFragment.getXmlElementFragment());
    }

    @Override
    public void analyze(IBinaryRelation<IFragment> similarities, IFragment fragment1, IFragment fragment2) {
        if (fragment1 instanceof XmlDocumentFragment && fragment2 instanceof XmlDocumentFragment) {
            addSimilarities(similarities, (XmlDocumentFragment) fragment1, (XmlDocumentFragment) fragment2);
        }
    }
}
