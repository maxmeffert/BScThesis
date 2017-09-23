package org.softlang.maxmeffert.bscthesis.text.providers;

import com.google.inject.Inject;
import org.antlr.v4.runtime.TokenStream;
import org.softlang.maxmeffert.bscthesis.text.intervals.ITextIntervalConverterFactory;
import org.softlang.maxmeffert.bscthesis.text.providers.AntlrTokenStreamTextProvider;
import org.softlang.maxmeffert.bscthesis.text.providers.ITextProvider;
import org.softlang.maxmeffert.bscthesis.text.providers.ITextProviderFactory;

public class TextProviderFactory implements ITextProviderFactory {

    private final ITextIntervalConverterFactory textIntervalConverterFactory;

    @Inject
    public TextProviderFactory(ITextIntervalConverterFactory textIntervalConverterFactory) {
        this.textIntervalConverterFactory = textIntervalConverterFactory;
    }


    @Override
    public ITextProvider newTextProvider(TokenStream tokenStream) {
        return new AntlrTokenStreamTextProvider(tokenStream, textIntervalConverterFactory.newTextIntervalConverter());
    }
}
