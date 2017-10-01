package org.softlang.maxmeffert.bscthesis.texts.sources;

import org.softlang.maxmeffert.bscthesis.texts.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.texts.providers.ITextProvider;

public interface ITextSource {
    ITextInterval getTextInterval();
    ITextProvider getTextProvider();
    String getText();
}
