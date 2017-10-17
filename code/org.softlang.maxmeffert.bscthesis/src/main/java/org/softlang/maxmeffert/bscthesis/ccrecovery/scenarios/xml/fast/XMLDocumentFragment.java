package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fast;

import com.google.common.collect.Lists;

import java.util.List;

public class XMLDocumentFragment extends XMLFragment {
    public XMLDocumentFragment(String text, List<XMLElementFragment> children) {
        super(text, Lists.newLinkedList(children));
    }
}
