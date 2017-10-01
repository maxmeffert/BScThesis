package org.softlang.maxmeffert.bscthesis.correspondences;

import org.softlang.maxmeffert.bscthesis.fragments.IFragment;

public interface ICorrespondence {
    ICorrespondenceDefinition getDefinition();
    IFragment getFragment1();
    IFragment getFragment2();
}
