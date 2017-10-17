package org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextInterval;

public interface ITextProvider {
    String getText(ITextInterval textInterval);
}
