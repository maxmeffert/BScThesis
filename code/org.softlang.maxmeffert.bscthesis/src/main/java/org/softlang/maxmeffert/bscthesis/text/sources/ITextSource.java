package org.softlang.maxmeffert.bscthesis.text.sources;

import org.softlang.maxmeffert.bscthesis.text.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.text.providers.ITextProvider;

public interface ITextSource {
    ITextInterval getTextInterval();
    ITextProvider getTextProvider();
    String getText();
}
