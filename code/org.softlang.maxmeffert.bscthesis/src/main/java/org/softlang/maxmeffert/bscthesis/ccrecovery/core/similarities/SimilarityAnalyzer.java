package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public class SimilarityAnalyzer implements ISimilarityAnalyzer {

    private final ISimilarityFactory similarityFactory;
    private final ISimilarityHeuristic similarityHeuristic;

    public SimilarityAnalyzer(ISimilarityFactory similarityFactory, ISimilarityHeuristic similarityAnalyzerStrategy) {
        this.similarityFactory = similarityFactory;
        this.similarityHeuristic = similarityAnalyzerStrategy;
    }

    @Override
    public ISimilarity analyze(IFragment fragment1, IFragment fragment2) {
        ISimilarity similarity = similarityFactory.newSimilarity();
        similarityHeuristic.analyze(similarity, fragment1, fragment2);
        return similarity;
    }
}
