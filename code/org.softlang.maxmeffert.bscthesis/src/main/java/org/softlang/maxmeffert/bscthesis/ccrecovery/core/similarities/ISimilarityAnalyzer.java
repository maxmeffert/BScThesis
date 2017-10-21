package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public interface ISimilarityAnalyzer {
    void addSimilarityHeuristic(ISimilarityHeuristic similarityHeuristic);
    ISimilarity analyze(IFragment fragment1, IFragment fragment2);
}
