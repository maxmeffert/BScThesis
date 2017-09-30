package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.SortedMap;

public interface IDiGraphNodeBuilder<TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> {

    TNode getValue();

    SortedMap<TNode, TEdge> getSouceEdges();

    SortedMap<TNode, TEdge> getTargetEdges();

    IDiGraphNodeBuilder<TNode, TEdge> withValue(TNode value);

    IDiGraphNodeBuilder<TNode, TEdge> withSourceEdge(TNode source, TEdge edgeValue);

    IDiGraphNodeBuilder<TNode, TEdge> withTargetEdge(TNode target, TEdge edgeValue);

    IDiGraphNode<TNode, TEdge> build();
}
