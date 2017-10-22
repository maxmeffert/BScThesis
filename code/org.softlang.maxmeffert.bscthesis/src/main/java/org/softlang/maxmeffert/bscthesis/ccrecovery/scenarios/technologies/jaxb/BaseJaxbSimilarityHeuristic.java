package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentASTAnalyzerHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaClassFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaFieldFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaMethodFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLDocumentFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragmentAST;

import java.util.List;

public abstract class BaseJaxbSimilarityHeuristic implements IFragmentASTAnalyzerHeuristic {

    protected abstract boolean similar(JavaClassFragmentAST javaClassFragment, XMLElementFragmentAST xmlElementFragment);
    protected abstract boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLElementFragmentAST xmlElementFragment);
    protected abstract boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLAttributeFragmentAST xmlAttributeFragment);
    protected abstract boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLElementFragmentAST xmlElementFragment);
    protected abstract boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLAttributeFragmentAST xmlAttributeFragment);

    private void analyzeJavaFieldXMLElementSimilarities(IBinaryRelation<IFragmentAST> similarity, JavaFieldFragmentAST javaFieldFragment, XMLElementFragmentAST xmlElementFragment) {
        if (similar(javaFieldFragment, xmlElementFragment)) {
            similarity.add(javaFieldFragment, xmlElementFragment);
        }
    }

    private void analyzeJavaFieldXMLElementSimilarities(IBinaryRelation<IFragmentAST> similarity, JavaFieldFragmentAST javaFieldFragment, List<XMLElementFragmentAST> xmlElementFragments) {
        for (XMLElementFragmentAST xmlElementFragment : xmlElementFragments) {
            analyzeJavaFieldXMLElementSimilarities(similarity, javaFieldFragment, xmlElementFragment);
        }
    }

    private void analyzeJavaMethodXMLElementSimilarities(IBinaryRelation<IFragmentAST> similarity, JavaMethodFragmentAST javaMethodFragment, XMLElementFragmentAST xmlElementFragment) {
        if (similar(javaMethodFragment, xmlElementFragment)) {
            similarity.add(javaMethodFragment, xmlElementFragment);
        }
    }

    private void analyzeJavaMethodXMLElementSimilarities(IBinaryRelation<IFragmentAST> similarity, JavaMethodFragmentAST javaMethodFragment, List<XMLElementFragmentAST> xmlElementFragments) {
        for (XMLElementFragmentAST xmlElementFragment : xmlElementFragments) {
            analyzeJavaMethodXMLElementSimilarities(similarity, javaMethodFragment, xmlElementFragment);
        }
    }

    private void analyzeJavaFieldXMLAttributeSimilarities(IBinaryRelation<IFragmentAST> similarity, JavaFieldFragmentAST javaFieldFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        if (similar(javaFieldFragment, xmlAttributeFragment)) {
            similarity.add(javaFieldFragment, xmlAttributeFragment);
        }
    }

    private void analyzeJavaFieldXMLAttributeSimilarities(IBinaryRelation<IFragmentAST> similarity, JavaFieldFragmentAST javaFieldFragment, List<XMLAttributeFragmentAST> xmlAttributeFragments) {
        for (XMLAttributeFragmentAST xmlAttributeFragment : xmlAttributeFragments) {
            analyzeJavaFieldXMLAttributeSimilarities(similarity, javaFieldFragment, xmlAttributeFragment);
        }
    }

    private void analyzeJavaMethodXMLAttributeSimilarities(IBinaryRelation<IFragmentAST> similarity, JavaMethodFragmentAST javaMethodFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        if (similar(javaMethodFragment, xmlAttributeFragment)) {
            similarity.add(javaMethodFragment, xmlAttributeFragment);
        }
    }

    private void analyzeJavaMethodXMLAttributeSimilarities(IBinaryRelation<IFragmentAST> similarity, JavaMethodFragmentAST javaMethodFragment, List<XMLAttributeFragmentAST> xmlAttributeFragments) {
        for (XMLAttributeFragmentAST xmlAttributeFragment : xmlAttributeFragments) {
            analyzeJavaMethodXMLAttributeSimilarities(similarity, javaMethodFragment, xmlAttributeFragment);
        }
    }

    private void analyzeJavaClassXMLElementSimilarities(IBinaryRelation<IFragmentAST> similarity, JavaClassFragmentAST javaClassFragment, List<XMLElementFragmentAST> xmlElementFragments) {
        for (XMLElementFragmentAST xmlElementFragment : xmlElementFragments) {
            analyzeJavaClassXMLElementSimilarities(similarity, javaClassFragment, xmlElementFragment);
        }
    }

    private void analyzeJavaClassXMLElementSimilarities(IBinaryRelation<IFragmentAST> similarity, JavaClassFragmentAST javaClassFragment, XMLElementFragmentAST xmlElementFragment) {
        if (similar(javaClassFragment, xmlElementFragment)) {
            similarity.add(javaClassFragment, xmlElementFragment);
            for (JavaFieldFragmentAST javaFieldFragment : javaClassFragment.getJavaFieldFragments()) {
                analyzeJavaFieldXMLAttributeSimilarities(similarity, javaFieldFragment, xmlElementFragment.getXmlAttributeFragments());
                analyzeJavaFieldXMLElementSimilarities(similarity, javaFieldFragment, xmlElementFragment.getXmlElementFragments());
            }
            for (JavaMethodFragmentAST javaMethodFragment : javaClassFragment.getJavaMethodFragments()) {
                analyzeJavaMethodXMLAttributeSimilarities(similarity, javaMethodFragment, xmlElementFragment.getXmlAttributeFragments());
                analyzeJavaMethodXMLElementSimilarities(similarity, javaMethodFragment, xmlElementFragment.getXmlElementFragments());
            }
        }
        analyzeJavaClassXMLElementSimilarities(similarity, javaClassFragment, xmlElementFragment.getXmlElementFragments());
    }

    private void analyzeJavaClassXMLDocumentSimilarities(IBinaryRelation<IFragmentAST> similarity, JavaClassFragmentAST javaClassFragment, XMLDocumentFragmentAST xmlDocumentFragment) {
        XMLElementFragmentAST xmlElementFragment = xmlDocumentFragment.getXmlElementFragment();
        analyzeJavaClassXMLElementSimilarities(similarity, javaClassFragment, xmlElementFragment);
    }

    @Override
    public final void analyze(IBinaryRelation<IFragmentAST> similarity, IFragmentAST fragment1, IFragmentAST fragment2) {
        if (fragment1 instanceof JavaClassFragmentAST && fragment2 instanceof XMLDocumentFragmentAST) {
            JavaClassFragmentAST javaClassFragment = (JavaClassFragmentAST) fragment1;
            XMLDocumentFragmentAST xmlDocumentFragment = (XMLDocumentFragmentAST) fragment2;
            analyzeJavaClassXMLDocumentSimilarities(similarity, javaClassFragment, xmlDocumentFragment);
        }
    }

}
