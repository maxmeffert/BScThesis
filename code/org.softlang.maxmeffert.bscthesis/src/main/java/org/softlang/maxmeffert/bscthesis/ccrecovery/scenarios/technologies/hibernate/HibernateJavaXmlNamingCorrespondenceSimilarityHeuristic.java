package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.hibernate;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.analyzers.IFragmentAnalyzerHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLDocumentFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.XmlFragmentUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.XmlStringUtils;

import java.util.List;

public class HibernateJavaXmlNamingCorrespondenceSimilarityHeuristic implements IFragmentAnalyzerHeuristic {

    public void addSimilarities(IBinaryRelation<IFragment> similarities, JavaClassFragment javaClassFragment, List<XMLElementFragment> xmlElementFragments) {
        for (XMLElementFragment xmlElementFragment : xmlElementFragments) {
            addSimilarities(similarities, javaClassFragment, xmlElementFragment);
        }
    }

    public void addSimilarities(IBinaryRelation<IFragment> similarities, JavaClassFragment javaClassFragment, XMLElementFragment xmlElementFragment) {
        if (XmlFragmentUtils.isTag(xmlElementFragment, "class")
                && XmlFragmentUtils.hasAttribute(xmlElementFragment, "name", javaClassFragment.getFullName())) {
            similarities.add(javaClassFragment, xmlElementFragment);
        }
        addSimilarities(similarities, javaClassFragment, xmlElementFragment.getXmlElementFragments());
    }

    public void addSimilarities(IBinaryRelation<IFragment> similarities, JavaClassFragment javaClassFragment, XMLDocumentFragment xmlDocumentFragment) {
        addSimilarities(similarities, javaClassFragment, xmlDocumentFragment.getXmlElementFragment());
    }

    @Override
    public void analyze(IBinaryRelation<IFragment> similarity, IFragment fragment1, IFragment fragment2) {
            if (fragment1 instanceof JavaClassFragment && fragment2 instanceof XMLDocumentFragment) {
                addSimilarities(similarity, (JavaClassFragment) fragment1, (XMLDocumentFragment) fragment2);
            }
    }
}
