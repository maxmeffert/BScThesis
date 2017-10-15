package org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources;

import com.google.inject.Inject;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextIntervalConverterFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers.ITextProvider;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers.ITextProviderFactory;

public class TextSourceFactory implements ITextSourceFactory {

    private final ITextSourceBuilderFactory textSourceBuilderFactory;
    private final ITextIntervalConverterFactory textIntervalConverterFactory;
    private final ITextProviderFactory textProviderFactory;

    @Inject
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

    private ITextProvider newTextProvider(CharStream charStream) {
        return textProviderFactory.newTextProvider(charStream);
    }

    @Override
    public ITextSource newTextSource(CharStream charStream, ParseTree parseTree) {
        return textSourceBuilderFactory.newSourceInfoBuilder()
                .withTextInterval(newTextInterval(parseTree))
                .withTextProvider(newTextProvider(charStream))
                .build();
    }

    @Override
    public ITextSource newTextSource(TokenStream tokenStream, ParseTree parseTree) {
        return textSourceBuilderFactory.newSourceInfoBuilder()
                .withTextInterval(newTextInterval(parseTree))
                .withTextProvider(newTextProvider(tokenStream))
                .build();
    }
}
