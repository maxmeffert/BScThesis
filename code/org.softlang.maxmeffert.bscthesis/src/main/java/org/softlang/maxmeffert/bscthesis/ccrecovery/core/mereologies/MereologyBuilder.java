package org.softlang.maxmeffert.bscthesis.ccrecovery.core.mereologies;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;

public class MereologyBuilder<TValue extends Comparable<TValue>> implements IMereologyBuilder<TValue> {

    private final IBinaryRelation<TValue> binaryRelation;

    public MereologyBuilder(IBinaryRelation<TValue> binaryRelation) {
        this.binaryRelation = binaryRelation;
    }


    @Override
    public IMereologyBuilder<TValue> partOf(TValue part, TValue fusion) {
        binaryRelation.add(part, fusion);
        return new MereologyBuilder<>(binaryRelation.getCopy());
    }

    @Override
    public IMereology<TValue> build() {
        return new Mereology<>(binaryRelation.getReflexiveTransitiveClosure());
    }
}
