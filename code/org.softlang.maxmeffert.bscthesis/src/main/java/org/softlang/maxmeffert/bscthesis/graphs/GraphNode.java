package org.softlang.maxmeffert.bscthesis.graphs;

public class GraphNode<TNode extends Comparable<TNode>> implements IGraphNode<TNode> {

    private final TNode value;
    private final Iterable<TNode> adjacentNodes;

    public GraphNode(TNode value, Iterable<TNode> adjacentNodes) {
        this.value = value;
        this.adjacentNodes = adjacentNodes;
    }

    @Override
    public TNode getValue() {
        return value;
    }

    @Override
    public Iterable<TNode> getAdjacentNodes() {
        return adjacentNodes;
    }

    @Override
    public int compareTo(IGraphNode<TNode> tNodeIGraphNode) {
        return getValue().compareTo(tNodeIGraphNode.getValue());
    }
}
