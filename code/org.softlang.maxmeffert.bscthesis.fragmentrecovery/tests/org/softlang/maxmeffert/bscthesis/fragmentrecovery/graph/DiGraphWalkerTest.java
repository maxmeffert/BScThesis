package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import com.google.common.collect.Iterables;
import com.google.common.collect.Streams;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

class DiGraphWalkerTest {

    void closure(IDiGraph<Integer> diGraph, int source, int target) {
        System.out.println(source + "," + target);
        diGraph.add(source, target);
        for(int targetOfTarget : diGraph.getTargetsOf(target)) {
            if (!diGraph.getTargetsOf(targetOfTarget).contains(source)) {
                closure(diGraph, targetOfTarget, source);
            }
        }
    }

    @Test
    void test() {

        DiGraph<Integer> diGraph = new DiGraph<>();
        diGraph.add(1,2);
        diGraph.add(2,3);

        DiGraphWalker<Integer> walker = new DiGraphWalker<>();

//        diGraph.getVertices().forEach(vertex -> closure(diGraph, vertex, vertex));

        diGraph.closure();

        walker.walk(diGraph, 1, source -> {
            for (int target : diGraph.getTargetsOf(source)) {
                System.out.println(source + " -> " + target);
            }
        });
    }

}