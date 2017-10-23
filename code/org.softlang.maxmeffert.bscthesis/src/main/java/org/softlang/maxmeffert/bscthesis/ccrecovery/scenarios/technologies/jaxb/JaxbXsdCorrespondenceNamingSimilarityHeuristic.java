package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.IdentifiedJavaFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaClassFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaFieldFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaMethodFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragmentAST;

public class JaxbXsdCorrespondenceNamingSimilarityHeuristic extends BaseJaxbSimilarityHeuristic {

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

    private boolean areEqual(String a, String b) {
        return a.equals(b);
    }

    private boolean areLowerCaseEqual(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        return areEqual(a, b);
    }

    private boolean isXsComplexTypeTag(String string) {
        return areLowerCaseEqual(removeXmlNamespacePrefix(string), XsComplexTypeTagName);
    }

    private boolean isXsElementTag(String string) {
        return areLowerCaseEqual(removeXmlNamespacePrefix(string), XsElementTagName);
    }

    private boolean isXsAttributeTag(String string) {
        return areLowerCaseEqual(removeXmlNamespacePrefix(string), XsAttributeTagName);
    }

    private boolean hasXsComplexTypeSimilarity(IdentifiedJavaFragmentAST identifiedJavaFragmentAST, XMLElementFragmentAST xmlElementFragmentAST) {
        return xmlElementFragmentAST.getXmlAttributeFragments().stream()
                .anyMatch(attribute -> areLowerCaseEqual(attribute.getName(), "name")
                        && areLowerCaseEqual(removeQuotes(attribute.getValue()), identifiedJavaFragmentAST.getIdentifier()));
    }

    private boolean hasXsElementSimilarity(IdentifiedJavaFragmentAST identifiedJavaFragmentAST, XMLElementFragmentAST xmlElementFragmentAST) {
        return xmlElementFragmentAST.getXmlAttributeFragments().stream()
                .anyMatch(attribute -> areLowerCaseEqual(attribute.getName(), "name")
                        && areLowerCaseEqual(removeQuotes(attribute.getValue()), identifiedJavaFragmentAST.getIdentifier()));
    }

    private boolean hasXsAttributeSimilarity(IdentifiedJavaFragmentAST identifiedJavaFragmentAST, XMLElementFragmentAST xmlElementFragmentAST) {
        return xmlElementFragmentAST.getXmlAttributeFragments().stream()
                .anyMatch(attribute -> areLowerCaseEqual(attribute.getName(), "name")
                        && areLowerCaseEqual(removeQuotes(attribute.getValue()), identifiedJavaFragmentAST.getIdentifier()));
    }

    private boolean hasJaxbNamingSimilarity(IdentifiedJavaFragmentAST identifiedJavaFragmentAST, XMLElementFragmentAST xmlElementFragmentAST) {
        String name = xmlElementFragmentAST.getName();
        if (isXsComplexTypeTag(name)) {
            return hasXsComplexTypeSimilarity(identifiedJavaFragmentAST, xmlElementFragmentAST);
        }
        else if (isXsElementTag(name)) {
            return hasXsElementSimilarity(identifiedJavaFragmentAST, xmlElementFragmentAST);
        }
        else if (isXsAttributeTag(name)) {
            return hasXsAttributeSimilarity(identifiedJavaFragmentAST, xmlElementFragmentAST);
        }
        return false;
    }

    @Override
    protected boolean similar(JavaClassFragmentAST javaClassFragment, XMLElementFragmentAST xmlElementFragment) {
        return hasJaxbNamingSimilarity(javaClassFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLElementFragmentAST xmlElementFragment) {
        return hasJaxbNamingSimilarity(javaFieldFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaFieldFragmentAST javaFieldFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        return false;
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLElementFragmentAST xmlElementFragment) {
        return hasJaxbNamingSimilarity(javaMethodFragment, xmlElementFragment);
    }

    @Override
    protected boolean similar(JavaMethodFragmentAST javaMethodFragment, XMLAttributeFragmentAST xmlAttributeFragment) {
        return false;
    }
}
