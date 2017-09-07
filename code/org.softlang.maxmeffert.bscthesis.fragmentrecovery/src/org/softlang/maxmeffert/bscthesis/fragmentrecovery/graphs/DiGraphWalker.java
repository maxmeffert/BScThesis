package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graphs;

import java.util.Set;
import java.util.function.Consumer;

public class DiGraphWalker<T extends Comparable<T>> extends GraphWalker<T> implements IDiGraphWalker<T>  {

    private boolean isWalkedNode(T node, Set<T> walkedNodes) {
        return walkedNodes.contains(node);
    }

    private boolean isNotWalkedNode(T node, Set<T> walkedNodes) {
        return !isWalkedNode(node, walkedNodes);
    }

    private void walk(IDiGraph<T> diGraph, T startNode, Set<T> walkedNodes, Consumer<T> consumer) {
        walkedNodes.add(startNode);
        consumer.accept(startNode);
        for (T targetOfStartNode : diGraph.getTargetsOf(startNode)) {
            if (isNotWalkedNode(targetOfStartNode, walkedNodes)) {
                walk(diGraph, targetOfStartNode, walkedNodes, consumer);
            }
        }
    }

    @Override
    public void walkDepthFirst(IDiGraph<T> diGraph, T start, Consumer<T> consumer) {
        walkDepthFirst(diGraph, start, consumer);
    }

    @Override
    public void walkBackDepthFirst(IDiGraph<T> diGraph, T start, Consumer<T> consumer) {
        walkDepthFirst(v -> diGraph.getSourcesOf(v), start,  consumer);
    }
}
