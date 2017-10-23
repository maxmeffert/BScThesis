package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.NamedXMLFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.JaxbStringUtils;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.StringUtils;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

public class JaxbXmlCorrespondenceAnnotationSimilarityHeuristic extends BaseJaxbSimilarityHeuristic {

    private boolean hasJaxbAnnotationSimilarity(JavaAnnotationFragmentAST javaAnnotationFragment, NamedXMLFragmentAST namedXMLFragment) {
        String identifier = javaAnnotationFragment.getIdentifier();
        String name = namedXMLFragment.getName();
        if (JaxbStringUtils.equalsAnyJaxbAnnotationName(identifier)) {
            if (javaAnnotationFragment.hasNamedParameter("name")) {
                return name.equals(StringUtils.removeQuotes(javaAnnotationFragment.getNamedParamterValue("name")));
            }
        }
        return false;
    }

    private boolean hasJaxbAnnotationSimilarity(ModifiedJavaFragmentAST modifiedJavaFragmentAST, NamedXMLFragmentAST namedXMLFragmentAST) {
        for (JavaModifierFragmentAST javaModifierFragment : modifiedJavaFragmentAST.getJavaModifierFragments()) {
            if (javaModifierFragment.isAnnotation()) {
                if (hasJaxbAnnotationSimilarity(javaModifierFragment.getJavaAnnotationFragment(), namedXMLFragmentAST)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected boolean similar(JavaClassFragmentAST javaClassFragment, XMLElementFragmentAST xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaClassFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLElementFragmentAST xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaFieldFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        return hasJaxbAnnotationSimilarity(javaFieldFragment, xmlAttributeFragment);
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLElementFragmentAST xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaMethodFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        return hasJaxbAnnotationSimilarity(javaMethodFragment, xmlAttributeFragment);
    }
}
