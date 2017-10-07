package org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.traversal.iterators;

import java.util.SortedSet;
import java.util.Stack;
import java.util.function.Function;

public class GeneralGraphIterator<TValue extends Comparable<TValue>> implements IGraphIterator<TValue> {

    private final Function<TValue, Iterable<TValue>> nodeProvider;
    private final Stack<TValue> nextNodes;
    private final SortedSet<TValue> discoveredNodes;

    public GeneralGraphIterator(Function<TValue, Iterable<TValue>> nodeProvider, Stack<TValue> nextNodes, SortedSet<TValue> discoveredNodes) {
        this.nodeProvider = nodeProvider;
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
        for(TValue adjacentNode : nodeProvider.apply(node)) {
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
