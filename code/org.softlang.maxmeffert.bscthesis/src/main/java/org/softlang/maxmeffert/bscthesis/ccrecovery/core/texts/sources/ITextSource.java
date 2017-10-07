package org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers.ITextProvider;

public interface ITextSource extends Comparable<ITextSource> {
    ITextInterval getTextInterval();
    ITextProvider getTextProvider();
    String getText();
}
