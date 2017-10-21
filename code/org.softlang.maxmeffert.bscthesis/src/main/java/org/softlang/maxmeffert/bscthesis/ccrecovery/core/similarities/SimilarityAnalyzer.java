package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

import java.util.LinkedList;
import java.util.List;

public class SimilarityAnalyzer implements ISimilarityAnalyzer {

    private final ISimilarityFactory similarityFactory;
    private final List<ISimilarityHeuristic> similarityHeuristics = new LinkedList<>();

    public SimilarityAnalyzer(ISimilarityFactory similarityFactory) {
        this.similarityFactory = similarityFactory;
    }

    @Override
    public void addSimilarityHeuristic(ISimilarityHeuristic similarityHeuristic) {
        similarityHeuristics.add(similarityHeuristic);
    }

    @Override
    public ISimilarity analyze(IFragment fragment1, IFragment fragment2) {
        ISimilarity similarity = similarityFactory.newSimilarity();
        for(ISimilarityHeuristic similarityHeuristic : similarityHeuristics) {
            similarityHeuristic.analyze(similarity, fragment1, fragment2);
        }
        return similarity;
    }
}
