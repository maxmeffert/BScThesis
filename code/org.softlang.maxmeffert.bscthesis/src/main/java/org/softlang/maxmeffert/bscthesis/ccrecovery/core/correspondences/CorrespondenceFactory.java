package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public class CorrespondenceFactory implements ICorrespondenceFactory {


    @Override
    public ICorrespondence newCorrespondence(IFragment fragment1, IFragment fragment2) {
        return new Correspondence(fragment1, fragment2);
    }
}
