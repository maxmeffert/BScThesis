package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.digraphs.IDiGraphFactory;

public class SimilarityFactory implements ISimilarityFactory {

    private final IDiGraphFactory diGraphFactory;

    @Inject
    public SimilarityFactory(IDiGraphFactory diGraphFactory) {
        this.diGraphFactory = diGraphFactory;
    }


    @Override
    public ISimilarity newSimilarity() {
        return new Similarity(diGraphFactory.newDiGraph());
    }
}
