package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class SimpleParseTreeBuilder implements ISimpleParseTreeBuilder {

    private final TokenStream sourceStream;
    private final Interval sourceInterval;
    private final Collection<ISimpleParseTree> children = new LinkedList<>();

    public SimpleParseTreeBuilder() {
        this(null, null, Collections.EMPTY_LIST);
    }

    public SimpleParseTreeBuilder(TokenStream sourceStream, Interval sourceInterval, Collection<ISimpleParseTree> children) {
        this.sourceStream = sourceStream;
        this.sourceInterval = sourceInterval;
        this.children.addAll(children);
    }

    @Override
    public ISimpleParseTreeBuilder withSourceInterval(Interval interval) {
        return new SimpleParseTreeBuilder(sourceStream, interval, children);
    }

    @Override
    public ISimpleParseTreeBuilder withSourceStream(TokenStream tokenStream) {
        return new SimpleParseTreeBuilder(tokenStream, sourceInterval, children);
    }

    @Override
    public ISimpleParseTreeBuilder withChild(ISimpleParseTree parseTree) {
        children.add(parseTree);
        return new SimpleParseTreeBuilder(sourceStream, sourceInterval, children);
    }

    @Override
    public ISimpleParseTreeBuilder withChildren(Collection<ISimpleParseTree> parseTrees) {
        children.addAll(parseTrees);
        return new SimpleParseTreeBuilder(sourceStream, sourceInterval, children);
    }

    @Override
    public ISimpleParseTree build() {
        return new SimpleParseTree(sourceStream, sourceInterval, children);
    }
}
