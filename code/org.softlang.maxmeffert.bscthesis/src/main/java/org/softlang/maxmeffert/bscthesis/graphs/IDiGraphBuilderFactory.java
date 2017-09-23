package org.softlang.maxmeffert.bscthesis.graphs;

import sun.nio.cs.ext.COMPOUND_TEXT;

public interface IDiGraphBuilderFactory {
    <TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> IDiGraphBuilder<TNode,TEdge> newDiGraphBuilder();
}
