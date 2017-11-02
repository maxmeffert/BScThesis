package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast;

public class XMLDocumentFragment extends XMLFragment {
    private XMLElementFragment xmlElementFragment;

    public XMLElementFragment getXmlElementFragment() {
        return xmlElementFragment;
    }

    public void setXmlElementFragment(XMLElementFragment xmlElementFragment) {
        this.xmlElementFragment = xmlElementFragment;
        addChild(xmlElementFragment);
    }
}
