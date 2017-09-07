package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graphs;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface IGraphWalker<T extends Comparable<T>> {

    void walkDepthFirst(Function<T, Iterable<T>> adjacentVertexProvider, T startVertex, Consumer<T> vertexConsumer);
    void walkDepthFirst(IGraph<T> graph, T startVertex, Consumer<T> vertexConsumer);
    boolean findDepthFirst(Function<T, Iterable<T>> adjacentVertexProvider, T startVertex, Predicate<T> vertexPredicate);
    boolean findDepthFirst(IGraph<T> graph, T startVertex, Predicate<T> vertexPredicate);


}
