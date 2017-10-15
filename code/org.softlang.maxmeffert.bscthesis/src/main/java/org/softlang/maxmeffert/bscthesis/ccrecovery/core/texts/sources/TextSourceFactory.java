package org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources;

import com.google.inject.Inject;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextIntervalConverterFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextIntervalFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers.ITextProvider;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers.ITextProviderFactory;

public class TextSourceFactory implements ITextSourceFactory {

    private final ITextIntervalConverterFactory textIntervalConverterFactory;
    private final ITextIntervalFactory textIntervalFactory;
    private final ITextProviderFactory textProviderFactory;

    @Inject
    public TextSourceFactory(ITextIntervalConverterFactory textIntervalConverterFactory, ITextIntervalFactory textIntervalFactory, ITextProviderFactory textProviderFactory) {
        this.textIntervalConverterFactory = textIntervalConverterFactory;
        this.textIntervalFactory = textIntervalFactory;
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
        return new TextSource(newTextInterval(parseTree), newTextProvider(tokenStream));
    }
}
