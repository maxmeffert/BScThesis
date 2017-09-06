package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

import java.util.Set;
import java.util.function.Consumer;

public class DiGraphWalker<T extends Comparable<T>> implements IDiGraphWalker<T> {

    private void walk(IDiGraph<T> diGraph, T start, Set<T> discovered, Consumer<T> consumer) {
        discovered.add(start);
        consumer.accept(start);
        for (T targetOfStart : diGraph.getTargetsOf(start)) {
            if (!discovered.contains(targetOfStart)) {
                walk(diGraph, targetOfStart, discovered, consumer);
            }
        }
    }

    @Override
    public void walk(IDiGraph<T> diGraph, T start, Consumer<T> consumer) {
        walk(diGraph, start, Sets.newTreeSet(), consumer);
    }
}
