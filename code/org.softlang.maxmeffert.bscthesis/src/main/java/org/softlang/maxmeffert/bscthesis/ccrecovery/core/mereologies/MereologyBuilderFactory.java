package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.IDiGraphFactory;

public class MereologyBuilderFactory implements IMereologyBuilderFactory {

    private final IDiGraphFactory diGraphFactory;

    public MereologyBuilderFactory(IDiGraphFactory diGraphFactory) {
        this.diGraphFactory = diGraphFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IMereologyBuilder<TValue> newMereologyBuilder() {
        return new MereologyBuilder<>(diGraphFactory.<TValue>newDiGraph());
    }
}
