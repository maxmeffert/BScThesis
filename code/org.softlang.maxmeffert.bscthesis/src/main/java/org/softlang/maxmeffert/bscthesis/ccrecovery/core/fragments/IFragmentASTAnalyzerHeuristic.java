package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;

public interface IFragmentASTAnalyzerHeuristic {
    void analyze(IBinaryRelation<IFragmentAST> similarity, IFragmentAST fragment1, IFragmentAST fragment2);
}
