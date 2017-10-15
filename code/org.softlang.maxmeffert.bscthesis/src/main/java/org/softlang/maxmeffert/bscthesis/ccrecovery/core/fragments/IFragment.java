package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

import java.util.List;

public interface IFragment extends Comparable<IFragment> {
    ITree<ITextSource> getParseTree();
    String getText();
    List<String> getTokens();
    ITextSource getTextSource();
    ITextInterval getTextInterval();
    int getTextStartPosition();
    int getTextEndPosition();
    boolean contains(IFragment iFragment);
    boolean properlyContains(IFragment iFragment);
    boolean startsWith(String prefix);
    boolean endsWith(String suffix);
    boolean matches(String regex);
}
