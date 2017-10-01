package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.inject.Inject;

public class TreeBuilderFactory implements ITreeBuilderFactory {

    private final IDiGraphBuilderFactory diGraphBuilderFactory;

    @Inject
    public TreeBuilderFactory(IDiGraphBuilderFactory diGraphBuilderFactory) {
        this.diGraphBuilderFactory = diGraphBuilderFactory;
    }

    @Override
    public <TNode extends Comparable<TNode>> ITreeBuilder<TNode> newTreeBuilder() {
        return new TreeBuilder<>();
    }
}
