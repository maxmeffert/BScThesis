package org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs.IDiGraphFactory;

public class BinaryRelationFactory implements IBinaryRelationFactory {

    private final IDiGraphFactory diGraphFactory;

    @Inject
    public BinaryRelationFactory(IDiGraphFactory diGraphFactory) {
        this.diGraphFactory = diGraphFactory;
    }

    @Override
    public <T extends Comparable<T>> IBinaryRelation<T> newBinaryRelation() {
        return new BinaryRelation<>(diGraphFactory.<T>newDiGraph());
    }
}
