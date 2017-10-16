package org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers;

import com.google.inject.Inject;
import org.antlr.v4.runtime.TokenStream;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextIntervalConverterFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.tokensequences.ITokenSequenceFactory;

public class TextProviderFactory implements ITextProviderFactory {

    private final ITextIntervalConverterFactory textIntervalConverterFactory;
    private final ITokenSequenceFactory tokenSequenceFactory;

    @Inject
    public TextProviderFactory(ITextIntervalConverterFactory textIntervalConverterFactory, ITokenSequenceFactory tokenSequenceFactory) {
        this.textIntervalConverterFactory = textIntervalConverterFactory;
        this.tokenSequenceFactory = tokenSequenceFactory;
    }

    @Override
    public ITextProvider newTextProvider(TokenStream tokenStream) {
        return new AntlrTokenStreamTextProvider(tokenStream, textIntervalConverterFactory.newTextIntervalConverter(), tokenSequenceFactory);
    }
}
