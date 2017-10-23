package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.NamedXMLFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragmentAST;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

public class JaxbXmlCorrespondenceAnnotationSimilarityHeuristic extends BaseJaxbSimilarityHeuristic {

    private static final String XmlRootElementAnnotationName = XmlRootElement.class.getSimpleName();
    private static final String XmlElementAnnotationName = XmlElement.class.getSimpleName();
    private static final String XmlElementWrapperAnnotatinName = XmlElementWrapper.class.getSimpleName();
    private static final String XmlAttributeAnnotationName = XmlAttribute.class.getSimpleName();

    private static final String[] JaxbAnnotationNames = new String[] {
        XmlRootElementAnnotationName,
        XmlElementAnnotationName,
        XmlElementWrapperAnnotatinName,
        XmlAttributeAnnotationName
    };

    private String unquote(String string) {
        if (string.startsWith("\"") && string.endsWith("\"")
                || string.startsWith("'") && string.endsWith("'")) {
            return string.substring(1, string.length()-1);
        }
        return string;
    }

    private boolean equalsAny(String a, String[] bs) {
        for(String b : bs) {
            if (a.equals(b)) {
                return true;
            }
        }
        return false;
    }

    private boolean equalsAnyJaxbAnnotationName(String string) {
        return equalsAny(string, JaxbAnnotationNames);
    }

    private boolean similar(JavaAnnotationFragmentAST javaAnnotationFragment, NamedXMLFragmentAST namedXMLFragment) {
        String identifier = javaAnnotationFragment.getIdentifier();
        String name = namedXMLFragment.getName();
//        System.out.println(identifier);
//        System.out.println(name);
        if (equalsAnyJaxbAnnotationName(identifier)) {
            Map<String,String> namedParameters = javaAnnotationFragment.getNamedParameters();
            if (namedParameters.containsKey("name")) {
                return name.equals(unquote(namedParameters.get("name")));
            }
        }
        return false;
    }

    private boolean hasJaxbAnnotationSimilarity(ModifiedJavaFragmentAST modifiedJavaFragmentAST, NamedXMLFragmentAST namedXMLFragmentAST) {
        for (JavaModifierFragmentAST javaModifierFragment : modifiedJavaFragmentAST.getJavaModifierFragments()) {
            if (javaModifierFragment.isAnnotation()) {
                if (similar(javaModifierFragment.getJavaAnnotationFragment(), namedXMLFragmentAST)) {
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
