package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.walks;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.old.IDiGraph;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.iterators.IGraphIterators;

import java.util.Iterator;

public class DiGraphWalk<TValue extends Comparable<TValue>> implements IDiGraphWalk<TValue> {

    private final IDiGraph<TValue> diGraph;
    private final TValue startNode;
    private final IGraphIterators graphIteratorFactory;

    public DiGraphWalk(IDiGraph<TValue> diGraph, TValue startNode, IGraphIterators graphIteratorFactory) {
        this.diGraph = diGraph;
        this.startNode = startNode;
        this.graphIteratorFactory = graphIteratorFactory;
    }

    @Override
    public Iterator<TValue> iterator() {
        return graphIteratorFactory.newDirectedGraphIterator(diGraph, startNode);
    }
}
