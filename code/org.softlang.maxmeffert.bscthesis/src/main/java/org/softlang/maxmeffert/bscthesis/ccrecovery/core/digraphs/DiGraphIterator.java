package org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs;

import com.google.common.collect.Sets;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.Stack;

public abstract class DiGraphIterator<TValue extends Comparable<TValue>> implements Iterator<TValue> {

    protected abstract Iterable<TValue> getNextNodes(IDiGraph<TValue> diGraph, TValue currentNode);

    private final IDiGraph<TValue> diGraph;

    private final Stack<TValue> nextNodes = new Stack<>();
    private final SortedSet<TValue> discoveredNodes = Sets.newTreeSet();

    public DiGraphIterator(IDiGraph<TValue> diGraph, TValue start) {
        this.diGraph = diGraph;
        nextNodes.push(start);
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
        for(TValue adjacentNode : getNextNodes(diGraph, node)) {
            if (isNotMarkedAsDiscovered(adjacentNode)) {
                nextNodes.push(adjacentNode);
            }
        }
    }

    private void markAsDiscovered(TValue next) {
        discoveredNodes.add(next);
    }

    private boolean isNotMarkedAsDiscovered(TValue value) {
        return !isMarkedAsDiscovered(value);
    }

    private boolean isMarkedAsDiscovered(TValue value) {
        return discoveredNodes.contains(value);
    }
}
