package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public interface ISimilarityAnalyzer {
    ISimilarity analyze(IFragment fragment1, IFragment fragment2);
}
