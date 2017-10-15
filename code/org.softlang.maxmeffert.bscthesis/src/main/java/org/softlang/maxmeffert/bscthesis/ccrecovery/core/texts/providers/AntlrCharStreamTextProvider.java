package org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers;

import org.antlr.v4.runtime.CharStream;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextIntervalConverter;

public class AntlrCharStreamTextProvider implements ITextProvider {

    private final CharStream charStream;
    private final ITextIntervalConverter textIntervalConverter;

    public AntlrCharStreamTextProvider(CharStream charStream, ITextIntervalConverter textIntervalConverter) {
        this.charStream = charStream;
        this.textIntervalConverter = textIntervalConverter;
    }

    @Override
    public String getText(ITextInterval textInterval) {
        return charStream.getText(textIntervalConverter.toAntlrInterval(textInterval));
    }
}
