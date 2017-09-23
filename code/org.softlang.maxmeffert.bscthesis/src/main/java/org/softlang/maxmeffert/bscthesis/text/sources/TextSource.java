package org.softlang.maxmeffert.bscthesis.text.sources;

import org.softlang.maxmeffert.bscthesis.text.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.text.providers.ITextProvider;

public class TextSource implements ITextSource {

    private final ITextInterval textInterval;
    private final ITextProvider textProvider;

    public TextSource(ITextInterval textInterval, ITextProvider textProvider) {
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
    public String getText() {
        return getTextProvider().getText(getTextInterval());
    }

    @Override
    public String toString() {
        return getText();
    }
}
