package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

import com.google.inject.Inject;

public class SimilarityAnalyzerFactory implements ISimilarityAnalyzerFactory {

    private final ISimilarityFactory similarityFactory;

    @Inject
    public SimilarityAnalyzerFactory(ISimilarityFactory similarityFactory) {
        this.similarityFactory = similarityFactory;
    }

    @Override
    public ISimilarityAnalyzer newSimilarityAnalyzer(ISimilarityAnalyzerStrategy similarityAnalyzerStrategy) {
        return new SimilarityAnalyzer(similarityFactory, similarityAnalyzerStrategy);
    }
}
