package org.softlang.maxmeffert.bscthesis.textsources;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class TextSourceFactory implements ITextSourceFactory {

    private final ITextSourceBuilderFactory textSourceBuilderFactory;
    private final ITextIntervalConverterFactory textIntervalConverterFactory;
    private final ITextProviderFactory textProviderFactory;

    public TextSourceFactory(ITextSourceBuilderFactory textSourceBuilderFactory, ITextIntervalConverterFactory textIntervalConverterFactory, ITextProviderFactory textProviderFactory) {
        this.textSourceBuilderFactory = textSourceBuilderFactory;
        this.textIntervalConverterFactory = textIntervalConverterFactory;
        this.textProviderFactory = textProviderFactory;
    }

    private ITextInterval newTextInterval(ParseTree parseTree) {
        return textIntervalConverterFactory.newTextIntervalConverter()
                .fromAntlrInterval(parseTree.getSourceInterval());
    }

    private ITextProvider newTextProvider(TokenStream tokenStream) {
        return textProviderFactory.newTextProvider(tokenStream);
    }

    @Override
    public ITextSource newTextSource(TokenStream tokenStream, ParseTree parseTree) {
        return textSourceBuilderFactory.newSourceInfoBuilder()
                .withTextInterval(newTextInterval(parseTree))
                .withTextProvider(newTextProvider(tokenStream))
                .build();
    }
}
