package org.softlang.maxmeffert.bscthesis.mereologies;

import org.softlang.maxmeffert.bscthesis.graphs.old.IGraph;
import org.softlang.maxmeffert.bscthesis.graphs.old.ReflexiveTransitiveClosure;

public class PartOf<T extends Comparable<T>> extends ReflexiveTransitiveClosure<T> {

    protected PartOf(IGraph<T> graph) {
        super(graph);
    }
}
