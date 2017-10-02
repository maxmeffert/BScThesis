package org.softlang.maxmeffert.bscthesis.core.graphs.traversal.walks;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.core.graphs.IDiGraph;
import org.softlang.maxmeffert.bscthesis.core.graphs.traversal.iterators.IGraphIterators;

public class DiGraphWalkFactory implements IDiGraphWalkFactory {

    private final IGraphIterators graphIteratorFactory;

    @Inject
    public DiGraphWalkFactory(IGraphIterators graphIteratorFactory) {
        this.graphIteratorFactory = graphIteratorFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IDiGraphWalk<TValue> newDiGraphWalk(IDiGraph<TValue> diGraph, TValue startNode) {
        return new DiGraphWalk<>(diGraph, startNode, graphIteratorFactory);
    }

}
