package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees;

import org.antlr.v4.runtime.tree.ParseTree;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;

import java.util.List;
import java.util.Optional;

public interface IParseTree extends Comparable<IParseTree> {
    String getName();
    ITextSource getTextSource();
    Class<? extends ParseTree> getAntlrType();

    boolean hasParent();
    boolean hasParent(IParseTree parent);
    Optional<IParseTree> getParent();
    void setParent(IParseTree parent);
    boolean hasChildren();
    boolean hasChild(IParseTree child);
    List<IParseTree> getChildren();
    void addChild(IParseTree child);
    void addChildren(Iterable<IParseTree> children);
}
