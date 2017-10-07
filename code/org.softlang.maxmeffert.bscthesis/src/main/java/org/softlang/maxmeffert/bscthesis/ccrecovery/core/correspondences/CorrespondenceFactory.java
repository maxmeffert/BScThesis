package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public class CorrespondenceFactory implements ICorrespondenceFactory {

    private final ICorrespondenceBuilderFactory correspondenceBuilderFactory;

    @Inject
    public CorrespondenceFactory(ICorrespondenceBuilderFactory correspondenceBuilderFactory) {
        this.correspondenceBuilderFactory = correspondenceBuilderFactory;
    }

    @Override
    public ICorrespondence newCorrespondence(ICorrespondenceDefinition correspondenceDefinition, IFragment fragment1, IFragment fragment2) {
        return correspondenceBuilderFactory.newCorrespondenceBuilder()
                .withCorrespondenceDefinition(correspondenceDefinition)
                .withFragment1(fragment1)
                .withFragment2(fragment2)
                .build();
    }
}
