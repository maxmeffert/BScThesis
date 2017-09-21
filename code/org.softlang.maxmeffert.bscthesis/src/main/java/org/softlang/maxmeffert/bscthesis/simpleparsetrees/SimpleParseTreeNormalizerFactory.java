package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

public class SimpleParseTreeNormalizerFactory implements ISimpleParseTreeNormalizerFactory {
    @Override
    public ISimpleParseTreeNormalizer newSimpleParseTreeNormalizer() {
        return new SimpleParseTreeNormalizer();
    }
}
