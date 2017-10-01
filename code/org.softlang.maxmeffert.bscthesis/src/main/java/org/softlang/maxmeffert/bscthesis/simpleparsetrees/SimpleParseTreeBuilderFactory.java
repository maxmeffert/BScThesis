package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.graphs.ITreeBuilderFactory;

public class SimpleParseTreeBuilderFactory implements ISimpleParseTreeBuilderFactory {

    private final ITreeBuilderFactory treeBuilderFactory;

    @Inject
    public SimpleParseTreeBuilderFactory(ITreeBuilderFactory treeBuilderFactory) {
        this.treeBuilderFactory = treeBuilderFactory;
    }

    @Override
    public ISimpleParseTreeBuilder newSimpleParseTreeBuilder() {
        return new SimpleParseTreeBuilder();
    }
}
