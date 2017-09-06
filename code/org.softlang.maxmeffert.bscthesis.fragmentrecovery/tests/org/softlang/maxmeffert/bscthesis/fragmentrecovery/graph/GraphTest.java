package org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph;

import org.junit.jupiter.api.Test;

class GraphTest {

    @Test
    void test() {
        DirectedGraph<Integer> graph = new DirectedGraph<>();
        for (int i=1; i<3;) {
            graph.add(i,++i);
            graph.add(i,++i);
        }


        System.out.println(graph.getMatrix());
        graph.transitiveClosure();
        System.out.println(graph.getMatrix());

    }

}