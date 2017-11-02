package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.binaryrelations.IBinaryRelation;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public interface ICorrespondenceAnalyzer {
    IBinaryRelation<IFragment> analyzeWeakCorrespondences(IBinaryRelation<IFragment> similarity, IFragment fragment1, IFragment fragment2);
    IBinaryRelation<IFragment> analyzeStrictCorrespondences(IBinaryRelation<IFragment> similarity, IFragment fragment1, IFragment fragment2);
}
