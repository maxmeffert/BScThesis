package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.trees.ITreeFactory;

public class SimpleParseTreeNormalizerFactory implements ISimpleParseTreeNormalizerFactory {

    private final ITreeFactory treeFactory;

    @Inject
    public SimpleParseTreeNormalizerFactory(ITreeFactory treeFactory) {
        this.treeFactory = treeFactory;
    }

    @Override
    public ISimpleParseTreeNormalizer newSimpleParseTreeNormalizer() {
        return new SimpleParseTreeNormalizer(treeFactory);
    }
}
