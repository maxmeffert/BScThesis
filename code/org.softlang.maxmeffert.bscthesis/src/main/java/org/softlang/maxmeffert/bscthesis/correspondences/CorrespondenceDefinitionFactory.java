package org.softlang.maxmeffert.bscthesis.correspondences;

public class CorrespondenceDefinitionFactory implements ICorrespondenceDefinitionFactory {

    private final ICorrespondenceDefinitionBuilderFactory correspondenceDefinitionBuilderFactory;

    public CorrespondenceDefinitionFactory(ICorrespondenceDefinitionBuilderFactory correspondenceDefinitionBuilderFactory) {
        this.correspondenceDefinitionBuilderFactory = correspondenceDefinitionBuilderFactory;
    }

    @Override
    public ICorrespondenceDefinition newCorrespondenceDefinition() {
        return null;
    }
}
