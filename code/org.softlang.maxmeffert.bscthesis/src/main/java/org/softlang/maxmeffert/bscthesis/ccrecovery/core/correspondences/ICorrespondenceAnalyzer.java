package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;

import java.util.Set;

public interface ICorrespondenceAnalyzer {
    Set<ICorrespondence> analyze(ISimilarity similarity, IFragmentAST fragment1, IFragmentAST fragment2);
}
