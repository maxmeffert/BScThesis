package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;

import java.util.Collection;

public class SimpleParseTree implements ISimpleParseTree {

    private final TokenStream sourceStream;
    private final Interval sourceInterval;
    private final Collection<ISimpleParseTree> children;

    public SimpleParseTree(TokenStream sourceStream, Interval sourceInterval, Collection<ISimpleParseTree> children) {
        this.sourceStream = sourceStream;
        this.sourceInterval = sourceInterval;
        this.children = children;
    }

    @Override
    public Collection<ISimpleParseTree> getChildren() {
        return children;
    }

    @Override
    public Interval getSourceInterval() {
        return sourceInterval;
    }

    @Override
    public TokenStream getSourceStream() {
        return sourceStream;
    }

    @Override
    public String getText() {
        return getSourceStream().getText(getSourceInterval());
    }

    @Override
    public String toString() {
        return getText();
    }
}
