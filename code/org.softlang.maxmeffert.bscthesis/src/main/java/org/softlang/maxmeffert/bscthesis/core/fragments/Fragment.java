package org.softlang.maxmeffert.bscthesis.core.fragments;

import org.softlang.maxmeffert.bscthesis.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.core.trees.ITree;

public class Fragment implements IFragment {

    private final ITree<ITextSource> parseTree;

    public Fragment(ITree<ITextSource> parseTree) {
        this.parseTree = parseTree;
    }

    @Override
    public ITree<ITextSource> getParseTree() {
        return parseTree;
    }

    @Override
    public String getText() {
        return parseTree.getValue().getText();
    }

    @Override
    public String toString() {
        return getParseTree().getValue().toString();
    }

    @Override
    public int compareTo(IFragment iFragment) {
        return getParseTree().compareTo(iFragment.getParseTree());
    }
}
