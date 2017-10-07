package org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers;


import org.antlr.v4.runtime.TokenStream;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextIntervalConverter;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextInterval;

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
