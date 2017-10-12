package org.softlang.maxmeffert.bscthesis.ccrecovery.core.correspondences;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;

public class CorrespondenceDefinitionBuilderFactory implements ICorrespondenceDefinitionBuilderFactory {

    private final ICollectionFactory collectionFactory;

    @Inject
    public CorrespondenceDefinitionBuilderFactory(ICollectionFactory collectionFactory) {
        this.collectionFactory = collectionFactory;
    }

    @Override
    public ICorrespondenceDefinitionBuilder newCorrespondenceDefinitionBuilder() {
        return new CorrespondenceDefinitionBuilder(null, null, collectionFactory.newList());
    }
}
