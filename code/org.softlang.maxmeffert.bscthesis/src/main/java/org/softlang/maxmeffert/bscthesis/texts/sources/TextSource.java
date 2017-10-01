package org.softlang.maxmeffert.bscthesis.texts.sources;

import org.softlang.maxmeffert.bscthesis.texts.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.texts.providers.ITextProvider;

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

    @Override
    public int compareTo(ITextSource iTextSource) {
        return getText().compareTo(iTextSource.getText());
    }
}
