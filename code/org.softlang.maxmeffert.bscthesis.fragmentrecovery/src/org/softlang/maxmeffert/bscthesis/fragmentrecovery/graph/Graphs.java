package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import java.util.function.Supplier;

public class Graphs {

    public static <T extends Comparable<T>, G extends IGraph<T>> IGraphBuilder<T,G> copyBuilderOf(IGraph<T> graph, Supplier<IGraphBuilder<T,G>> supplier) {
        IGraphBuilder<T,G> builder = supplier.get();
        builder.add(graph.getEdges());
        return builder;
    }

    public static <T extends Comparable<T>, G extends IGraph<T>> G copyOf(IGraph<T> graph, Supplier<IGraphBuilder<T,G>> supplier) {
        return copyBuilderOf(graph, supplier).build();
    }

    private static <T extends Comparable<T>, G extends IGraph<T>> IGraphBuilder<T,G> transitiveClosureBuilderOf(IGraph<T> graph, Supplier<IGraphBuilder<T,G>> supplier) {
        IGraphBuilder<T,G> builder = copyBuilderOf(graph, supplier);
        graph.getVertices().forEach(vertex -> {
            GraphWalker.<T>get().walkDepthFirst(graph, vertex, v -> {
                if (!graph.getAdjacentVerticesOf(v).contains(vertex)) {
                    builder.add(vertex, v);
                }
            });
        });
        return builder;
    }

    public static <T extends Comparable<T>, G extends IGraph<T>> G transitiveClosureOf(IGraph<T> graph, Supplier<IGraphBuilder<T,G>> supplier) {
        return transitiveClosureBuilderOf(graph, supplier).build();
    }

}
