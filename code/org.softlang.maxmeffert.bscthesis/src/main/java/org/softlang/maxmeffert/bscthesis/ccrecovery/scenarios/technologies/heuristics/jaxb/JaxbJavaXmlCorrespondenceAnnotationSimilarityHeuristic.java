package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.NamedXmlFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlElementFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics.BaseJavaXmlSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.JaxbStringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.StringUtils;

public class JaxbJavaXmlCorrespondenceAnnotationSimilarityHeuristic extends BaseJavaXmlSimilarityHeuristic {

    private boolean hasJaxbAnnotationSimilarity(JavaAnnotationFragment javaAnnotationFragment, NamedXmlFragment namedXMLFragment) {
        String identifier = javaAnnotationFragment.getIdentifier();
        String name = namedXMLFragment.getName();
        if (JaxbStringUtils.equalsAnyJaxbAnnotationName(identifier)) {
            if (javaAnnotationFragment.hasNamedParameter("name")) {
                return name.equals(StringUtils.removeQuotes(javaAnnotationFragment.getNamedParamterValue("name")));
            }
        }
        return false;
    }

    private boolean hasJaxbAnnotationSimilarity(ModifiedJavaFragment modifiedJavaFragment, NamedXmlFragment namedXmlFragment) {
        for (JavaModifierFragment javaModifierFragment : modifiedJavaFragment.getJavaModifierFragments()) {
            if (javaModifierFragment.isAnnotation()) {
                if (hasJaxbAnnotationSimilarity(javaModifierFragment.getJavaAnnotationFragment(), namedXmlFragment)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected boolean areSimilar(JavaClassFragment javaClassFragment, XmlElementFragment xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaClassFragment, xmlElementFragment);
    }

    @Override
    protected boolean areSimilar(JavaFieldFragment javaFieldFragment, XmlElementFragment xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaFieldFragment, xmlElementFragment);
    }

    @Override
    protected boolean areSimilar(JavaFieldFragment javaFieldFragment, XmlAttributeFragment xmlAttributeFragment) {
        return hasJaxbAnnotationSimilarity(javaFieldFragment, xmlAttributeFragment);
    }

    @Override
    protected boolean areSimilar(JavaMethodFragment javaMethodFragment, XmlElementFragment xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaMethodFragment, xmlElementFragment);
    }

    @Override
    protected boolean areSimilar(JavaMethodFragment javaMethodFragment, XmlAttributeFragment xmlAttributeFragment) {
        return hasJaxbAnnotationSimilarity(javaMethodFragment, xmlAttributeFragment);
    }
}
