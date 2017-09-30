package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.SortedMap;

public class DiGraphNodeBuilder<TNode extends Comparable<TNode>, TEdge extends Comparable<TEdge>> implements IDiGraphNodeBuilder<TNode, TEdge> {

    private final TNode value;
    private final SortedMap<TNode,TEdge> sourceEdges;
    private final SortedMap<TNode,TEdge> targetEdges;

    public DiGraphNodeBuilder(TNode value, SortedMap<TNode, TEdge> sourceEdges, SortedMap<TNode, TEdge> targetEdges) {
        this.value = value;
        this.sourceEdges = sourceEdges;
        this.targetEdges = targetEdges;
    }

    @Override
    public TNode getValue() {
        return value;
    }

    @Override
    public SortedMap<TNode, TEdge> getSouceEdges() {
        return sourceEdges;
    }

    @Override
    public SortedMap<TNode, TEdge> getTargetEdges() {
        return targetEdges;
    }

    @Override
    public IDiGraphNodeBuilder<TNode, TEdge> withValue(TNode value) {
        return new DiGraphNodeBuilder<>(value, sourceEdges, targetEdges);
    }

    @Override
    public IDiGraphNodeBuilder<TNode, TEdge> withSourceEdge(TNode source, TEdge edgeValue) {
        sourceEdges.put(source, edgeValue);
        return new DiGraphNodeBuilder<>(value, sourceEdges, targetEdges);
    }

    @Override
    public IDiGraphNodeBuilder<TNode, TEdge> withTargetEdge(TNode target, TEdge edgeValue) {
        targetEdges.put(target, edgeValue);
        return new DiGraphNodeBuilder<>(value, sourceEdges, targetEdges);
    }

    @Override
    public IDiGraphNode<TNode, TEdge> build() {
        return new DiGraphNode<>(value, sourceEdges, targetEdges);
    }
}
