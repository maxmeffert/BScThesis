package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelationFactory;

public class SimilarityAnalyzerFactory implements ISimilarityAnalyzerFactory {

    private final IBinaryRelationFactory binaryRelationFactory;

    @Inject
    public SimilarityAnalyzerFactory(IBinaryRelationFactory binaryRelationFactory) {
        this.binaryRelationFactory = binaryRelationFactory;
    }

    @Override
    public ISimilarityAnalyzer newSimilarityAnalyzer() {
        return new SimilarityAnalyzer(binaryRelationFactory);
    }
}
