package org.softlang.maxmeffert.bscthesis.graphs;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.Test;
import org.softlang.maxmeffert.bscthesis.collections.CollectionFactory;
import org.softlang.maxmeffert.bscthesis.graphs.walkers.DepthFirstSearchGraphWalker;
import org.softlang.maxmeffert.bscthesis.graphs.walkers.IGraphWalkerListener;
import org.softlang.maxmeffert.bscthesis.ioc.IoCGuiceModule;

class DiGraphBuilderTest {

    @Test
    void test() {

        Injector injector = Guice.createInjector(new IoCGuiceModule());

        IDiGraph<Integer,String> diGraph = injector.getInstance(IDiGraphBuilderFactory.class)
                .<Integer,String>newDiGraphBuilder()
                .withEdge(1,2,"partOf")
                .withEdge(2,3,"partOf")
                .withEdge(2,3,"partOf")
                .withEdge(4,1,"partOf")
                .build();

        System.out.println(diGraph.getAdjacentEdgesOf(2));

        new DepthFirstSearchGraphWalker<Integer,String>(new CollectionFactory()).walk(diGraph, 1, new IGraphWalkerListener<Integer>() {
            @Override
            public void enter(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void exit(Integer integer) {

            }
        });
    }

}