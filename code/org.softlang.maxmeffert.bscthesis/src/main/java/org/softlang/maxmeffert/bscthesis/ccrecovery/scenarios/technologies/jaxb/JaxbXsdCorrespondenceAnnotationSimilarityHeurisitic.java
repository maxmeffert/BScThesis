package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragmentAST;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

public class JaxbXsdCorrespondenceAnnotationSimilarityHeurisitic extends BaseJaxbSimilarityHeuristic {

    private static final String XmlRootElementAnnotationName = XmlRootElement.class.getSimpleName();
    private static final String XmlElementAnnotationName = XmlElement.class.getSimpleName();
    private static final String XmlElementWrapperAnnotationName = XmlElementWrapper.class.getSimpleName();
    private static final String XmlAttributeAnnotationName = XmlAttribute.class.getSimpleName();

    private static final String[] JaxbAnnotationNames = new String[] {
            XmlRootElementAnnotationName,
            XmlElementAnnotationName,
            XmlElementWrapperAnnotationName,
            XmlAttributeAnnotationName
    };

    private static final String XmlNamespaceSeparator = ":";
    private static final String XsComplexTypeTagName = "complexType";
    private static final String XsElementTagName = "element";
    private static final String XsAttributeTagName = "attribute";

    private String removeQuotes(String string) {
        if (string.startsWith("\"") && string.endsWith("\"")
                || string.startsWith("'") && string.endsWith("'")) {
            return string.substring(1, string.length()-1);
        }
        return string;
    }

    private String removeXmlNamespacePrefix(String string) {
        int indexOfXmlNamespaceSeparator = string.indexOf(XmlNamespaceSeparator);
        if (indexOfXmlNamespaceSeparator > -1) {
            return string.substring(indexOfXmlNamespaceSeparator+1, string.length());
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

    private boolean areEqual(String a, String b) {
        return a.equals(b);
    }

    private boolean areLowerCaseEqual(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        return areEqual(a, b);
    }

    private boolean isXsComplexTypeTag(XMLElementFragmentAST xmlElementFragmentAST) {
        return areLowerCaseEqual(removeXmlNamespacePrefix(xmlElementFragmentAST.getName()), XsComplexTypeTagName);
    }

    private boolean isXsElementTag(XMLElementFragmentAST xmlElementFragmentAST) {
        return areLowerCaseEqual(removeXmlNamespacePrefix(xmlElementFragmentAST.getName()), XsElementTagName);
    }

    private boolean isXsAttributeTag(XMLElementFragmentAST xmlElementFragmentAST) {
        return areLowerCaseEqual(removeXmlNamespacePrefix(xmlElementFragmentAST.getName()), XsAttributeTagName);
    }

    private boolean equalsAnyJaxbAnnotationName(JavaAnnotationFragmentAST javaAnnotationFragmentAST) {
        return equalsAny(javaAnnotationFragmentAST.getIdentifier(), JaxbAnnotationNames);
    }

    private boolean hasAttribute(XMLElementFragmentAST xmlElementFragmentAST, String attributeName, String attributeValue) {
        return xmlElementFragmentAST.getXmlAttributeFragments().stream()
                .anyMatch(attribute -> areEqual(attribute.getName(), attributeName) && areEqual(attribute.getValue(), attributeValue));
    }

    private boolean hasJaxbAnnotationSimilarity(JavaAnnotationFragmentAST javaAnnotationFragment, XMLElementFragmentAST xmlElementFragmentAST) {
        if (equalsAnyJaxbAnnotationName(javaAnnotationFragment)) {
            if (javaAnnotationFragment.hasNamedParameter("name")) {
                if (isXsComplexTypeTag(xmlElementFragmentAST)) {
                    return hasAttribute(xmlElementFragmentAST, "name", removeQuotes(javaAnnotationFragment.getNamedParamterValue("name")));
                }
                else if (isXsElementTag(xmlElementFragmentAST)) {
                    return hasAttribute(xmlElementFragmentAST, "name", removeQuotes(javaAnnotationFragment.getNamedParamterValue("name")));
                }
                else if (isXsAttributeTag(xmlElementFragmentAST)) {
                    return hasAttribute(xmlElementFragmentAST, "name", removeQuotes(javaAnnotationFragment.getNamedParamterValue("name")));
                }
            }
        }
        return false;
    }

    private boolean hasJaxbAnnotationSimilarity(ModifiedJavaFragmentAST modifiedJavaFragmentAST, XMLElementFragmentAST xmlElementFragmentAST) {
        for (JavaModifierFragmentAST javaModifierFragment : modifiedJavaFragmentAST.getJavaModifierFragments()) {
            if (javaModifierFragment.isAnnotation()) {
                if (hasJaxbAnnotationSimilarity(javaModifierFragment.getJavaAnnotationFragment(), xmlElementFragmentAST)) {
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
        return false;
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLElementFragmentAST xmlElementFragment) {
        return hasJaxbAnnotationSimilarity(javaMethodFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        return false;
    }
}
