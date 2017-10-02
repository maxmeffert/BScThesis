package org.softlang.maxmeffert.bscthesis.core.correspondences;

import org.softlang.maxmeffert.bscthesis.core.fragments.IFragment;

public interface ICorrespondenceFactory {
    ICorrespondence newCorrespondence(ICorrespondenceDefinition correspondenceDefinition, IFragment fragment1, IFragment fragment2);
}
