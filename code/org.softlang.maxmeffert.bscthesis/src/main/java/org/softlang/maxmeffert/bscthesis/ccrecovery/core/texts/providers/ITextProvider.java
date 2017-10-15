package org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers;

import org.antlr.v4.runtime.Token;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextInterval;

import java.util.List;

public interface ITextProvider {
    String getText(ITextInterval textInterval);
    List<String> getTokens(ITextInterval textInterval);
}
