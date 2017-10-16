package org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers;


import org.antlr.v4.runtime.TokenStream;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextIntervalConverter;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.tokensequences.ITokenSequence;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.tokensequences.ITokenSequenceFactory;

import java.util.LinkedList;
import java.util.List;

public class AntlrTokenStreamTextProvider implements ITextProvider {

    private final TokenStream tokenStream;
    private final ITextIntervalConverter textIntervalConverter;
    private final ITokenSequenceFactory tokenSequenceFactory;

    public AntlrTokenStreamTextProvider(TokenStream tokenStream, ITextIntervalConverter textIntervalConverter, ITokenSequenceFactory tokenSequenceFactory) {
        this.tokenStream = tokenStream;
        this.textIntervalConverter = textIntervalConverter;
        this.tokenSequenceFactory = tokenSequenceFactory;
    }

    @Override
    public String getText(ITextInterval textInterval) {
        return tokenStream.getText(textIntervalConverter.toAntlrInterval(textInterval));
    }

    @Override
    public ITokenSequence getTokens(ITextInterval textInterval) {
        return tokenSequenceFactory.newTokenSequence(tokenStream, textInterval);
    }
}
