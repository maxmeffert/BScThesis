package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;

public interface IFragmentASTAnalyzer {
    void addSimilarityHeuristic(IFragmentASTAnalyzerHeuristic similarityHeuristic);
    IBinaryRelation<IFragmentAST> analyze(IFragmentAST fragment1, IFragmentAST fragment2);
}
