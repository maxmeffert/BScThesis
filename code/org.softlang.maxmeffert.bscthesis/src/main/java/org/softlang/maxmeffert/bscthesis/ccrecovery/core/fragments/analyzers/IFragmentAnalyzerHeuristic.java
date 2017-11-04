package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.analyzers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public interface IFragmentAnalyzerHeuristic {
    void analyze(IBinaryRelation<IFragment> similarities, IFragment fragment1, IFragment fragment2);
}
