package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import com.google.inject.Inject;

public class GraphBuilders implements IGraphBuilders {

    private final IGraphBuilderFactory graphBuilderFactory;
    private final IDiGraphBuilderFactory diGraphBuilderFactory;

    @Inject
    public GraphBuilders(IGraphBuilderFactory graphBuilderFactory, IDiGraphBuilderFactory diGraphBuilderFactory) {
        this.graphBuilderFactory = graphBuilderFactory;
        this.diGraphBuilderFactory = diGraphBuilderFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraphBuilder<TValue> newGraphBuilder() {
        return graphBuilderFactory.newGraphBuilder();
    }

    @Override
    public <TValue extends Comparable<TValue>> IDiGraphBuilder<TValue> newDiGraphBuilder() {
        return diGraphBuilderFactory.newDiGraphBuilder();
    }

}
