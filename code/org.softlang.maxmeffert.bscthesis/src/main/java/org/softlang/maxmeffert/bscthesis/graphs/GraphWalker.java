package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.common.collect.Streams;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class GraphWalker<T extends Comparable<T>> implements IGraphWalker<T> {

    public static <T extends Comparable<T>> GraphWalker<T> get() {
        return new GraphWalker<>();
    }

    @Override
    public void walkDepthFirst(Function<T, Iterable<T>> adjacentVertexProvider, T startVertex,  Consumer<T> vertexConsumer) {
        Streams.stream(DepthFirstIterator.of(adjacentVertexProvider, startVertex)).forEach(vertexConsumer);
    }

    @Override
    public void walkDepthFirst(final IGraph<T> graph, T startVertex, Consumer<T> vertexConsumer) {
        Streams.stream(DepthFirstIterableGraph.of(graph, startVertex)).forEach(vertexConsumer);
    }

    @Override
    public boolean anyDepthFirst(Function<T, Iterable<T>> adjacentVertexProvider, T startVertex, Predicate<T> vertexPredicate) {
        return Streams.stream(DepthFirstIterator.of(adjacentVertexProvider, startVertex)).anyMatch(vertexPredicate);
    }

    @Override
    public boolean anyDepthFirst(IGraph<T> graph, T startVertex, Predicate<T> vertexPredicate) {
        return Streams.stream(DepthFirstIterableGraph.of(graph, startVertex)).anyMatch(vertexPredicate);
    }



}
