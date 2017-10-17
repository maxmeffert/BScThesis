package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.xml.fast;

import com.google.common.collect.Lists;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

import java.util.List;

public class XMLElementFragment extends XMLFragment {

    private final String name;
    private final List<XMLElementFragment> elements;

    public XMLElementFragment(String name, String text, List<XMLElementFragment> elements) {
        super(text, Lists.newLinkedList(elements));
        this.name = name;
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    public List<XMLElementFragment> getElements() {
        return elements;
    }
}
