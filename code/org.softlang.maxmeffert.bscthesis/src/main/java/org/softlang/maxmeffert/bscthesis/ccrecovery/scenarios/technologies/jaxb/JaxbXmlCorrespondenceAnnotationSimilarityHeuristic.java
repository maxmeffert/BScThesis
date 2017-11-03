package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.NamedXMLFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.BaseJavaXmlSimilarityHeuristic;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.JaxbStringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.StringUtils;

public class JaxbXmlCorrespondenceAnnotationSimilarityHeuristic extends BaseJavaXmlSimilarityHeuristic {

    private boolean hasJaxbAnnotationSimilarity(JavaAnnotationFragment javaAnnotationFragment, NamedXMLFragment namedXMLFragment) {
        String identifier = javaAnnotationFragment.getIdentifier();
        String name = namedXMLFragment.getName();
        if (JaxbStringUtils.equalsAnyJaxbAnnotationName(identifier)) {
            if (javaAnnotationFragment.hasNamedParameter("name")) {
                return name.equals(StringUtils.removeQuotes(javaAnnotationFragment.getNamedParamterValue("name")));
            }
        }
        return false;
    }

    private boolean hasJaxbAnnotationSimilarity(ModifiedJavaFragment modifiedJavaFragmentAST, NamedXMLFragment namedXMLFragmentAST) {
        for (JavaModifierFragment javaModifierFragment : modifiedJavaFragmentAST.getJavaModifierFragments()) {
            if (javaModifierFragment.isAnnotation()) {
                if (hasJaxbAnnotationSimilarity(javaModifierFragment.getJavaAnnotationFragment(), namedXMLFragmentAST)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected boolean similar(JavaClassFragment javaClassFragment, XMLElementFragment xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaClassFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XMLElementFragment xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaFieldFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragment javaFieldFragment, XMLAttributeFragment xmlAttributeFragment) {
        return hasJaxbAnnotationSimilarity(javaFieldFragment, xmlAttributeFragment);
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XMLElementFragment xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaMethodFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaMethodFragment javaMethodFragment, XMLAttributeFragment xmlAttributeFragment) {
        return hasJaxbAnnotationSimilarity(javaMethodFragment, xmlAttributeFragment);
    }
}
