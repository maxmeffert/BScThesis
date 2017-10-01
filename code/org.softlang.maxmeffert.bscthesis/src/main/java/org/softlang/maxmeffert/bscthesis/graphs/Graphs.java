package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.inject.Inject;

public class Graphs implements IGraphs {

    private final IGraphBuilderFactory graphBuilderFactory;
    private final IDiGraphBuilderFactory diGraphBuilderFactory;
    private final ITreeBuilderFactory treeBuilderFactory;

    @Inject
    public Graphs(IGraphBuilderFactory graphBuilderFactory, IDiGraphBuilderFactory diGraphBuilderFactory, ITreeBuilderFactory treeBuilderFactory) {
        this.graphBuilderFactory = graphBuilderFactory;
        this.diGraphBuilderFactory = diGraphBuilderFactory;
        this.treeBuilderFactory = treeBuilderFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraphBuilder<TValue> newGraphBuilder() {
        return graphBuilderFactory.newGraphBuilder();
    }

    @Override
    public <TValue extends Comparable<TValue>> IDiGraphBuilder<TValue> newDiGraphBuilder() {
        return diGraphBuilderFactory.newDiGraphBuilder();
    }

    @Override
    public <TValue extends Comparable<TValue>> ITreeBuilder<TValue> newTreeBuilder() {
        return treeBuilderFactory.newTreeBuilder();
    }
}
