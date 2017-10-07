package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public class CorrespondenceBuilder implements ICorrespondenceBuilder {

    private final ICorrespondenceDefinition correspondenceDefinition;
    private final IFragment fragment1;
    private final IFragment fragment2;

    public CorrespondenceBuilder(ICorrespondenceDefinition correspondenceDefinition, IFragment fragment1, IFragment fragment2) {
        this.correspondenceDefinition = correspondenceDefinition;
        this.fragment1 = fragment1;
        this.fragment2 = fragment2;
    }

    @Override
    public ICorrespondenceDefinition getCorrespondenceDefintion() {
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

    @Override
    public ICorrespondenceBuilder withCorrespondenceDefinition(ICorrespondenceDefinition correspondenceDefinition) {
        return new CorrespondenceBuilder(correspondenceDefinition, fragment1, fragment2);
    }

    @Override
    public ICorrespondenceBuilder withFragment1(IFragment fragment1) {
        return new CorrespondenceBuilder(correspondenceDefinition, fragment1, fragment2);
    }

    @Override
    public ICorrespondenceBuilder withFragment2(IFragment fragment2) {
        return new CorrespondenceBuilder(correspondenceDefinition, fragment1, fragment2);
    }

    @Override
    public ICorrespondence build() {
        return new Correspondence(correspondenceDefinition, fragment1, fragment2);
    }
}
