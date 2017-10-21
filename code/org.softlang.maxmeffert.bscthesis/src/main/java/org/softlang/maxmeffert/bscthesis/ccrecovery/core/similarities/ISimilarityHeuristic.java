package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;

public interface ISimilarityHeuristic {
    void analyze(ISimilarity similarity, IFragmentAST fragment1, IFragmentAST fragment2);
}
