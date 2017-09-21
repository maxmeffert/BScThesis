package org.softlang.maxmeffert.bscthesis.textsources;

import com.google.inject.Inject;
import org.antlr.v4.runtime.TokenStream;

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
