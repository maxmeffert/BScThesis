package org.softlang.maxmeffert.bscthesis.textsources;

import org.antlr.v4.runtime.misc.Interval;

public interface ITextIntervalConverter {
    ITextInterval fromAntlrInterval(Interval antlrInterval);
    Interval toAntlrInterval(ITextInterval textInterval);
}