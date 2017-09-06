package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

public class DiGraphs {

    private static <T extends Comparable<T>> DiGraph.Builder<T> copyBuilderOf(DiGraph<T> diGraph) {
        DiGraph.Builder<T> builder = DiGraph.Builder.get();
        diGraph.getVertices().forEach(vertex -> {
            for (T target : diGraph.getTargetsOf(vertex)) {
                builder.add(vertex, target);
            }
        });
        return builder;
    }

    public static <T extends Comparable<T>> DiGraph<T> copyOf(DiGraph<T> diGraph) {
        return copyBuilderOf(diGraph).build();
    }

    private static <T extends Comparable<T>> DiGraph.Builder<T> transitiveClosureBuilderOf(DiGraph<T> diGraph) {
        DiGraph.Builder<T> builder = copyBuilderOf(diGraph);
        DiGraphWalker<T> walker = new DiGraphWalker<>();
        diGraph.getVertices().forEach(vertex -> {
            walker.walkDepthFirst((IGraph<T>) diGraph, vertex, v -> {
                if (!diGraph.getTargetsOf(v).contains(vertex)) {
                    builder.add(vertex, v);
                }
            });
        });
        return builder;
    }

    public static <T extends Comparable<T>> DiGraph<T> transitiveClosureOf(DiGraph<T> diGraph) {
        return transitiveClosureBuilderOf(diGraph).build();
    }

}
