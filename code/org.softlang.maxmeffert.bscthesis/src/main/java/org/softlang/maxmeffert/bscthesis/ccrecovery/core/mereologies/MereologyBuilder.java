package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.IDiGraph;

public class MereologyBuilder<TValue extends Comparable<TValue>> implements IMereologyBuilder<TValue> {

    private final IDiGraph<TValue> diGraph;

    public MereologyBuilder(IDiGraph<TValue> diGraph) {
        this.diGraph = diGraph;
    }


    @Override
    public IMereologyBuilder<TValue> partOf(TValue part, TValue fusion) {
        diGraph.addEdge(part, fusion);
        return new MereologyBuilder<>(diGraph.getCopy());
    }

    @Override
    public IMereology<TValue> build() {
        return new Mereology<>(diGraph.getReflexiveTransitiveClosure());
    }
}
