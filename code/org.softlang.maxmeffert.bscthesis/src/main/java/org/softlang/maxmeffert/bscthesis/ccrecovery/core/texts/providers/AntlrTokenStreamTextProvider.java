package org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers;


import org.antlr.v4.runtime.TokenStream;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextIntervalConverter;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextInterval;

import java.util.LinkedList;
import java.util.List;

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

    @Override
    public List<String> getTokens(ITextInterval textInterval) {
        List<String> tokens = new LinkedList<>();
        if (textInterval.getStartPosition() == textInterval.getEndPosition()) {
            tokens.add(getText(textInterval));
            return tokens;
        }
        if (0 <= textInterval.getStartPosition() && textInterval.getEndPosition() <= tokenStream.size()) {
            for (int i=textInterval.getStartPosition(); i < textInterval.getEndPosition(); i++) {
                tokens.add(tokenStream.get(i).getText());
            }
        }
        return tokens;
    }
}
