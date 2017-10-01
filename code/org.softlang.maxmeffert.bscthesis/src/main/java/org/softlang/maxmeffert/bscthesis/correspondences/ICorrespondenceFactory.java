package org.softlang.maxmeffert.bscthesis.correspondences;

import org.softlang.maxmeffert.bscthesis.fragments.IFragment;

public interface ICorrespondenceFactory {
    ICorrespondence newCorrespondence(ICorrespondenceDefinition correspondenceDefinition, IFragment fragment1, IFragment fragment2);
}
