package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;

import java.io.InputStream;
import java.util.Set;

public interface ICorrespondenceAnalyzer {
    Set<ICorrespondence> analyze(ISimilarity similarity, IFragment fragment1, IFragment fragment2);
}
