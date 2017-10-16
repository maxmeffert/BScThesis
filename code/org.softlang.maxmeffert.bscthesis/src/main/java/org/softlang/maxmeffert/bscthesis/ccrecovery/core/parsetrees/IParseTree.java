package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;

import java.util.List;

public interface IParseTree extends Comparable<IParseTree> {
    String getName();
    ITextSource getTextSource();

    boolean hasParent();
    boolean hasParent(IParseTree parent);
    IParseTree getParent();
    void setParent(IParseTree parent);
    boolean hasChildren();
    boolean hasChild(IParseTree child);
    List<IParseTree> getChildren();
    void addChild(IParseTree child);
    void addChildren(Iterable<IParseTree> children);
}
