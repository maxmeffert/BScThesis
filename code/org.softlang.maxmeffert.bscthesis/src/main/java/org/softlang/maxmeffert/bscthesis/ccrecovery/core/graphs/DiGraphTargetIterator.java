package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.DiGraphIterator;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.IDiGraph;

public class DiGraphTargetIterator<TValue extends Comparable<TValue>> extends DiGraphIterator {

    public DiGraphTargetIterator(IDiGraph diGraph, Comparable start) {
        super(diGraph, start);
    }

    @Override
    protected Iterable getNextNodes(IDiGraph diGraph, Comparable currentNode) {
        return diGraph.getTargetNodesOf(currentNode);
    }
}
