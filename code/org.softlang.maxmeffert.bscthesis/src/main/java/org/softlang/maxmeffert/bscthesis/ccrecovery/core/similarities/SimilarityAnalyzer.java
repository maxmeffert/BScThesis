package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public class SimilarityAnalyzer implements ISimilarityAnalyzer {
    private final ISimilarityAnalyzerStrategy similarityAnalyzerStrategy;

    public SimilarityAnalyzer(ISimilarityAnalyzerStrategy similarityAnalyzerStrategy) {
        this.similarityAnalyzerStrategy = similarityAnalyzerStrategy;
    }

    @Override
    public ISimilarity analyze(IFragment fragment1, IFragment fragment2) {
        ISimilarity similarity = new Similarity();
        similarityAnalyzerStrategy.analyze(similarity, fragment1, fragment2);
        return similarity;
    }
}
