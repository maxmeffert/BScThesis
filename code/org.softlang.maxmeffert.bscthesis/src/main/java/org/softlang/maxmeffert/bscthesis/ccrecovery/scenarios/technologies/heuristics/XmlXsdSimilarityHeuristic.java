package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.technologies.heuristics;

import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlAttributeFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments.XmlElementFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.utils.XmlFragmentUtils;

public class XmlXsdSimilarityHeuristic extends BaseXmlXsdSimilarityHeuristic {
    @Override
    protected boolean areSimilar(XmlElementFragment xmlElementFragment, XmlElementFragment xsdElementFragment) {
        return (XmlFragmentUtils.isXsElementTag(xsdElementFragment)
                || XmlFragmentUtils.isXsComplexTypeTag(xsdElementFragment))
                && XmlFragmentUtils.hasAttribute(xsdElementFragment, "name", xmlElementFragment.getName());
    }

    @Override
    protected boolean areSimilar(XmlAttributeFragment xmlAttributeFragment, XmlElementFragment xsdElementFragment) {
        return XmlFragmentUtils.isXsAttributeTag(xsdElementFragment)
                && XmlFragmentUtils.hasAttribute(xsdElementFragment, "name", xsdElementFragment.getName());
    }
}
