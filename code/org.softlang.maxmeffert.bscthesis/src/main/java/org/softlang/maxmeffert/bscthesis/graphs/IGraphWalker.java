package org.softlang.maxmeffert.bscthesis.graphs;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface IGraphWalker<T extends Comparable<T>> {

    Iterable<T> getDepthFirstWalk(Function<T, Iterable<T>> adjacentVertexProvider, T startVertex);
    void walkDepthFirst(Function<T, Iterable<T>> adjacentVertexProvider, T startVertex, Consumer<T> vertexConsumer);
    void walkDepthFirst(IGraph<T> graph, T startVertex, Consumer<T> vertexConsumer);
    boolean anyDepthFirst(Function<T, Iterable<T>> adjacentVertexProvider, T startVertex, Predicate<T> vertexPredicate);
    boolean anyDepthFirst(IGraph<T> graph, T startVertex, Predicate<T> vertexPredicate);

}
