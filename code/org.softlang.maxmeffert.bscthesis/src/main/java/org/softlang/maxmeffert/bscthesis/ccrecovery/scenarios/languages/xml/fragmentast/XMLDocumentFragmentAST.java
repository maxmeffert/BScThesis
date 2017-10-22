package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.xml.fragmentast;

public class XMLDocumentFragmentAST extends XMLFragmentAST {
    private XMLElementFragmentAST xmlElementFragment;

    public XMLElementFragmentAST getXmlElementFragment() {
        return xmlElementFragment;
    }

    public void setXmlElementFragment(XMLElementFragmentAST xmlElementFragment) {
        this.xmlElementFragment = xmlElementFragment;
        addChild(xmlElementFragment);
    }
}
