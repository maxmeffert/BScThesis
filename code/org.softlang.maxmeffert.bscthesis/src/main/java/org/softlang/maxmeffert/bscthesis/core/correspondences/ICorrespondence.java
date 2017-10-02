package org.softlang.maxmeffert.bscthesis.core.correspondences;

import org.softlang.maxmeffert.bscthesis.core.fragments.IFragment;

public interface ICorrespondence {
    ICorrespondenceDefinition getDefinition();
    IFragment getFragment1();
    IFragment getFragment2();
}
