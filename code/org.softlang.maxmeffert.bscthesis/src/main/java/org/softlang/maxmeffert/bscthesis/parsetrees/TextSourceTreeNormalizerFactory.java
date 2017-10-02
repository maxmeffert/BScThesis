package org.softlang.maxmeffert.bscthesis.parsetrees;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.utils.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.trees.ITreeFactory;
import org.softlang.maxmeffert.bscthesis.utils.IStringUtils;

public class TextSourceTreeNormalizerFactory implements ITextSourceTreeNormalizerFactory {

    private final ITreeFactory treeFactory;
    private final ICollectionFactory collectionFactory;
    private final IStringUtils stringUtils;

    @Inject
    public TextSourceTreeNormalizerFactory(ITreeFactory treeFactory, ICollectionFactory collectionFactory, IStringUtils stringUtils) {
        this.treeFactory = treeFactory;
        this.collectionFactory = collectionFactory;
        this.stringUtils = stringUtils;
    }

    @Override
    public ITextSourceTreeNormalizer newSimpleParseTreeNormalizer() {
        return new TextSourceTreeNormalizer(treeFactory, collectionFactory, stringUtils);
    }
}
