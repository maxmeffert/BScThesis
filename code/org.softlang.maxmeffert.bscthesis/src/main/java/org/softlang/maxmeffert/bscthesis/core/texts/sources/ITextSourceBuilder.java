package org.softlang.maxmeffert.bscthesis.core.texts.sources;

import org.softlang.maxmeffert.bscthesis.core.texts.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.core.texts.providers.ITextProvider;

public interface ITextSourceBuilder {
    ITextInterval getTextInterval();
    ITextProvider getTextProvider();
    ITextSourceBuilder withTextInterval(ITextInterval textInterval);
    ITextSourceBuilder withTextProvider(ITextProvider textProvider);
    ITextSource build();
}
