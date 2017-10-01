package org.softlang.maxmeffert.bscthesis.texts.providers;


import org.antlr.v4.runtime.TokenStream;
import org.softlang.maxmeffert.bscthesis.texts.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.texts.intervals.ITextIntervalConverter;

public class AntlrTokenStreamTextProvider implements ITextProvider {

    private final TokenStream tokenStream;
    private final ITextIntervalConverter textIntervalConverter;

    public AntlrTokenStreamTextProvider(TokenStream tokenStream, ITextIntervalConverter textIntervalConverter) {
        this.tokenStream = tokenStream;
        this.textIntervalConverter = textIntervalConverter;
    }

    @Override
    public String getText(ITextInterval textInterval) {
        return tokenStream.getText(textIntervalConverter.toAntlrInterval(textInterval));
    }
}
