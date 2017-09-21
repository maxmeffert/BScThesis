package org.softlang.maxmeffert.bscthesis.textsources;

public interface ITextSourceBuilder {
    ITextInterval getTextInterval();
    ITextProvider getTextProvider();
    ITextSourceBuilder withTextInterval(ITextInterval textInterval);
    ITextSourceBuilder withTextProvider(ITextProvider textProvider);
    ITextSource build();
}
