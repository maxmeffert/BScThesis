package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.analyzers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public interface IFragmentAnalyzer {
    void addHeuristic(IFragmentAnalyzerHeuristic similarityHeuristic);
    IBinaryRelation<IFragment> analyze(IFragment fragment1, IFragment fragment2);
}
