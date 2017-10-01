package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import org.softlang.maxmeffert.bscthesis.graphs.ITreeBuilder;
import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;

public class SimpleParseTreeBuilder implements ISimpleParseTreeBuilder {

    private final ITreeBuilder<ITextSource,Integer> treeBuilder;

    public SimpleParseTreeBuilder(ITreeBuilder<ITextSource, Integer> treeBuilder) {
        this.treeBuilder = treeBuilder;
    }

    @Override
    public ISimpleParseTreeBuilder withChild(ITextSource parent, ITextSource child) {
        return new SimpleParseTreeBuilder(treeBuilder.withChild(parent, child, 0));
    }

    @Override
    public ISimpleParseTree build() {
        return new SimpleParseTree(treeBuilder.build());
    }
}
