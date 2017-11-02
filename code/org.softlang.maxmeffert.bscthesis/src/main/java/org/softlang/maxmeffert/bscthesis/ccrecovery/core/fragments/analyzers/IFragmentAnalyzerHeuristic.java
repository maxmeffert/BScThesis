package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.analyzers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentAST;

public interface IFragmentAnalyzerHeuristic {
    void analyze(IBinaryRelation<IFragmentAST> similarity, IFragmentAST fragment1, IFragmentAST fragment2);
}
