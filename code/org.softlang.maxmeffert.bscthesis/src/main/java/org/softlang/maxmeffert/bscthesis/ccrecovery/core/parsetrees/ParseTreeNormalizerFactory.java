package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITreeFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.strings.IStringUtils;

public class ParseTreeNormalizerFactory implements IParseTreeNormalizerFactory {

    private final IParseTreeFactory parseTreeFactory;
    private final ICollectionFactory collectionFactory;
    private final IStringUtils stringUtils;

    @Inject
    public ParseTreeNormalizerFactory(IParseTreeFactory parseTreeFactory, ICollectionFactory collectionFactory, IStringUtils stringUtils) {
        this.parseTreeFactory = parseTreeFactory;
        this.collectionFactory = collectionFactory;
        this.stringUtils = stringUtils;
    }

    @Override
    public IParseTreeNormalizer newSimpleParseTreeNormalizer() {
        return new ParseTreeNormalizer(parseTreeFactory, collectionFactory, stringUtils);
    }
}
