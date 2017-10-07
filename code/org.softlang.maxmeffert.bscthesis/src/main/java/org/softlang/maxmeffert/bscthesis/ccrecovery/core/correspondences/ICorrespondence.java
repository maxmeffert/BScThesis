package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public interface ICorrespondence {
    ICorrespondenceDefinition getDefinition();
    IFragment getFragment1();
    IFragment getFragment2();
}
