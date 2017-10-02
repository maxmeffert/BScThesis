package org.softlang.maxmeffert.bscthesis.texts.sources;

import org.softlang.maxmeffert.bscthesis.texts.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.texts.providers.ITextProvider;

public class TextSource implements ITextSource {

    private final ITextInterval textInterval;
    private final ITextProvider textProvider;

    private String text;

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
        if (text == null) {
            text = getTextProvider().getText(getTextInterval());
        }
        return text;
    }

    @Override
    public String toString() {
        return getTextInterval() + " | " + getText();
    }

    @Override
    public int compareTo(ITextSource iTextSource) {
        int result = getTextInterval().compareTo(iTextSource.getTextInterval());
        if (result == 0) {
            result = getText().compareTo(iTextSource.getText());
        }
        return result;
    }
}
