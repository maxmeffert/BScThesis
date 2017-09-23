package org.softlang.maxmeffert.bscthesis.text.sources;

import org.softlang.maxmeffert.bscthesis.text.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.text.providers.ITextProvider;

public interface ITextSourceBuilder {
    ITextInterval getTextInterval();
    ITextProvider getTextProvider();
    ITextSourceBuilder withTextInterval(ITextInterval textInterval);
    ITextSourceBuilder withTextProvider(ITextProvider textProvider);
    ITextSource build();
}
