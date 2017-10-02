package org.softlang.maxmeffert.bscthesis.core.texts.sources;

import org.softlang.maxmeffert.bscthesis.core.texts.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.core.texts.providers.ITextProvider;

public interface ITextSource extends Comparable<ITextSource> {
    ITextInterval getTextInterval();
    ITextProvider getTextProvider();
    String getText();
}
