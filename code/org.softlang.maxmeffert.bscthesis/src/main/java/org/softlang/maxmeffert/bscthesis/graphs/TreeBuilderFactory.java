package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.inject.Inject;

public class TreeBuilderFactory implements ITreeBuilderFactory {

    private final IDiGraphBuilderFactory diGraphBuilderFactory;

    @Inject
    public TreeBuilderFactory(IDiGraphBuilderFactory diGraphBuilderFactory) {
        this.diGraphBuilderFactory = diGraphBuilderFactory;
    }

    @Override
    public <TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> ITreeBuilder<TNode, TEdge> newTreeBuilder() {
        return new TreeBuilder<>(diGraphBuilderFactory.<TNode,TEdge>newDiGraphBuilder());
    }
}
