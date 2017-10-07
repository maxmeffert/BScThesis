package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public class Correspondence implements ICorrespondence {

    private final ICorrespondenceDefinition correspondenceDefinition;
    private final IFragment fragment1;
    private final IFragment fragment2;

    public Correspondence(ICorrespondenceDefinition correspondenceDefinition, IFragment fragment1, IFragment fragment2) {
        this.correspondenceDefinition = correspondenceDefinition;
        this.fragment1 = fragment1;
        this.fragment2 = fragment2;
    }

    @Override
    public ICorrespondenceDefinition getDefinition() {
        return correspondenceDefinition;
    }

    @Override
    public IFragment getFragment1() {
        return fragment1;
    }

    @Override
    public IFragment getFragment2() {
        return fragment2;
    }
}
