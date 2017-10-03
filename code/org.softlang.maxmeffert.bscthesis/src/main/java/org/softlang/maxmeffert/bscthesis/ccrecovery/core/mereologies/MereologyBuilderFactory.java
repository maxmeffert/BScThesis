package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.IDiGraphBuilderFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.graphs.closures.IDiGraphClosureFactory;

public class MereologyBuilderFactory implements IMereologyBuilderFactory {

    private final IDiGraphClosureFactory diGraphClosureFactory;
    private final IDiGraphBuilderFactory diGraphBuilderFactory;

    @Inject
    public MereologyBuilderFactory(IDiGraphClosureFactory diGraphClosureFactory, IDiGraphBuilderFactory diGraphBuilderFactory) {
        this.diGraphClosureFactory = diGraphClosureFactory;
        this.diGraphBuilderFactory = diGraphBuilderFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IMereologyBuilder<TValue> newMereologyBuilder() {
        return new MereologyBuilder<>(diGraphClosureFactory, diGraphBuilderFactory.<TValue>newDiGraphBuilder());
    }
}
