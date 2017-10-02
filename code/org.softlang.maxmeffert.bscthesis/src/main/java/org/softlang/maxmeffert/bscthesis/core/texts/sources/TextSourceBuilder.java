package org.softlang.maxmeffert.bscthesis.core.texts.sources;

import org.softlang.maxmeffert.bscthesis.core.texts.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.core.texts.providers.ITextProvider;

public class TextSourceBuilder implements ITextSourceBuilder {

    private final ITextInterval textInterval;
    private final ITextProvider textProvider;

    public TextSourceBuilder(ITextInterval textInterval, ITextProvider textProvider) {
        this.textInterval = textInterval;
        this.textProvider = textProvider;
    }

    @Override
    public ITextInterval getTextInterval() {
        return textInterval;
    }

    @Override
    public ITextProvider getTextProvider() {
        return textProvider;
    }

    @Override
    public ITextSourceBuilder withTextInterval(ITextInterval textInterval) {
        return new TextSourceBuilder(textInterval, textProvider);
    }

    @Override
    public ITextSourceBuilder withTextProvider(ITextProvider textProvider) {
        return new TextSourceBuilder(textInterval, textProvider);
    }

    @Override
    public ITextSource build() {
        return new TextSource(textInterval, textProvider);
    }
}
