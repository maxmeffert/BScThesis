package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import com.google.common.collect.Sets;

import java.util.Set;
import java.util.function.Consumer;

public class DiGraphWalker<T extends Comparable<T>> implements IDiGraphWalker<T> {

    private void walk(IDiGraph<T> diGraph, T startNode, Set<T> walkedNodes, Consumer<T> consumer) {
        walkedNodes.add(startNode);
        consumer.accept(startNode);
        for (T targetOfStart : diGraph.getTargetsOf(startNode)) {
            if (!walkedNodes.contains(targetOfStart)) {
                walk(diGraph, targetOfStart, walkedNodes, consumer);
            }
        }
    }

    @Override
    public void walk(IDiGraph<T> diGraph, T startNode, Consumer<T> consumer) {
        walk(diGraph, startNode, Sets.newTreeSet(), consumer);
    }
}
