package org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public interface ISimilarityAnalyzerStrategy {
    void analyze(ISimilarity similarity, IFragment fragment1, IFragment fragment2);
}
