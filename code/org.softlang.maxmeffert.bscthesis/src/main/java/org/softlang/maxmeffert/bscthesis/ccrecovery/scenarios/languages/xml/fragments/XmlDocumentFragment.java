package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragments;

public class XmlDocumentFragment extends XmlFragment {
    private XmlElementFragment xmlElementFragment;

    public XmlElementFragment getXmlElementFragment() {
        return xmlElementFragment;
    }

    public void setXmlElementFragment(XmlElementFragment xmlElementFragment) {
        this.xmlElementFragment = xmlElementFragment;
        addChild(xmlElementFragment);
    }
}
