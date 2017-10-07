package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.walks;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.IDiGraph;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.IGraph;

public class GraphWalks implements IGraphWalks {

    private final IGraphWalkFactory graphWalkFactory;
    private final IDiGraphWalkFactory diGraphWalkFactory;

    @Inject
    public GraphWalks(IGraphWalkFactory graphWalkFactory, IDiGraphWalkFactory diGraphWalkFactory) {
        this.graphWalkFactory = graphWalkFactory;
        this.diGraphWalkFactory = diGraphWalkFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IGraphWalk<TValue> newGraphWalk(IGraph<TValue> graph, TValue startNode) {
        return graphWalkFactory.newGraphWalk(graph, startNode);
    }

    @Override
    public <TValue extends Comparable<TValue>> IDiGraphWalk<TValue> newDiGraphWalk(IDiGraph<TValue> diGraph, TValue startNode) {
        return diGraphWalkFactory.newDiGraphWalk(diGraph, startNode);
    }
}
