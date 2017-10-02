package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

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
