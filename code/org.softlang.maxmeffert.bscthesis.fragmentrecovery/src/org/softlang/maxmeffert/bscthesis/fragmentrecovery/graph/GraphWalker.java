package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import com.google.common.collect.Sets;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public class GraphWalker<T extends Comparable<T>> implements IGraphWalker<T> {

    public static <T extends Comparable<T>> GraphWalker<T> get() {
        return new GraphWalker<>();
    }

    private boolean isWalkedVertex(T vertex, Set<T> walkedVertices) {
        return walkedVertices.contains(vertex);
    }

    private boolean isNotWalkedVertex(T vertex, Set<T> walkedVertices) {
        return !isWalkedVertex(vertex, walkedVertices);
    }

    private void walkDepthFirst(Function<T, Iterable<T>> adjacentVertexProvider, T startVertex,  Consumer<T> vertexConsumer, Set<T> walkedVertices) {
        walkedVertices.add(startVertex);
        vertexConsumer.accept(startVertex);
        for (T adjacentVertex : adjacentVertexProvider.apply(startVertex)) {
            if (isNotWalkedVertex(adjacentVertex, walkedVertices)) {
                walkDepthFirst(adjacentVertexProvider, adjacentVertex,  vertexConsumer, walkedVertices);
            }
        }
    }

    @Override
    public void walkDepthFirst(Function<T, Iterable<T>> adjacentVertexProvider, T startVertex,  Consumer<T> vertexConsumer) {
        walkDepthFirst(adjacentVertexProvider, startVertex,  vertexConsumer, Sets.newTreeSet());
    }

    @Override
    public void walkDepthFirst(final IGraph<T> graph, T startVertex, Consumer<T> vertexConsumer) {
        walkDepthFirst(v -> graph.getAdjacentVerticesOf(v), startVertex,  vertexConsumer);
    }

}
