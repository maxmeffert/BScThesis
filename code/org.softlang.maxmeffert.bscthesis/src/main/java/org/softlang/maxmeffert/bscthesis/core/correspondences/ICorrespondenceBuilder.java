package org.softlang.maxmeffert.bscthesis.core.correspondences;

import org.softlang.maxmeffert.bscthesis.core.fragments.IFragment;

public interface ICorrespondenceBuilder {
    ICorrespondenceDefinition getCorrespondenceDefintion();
    IFragment getFragment1();
    IFragment getFragment2();
    ICorrespondenceBuilder withCorrespondenceDefinition(ICorrespondenceDefinition correspondenceDefinition);
    ICorrespondenceBuilder withFragment1(IFragment fragment1);
    ICorrespondenceBuilder withFragment2(IFragment fragment2);
    ICorrespondence build();
}
