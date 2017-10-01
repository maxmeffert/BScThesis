package org.softlang.maxmeffert.bscthesis.texts.intervals;

import org.antlr.v4.runtime.misc.Interval;
import org.softlang.maxmeffert.bscthesis.antlr.IAntlrIntervalFactory;

public class TextIntervalConverter implements ITextIntervalConverter {

    private final ITextIntervalFactory textIntervalFactory;
    private final IAntlrIntervalFactory antlrIntervalFactory;

    public TextIntervalConverter(ITextIntervalFactory textIntervalFactory, IAntlrIntervalFactory antlrIntervalFactory) {
        this.textIntervalFactory = textIntervalFactory;
        this.antlrIntervalFactory = antlrIntervalFactory;
    }

    @Override
    public ITextInterval fromAntlrInterval(Interval antlrInterval) {
        return textIntervalFactory.newTextInterval(antlrInterval.a, antlrInterval.b);
    }

    @Override
    public Interval toAntlrInterval(ITextInterval textInterval) {
        return antlrIntervalFactory.newInterval(textInterval.getStartPosition(), textInterval.getStopPosition());
    }
}
