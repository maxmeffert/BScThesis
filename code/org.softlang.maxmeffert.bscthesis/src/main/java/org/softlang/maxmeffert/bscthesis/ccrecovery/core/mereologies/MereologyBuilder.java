package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.IDiGraph;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.IDiGraphBuilder;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.closures.IDiGraphClosureFactory;

public class MereologyBuilder<TValue extends Comparable<TValue>> implements IMereologyBuilder<TValue> {

    private final IDiGraphClosureFactory diGraphClosureFactory;
    private final IDiGraphBuilder<TValue> diGraphBuilder;

    public MereologyBuilder(IDiGraphClosureFactory diGraphClosureFactory, IDiGraphBuilder<TValue> diGraphBuilder) {
        this.diGraphClosureFactory = diGraphClosureFactory;
        this.diGraphBuilder = diGraphBuilder;
    }

    @Override
    public IMereologyBuilder<TValue> partOf(TValue part, TValue fusion) {
        return new MereologyBuilder<>(diGraphClosureFactory, diGraphBuilder.withEdge(part, fusion));
    }

    private IDiGraph<TValue> buildDiGraph() {
        return diGraphClosureFactory.reflexiveTransitiveDiGraphClosureOf(diGraphBuilder.build());
    }

    @Override
    public IMereology<TValue> build() {
        return new Mereology<>(buildDiGraph());
    }
}
