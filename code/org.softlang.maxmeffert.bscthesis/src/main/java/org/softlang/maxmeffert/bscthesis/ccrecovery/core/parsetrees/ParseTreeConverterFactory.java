package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees;

import com.google.inject.Inject;

public class ParseTreeConverterFactory implements IParseTreeConverterFactory {

    private final IParseTreeFactory parseTreeFactory;
    private final IParseTreeNormalizerFactory parseTreeNormalizerFactory;

    @Inject
    public ParseTreeConverterFactory(IParseTreeFactory parseTreeFactory, IParseTreeNormalizerFactory parseTreeNormalizerFactory) {
        this.parseTreeFactory = parseTreeFactory;
        this.parseTreeNormalizerFactory = parseTreeNormalizerFactory;
    }

    @Override
    public IParseTreeConverter newParseTreeConverter() {
        return new ParseTreeConverter(parseTreeFactory, parseTreeNormalizerFactory);
    }
}
