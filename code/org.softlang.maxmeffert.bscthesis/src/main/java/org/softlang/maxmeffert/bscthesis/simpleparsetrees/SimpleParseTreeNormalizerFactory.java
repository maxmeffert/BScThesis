package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.trees.ITreeFactory;
import org.softlang.maxmeffert.bscthesis.utils.IStringUtils;

public class SimpleParseTreeNormalizerFactory implements ISimpleParseTreeNormalizerFactory {

    private final ITreeFactory treeFactory;
    private final ICollectionFactory collectionFactory;
    private final IStringUtils stringUtils;

    @Inject
    public SimpleParseTreeNormalizerFactory(ITreeFactory treeFactory, ICollectionFactory collectionFactory, IStringUtils stringUtils) {
        this.treeFactory = treeFactory;
        this.collectionFactory = collectionFactory;
        this.stringUtils = stringUtils;
    }

    @Override
    public ISimpleParseTreeNormalizer newSimpleParseTreeNormalizer() {
        return new SimpleParseTreeNormalizer(treeFactory, collectionFactory, stringUtils);
    }
}
