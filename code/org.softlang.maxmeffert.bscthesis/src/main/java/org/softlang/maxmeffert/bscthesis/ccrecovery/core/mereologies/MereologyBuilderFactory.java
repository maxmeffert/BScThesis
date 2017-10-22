package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelationFactory;

public class MereologyBuilderFactory implements IMereologyBuilderFactory {

    private final IBinaryRelationFactory binaryRelationFactory;

    @Inject
    public MereologyBuilderFactory(IBinaryRelationFactory binaryRelationFactory) {
        this.binaryRelationFactory = binaryRelationFactory;
    }

    @Override
    public <TValue extends Comparable<TValue>> IMereologyBuilder<TValue> newMereologyBuilder() {
        return new MereologyBuilder<>(binaryRelationFactory.<TValue>newBinaryRelation());
    }
}
