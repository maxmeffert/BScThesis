package org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.tokensequences.ITokenSequence;

public interface ITextProvider {
    String getText(ITextInterval textInterval);
    ITokenSequence getTokens(ITextInterval textInterval);
}
