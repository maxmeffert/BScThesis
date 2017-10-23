package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.jaxb;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.IdentifiedJavaFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaClassFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaFieldFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast.JavaMethodFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLAttributeFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast.XMLElementFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.StringUtils;

public class JaxbXsdCorrespondenceNamingSimilarityHeuristic extends BaseJaxbSimilarityHeuristic {

    private static final String XmlNamespaceSeparator = ":";
    private static final String XsComplexTypeTagName = "complexType";
    private static final String XsElementTagName = "element";
    private static final String XsAttributeTagName = "attribute";

    private String removeXmlNamespacePrefix(String string) {
        int indexOfXmlNamespaceSeparator = string.indexOf(XmlNamespaceSeparator);
        if (indexOfXmlNamespaceSeparator > -1) {
            return string.substring(indexOfXmlNamespaceSeparator+1, string.length());
        }
        return string;
    }

    private boolean isXsComplexTypeTag(XMLElementFragmentAST xmlElementFragmentAST) {
        return StringUtils.areLowerCaseEqual(removeXmlNamespacePrefix(xmlElementFragmentAST.getName()), XsComplexTypeTagName);
    }

    private boolean isXsElementTag(XMLElementFragmentAST xmlElementFragmentAST) {
        return StringUtils.areLowerCaseEqual(removeXmlNamespacePrefix(xmlElementFragmentAST.getName()), XsElementTagName);
    }

    private boolean isXsAttributeTag(XMLElementFragmentAST xmlElementFragmentAST) {
        return StringUtils.areLowerCaseEqual(removeXmlNamespacePrefix(xmlElementFragmentAST.getName()), XsAttributeTagName);
    }


    private boolean hasXsComplexTypeSimilarity(IdentifiedJavaFragmentAST identifiedJavaFragmentAST, XMLElementFragmentAST xmlElementFragmentAST) {
        return xmlElementFragmentAST.getXmlAttributeFragments().stream()
                .anyMatch(attribute -> StringUtils.areLowerCaseEqual(attribute.getName(), "name")
                        && StringUtils.areLowerCaseEqual(StringUtils.removeQuotes(attribute.getValue()), identifiedJavaFragmentAST.getIdentifier()));
    }

    private boolean hasXsElementSimilarity(IdentifiedJavaFragmentAST identifiedJavaFragmentAST, XMLElementFragmentAST xmlElementFragmentAST) {
        return xmlElementFragmentAST.getXmlAttributeFragments().stream()
                .anyMatch(attribute -> StringUtils.areLowerCaseEqual(attribute.getName(), "name")
                        && StringUtils.areLowerCaseEqual(StringUtils.removeQuotes(attribute.getValue()), identifiedJavaFragmentAST.getIdentifier()));
    }

    private boolean hasXsAttributeSimilarity(IdentifiedJavaFragmentAST identifiedJavaFragmentAST, XMLElementFragmentAST xmlElementFragmentAST) {
        return xmlElementFragmentAST.getXmlAttributeFragments().stream()
                .anyMatch(attribute -> StringUtils.areLowerCaseEqual(attribute.getName(), "name")
                        && StringUtils.areLowerCaseEqual(StringUtils.removeQuotes(attribute.getValue()), identifiedJavaFragmentAST.getIdentifier()));
    }

    private boolean hasJaxbNamingSimilarity(IdentifiedJavaFragmentAST identifiedJavaFragmentAST, XMLElementFragmentAST xmlElementFragmentAST) {
        if (isXsComplexTypeTag(xmlElementFragmentAST)) {
            return hasXsComplexTypeSimilarity(identifiedJavaFragmentAST, xmlElementFragmentAST);
        }
        else if (isXsElementTag(xmlElementFragmentAST)) {
            return hasXsElementSimilarity(identifiedJavaFragmentAST, xmlElementFragmentAST);
        }
        else if (isXsAttributeTag(xmlElementFragmentAST)) {
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
