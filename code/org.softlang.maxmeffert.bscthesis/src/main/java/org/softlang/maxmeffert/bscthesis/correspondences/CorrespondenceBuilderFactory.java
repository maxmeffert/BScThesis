package org.softlang.maxmeffert.bscthesis.correspondences;

public class CorrespondenceBuilderFactory implements ICorrespondenceBuilderFactory {
    @Override
    public ICorrespondenceBuilder newCorrespondenceBuilder() {
        return new CorrespondenceBuilder(null, null, null);
    }
}
