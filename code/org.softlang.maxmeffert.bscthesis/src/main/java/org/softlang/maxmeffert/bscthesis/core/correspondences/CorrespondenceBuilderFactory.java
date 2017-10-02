package org.softlang.maxmeffert.bscthesis.core.correspondences;

public class CorrespondenceBuilderFactory implements ICorrespondenceBuilderFactory {
    @Override
    public ICorrespondenceBuilder newCorrespondenceBuilder() {
        return new CorrespondenceBuilder(null, null, null);
    }
}
