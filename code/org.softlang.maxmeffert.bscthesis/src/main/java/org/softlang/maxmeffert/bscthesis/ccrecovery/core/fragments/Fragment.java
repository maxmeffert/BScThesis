package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextInterval;
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
        return getTextSource().getText();
    }

    @Override
    public ITextSource getTextSource() {
        return getParseTree().getValue();
    }

    @Override
    public ITextInterval getTextInterval() {
        return getTextSource().getTextInterval();
    }

    @Override
    public int getTextStartPosition() {
        return getTextInterval().getStartPosition();
    }

    @Override
    public int getTextEndPosition() {
        return getTextInterval().getEndPosition();
    }

    @Override
    public boolean contains(IFragment iFragment) {
        return getTextSource().contains(iFragment.getTextSource());
    }

    @Override
    public boolean properlyContains(IFragment iFragment) {
        return getTextSource().properlyContains(iFragment.getTextSource());
    }

    @Override
    public boolean startsWith(String prefix) {
        return getTextSource().startsWith(prefix);
    }

    @Override
    public boolean endsWith(String suffix) {
        return getTextSource().endsWith(suffix);
    }

    @Override
    public boolean matches(String regex) {
        return getTextSource().matches(regex);
    }

    @Override
    public String toString() {
        return getTextSource().toString();
    }

    @Override
    public int compareTo(IFragment iFragment) {
        return getParseTree().compareTo(iFragment.getParseTree());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IFragment) {
            return compareTo((IFragment) obj) == 0;
        }
        return false;
    }
}