package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;

public interface ISimilarityAnalyzer {
    void addSimilarityHeuristic(ISimilarityHeuristic similarityHeuristic);
    IBinaryRelation<IFragmentAST> analyze(IFragmentAST fragment1, IFragmentAST fragment2);
}
