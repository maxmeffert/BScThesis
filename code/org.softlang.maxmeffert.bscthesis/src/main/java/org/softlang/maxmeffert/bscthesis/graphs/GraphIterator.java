package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.SortedSet;
import java.util.Stack;

public class GraphIterator<TValue extends Comparable<TValue>> implements IGraphIterator<TValue> {

    private final IGraph<TValue> graph;
    private final Stack<TValue> nextNodes;
    private final SortedSet<TValue> discoveredNodes;

    public GraphIterator(IGraph<TValue> graph, Stack<TValue> nextNodes, SortedSet<TValue> discoveredNodes) {
        this.graph = graph;
        this.nextNodes = nextNodes;
        this.discoveredNodes = discoveredNodes;
    }


    @Override
    public boolean hasNext() {
        return !nextNodes.isEmpty();
    }

    @Override
    public TValue next() {
        TValue node = nextNodes.pop();
        markAsDiscovered(node);
        pushNextNodesOntoStack(node);
        return node;
    }

    private void pushNextNodesOntoStack(TValue node) {
        for(TValue adjacentNode : graph.getAdjacentNodesOf(node)) {
            if (isNotMarkedAsDiscovered(adjacentNode)) {
                nextNodes.push(adjacentNode);
            }
        }
    }

    private boolean markAsDiscovered(TValue next) {
        return discoveredNodes.add(next);
    }

    private boolean isNotMarkedAsDiscovered(TValue value) {
        return !isMarkedAsDiscovered(value);
    }

    private boolean isMarkedAsDiscovered(TValue value) {
        return discoveredNodes.contains(value);
    }
}
