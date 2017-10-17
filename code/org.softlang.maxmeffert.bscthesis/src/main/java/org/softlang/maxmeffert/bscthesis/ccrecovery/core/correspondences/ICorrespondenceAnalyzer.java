package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.similarities.ISimilarity;

import java.io.InputStream;
import java.util.Set;

public interface ICorrespondenceAnalyzer {
    @Deprecated
    Set<ICorrespondence> analyze(ICorrespondenceDefinition correspondenceDefinition, InputStream artifact1, InputStream artifact2) throws Exception;
    Set<ICorrespondence> analyze(ISimilarity similarity, IFragment fragment1, IFragment fragment2);
}
