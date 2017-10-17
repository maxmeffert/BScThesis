package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import java.util.List;

public class Fragment implements IFragment {

    private final String text;
    private final List<IFragment> children;

    public Fragment(String text, List<IFragment> children) {
        this.text = text;
        this.children = children;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public List<IFragment> getChildren() {
        return children;
    }

    @Override
    public int compareTo(IFragment fragment) {
        return getText().compareTo(fragment.getText());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IFragment) {
            return compareTo((IFragment) obj) == 0;
        }
        return false;
    }
}
