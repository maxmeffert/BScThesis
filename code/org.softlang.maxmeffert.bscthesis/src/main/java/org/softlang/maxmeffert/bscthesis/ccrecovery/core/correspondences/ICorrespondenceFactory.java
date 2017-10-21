package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public interface ICorrespondenceFactory {
    ICorrespondence newCorrespondence(IFragment fragment1, IFragment fragment2);
}
