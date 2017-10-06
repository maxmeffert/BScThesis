package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.views.old.ISortedSetView;

public class GraphNode<TNode extends Comparable<TNode>> implements IGraphNode<TNode> {

    private final TNode value;
    private final ISortedSetView<TNode> adjacentNodes;

    public GraphNode(TNode value, ISortedSetView<TNode> adjacentNodes) {
        this.value = value;
        this.adjacentNodes = adjacentNodes;
    }

    @Override
    public TNode getValue() {
        return value;
    }

    @Override
    public ISortedSetView<TNode> getAdjacentNodes() {
        return adjacentNodes;
    }

    @Override
    public int compareTo(IGraphNode<TNode> tNodeIGraphNode) {
        return getValue().compareTo(tNodeIGraphNode.getValue());
    }
}
