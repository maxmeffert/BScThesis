package org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources;

import com.sun.istack.internal.NotNull;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers.ITextProvider;

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
        return getText() + " @ " + getTextInterval();
    }

    @Override
    public int compareTo(@NotNull  ITextSource iTextSource) {
        int result = getTextInterval().compareTo(iTextSource.getTextInterval());
        if (result == 0) {
            result = getText().compareTo(iTextSource.getText());
        }
        return result;
    }
}
