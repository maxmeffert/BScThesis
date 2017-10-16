package org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources;

import com.sun.istack.internal.NotNull;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers.ITextProvider;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.tokensequences.ITokenSequence;

import java.util.List;

public class TextSource implements ITextSource {

    private final ITextInterval textInterval;
    private final ITextProvider textProvider;

    private String text;
    private ITokenSequence tokens;

    public TextSource(ITextInterval textInterval, ITextProvider textProvider) {
        this.textInterval = textInterval;
        this.textProvider = textProvider;
    }

    @Override
    public ITextInterval getTextInterval() {
        return textInterval;
    }

    @Override
    public int getStartPosition() {
        return getTextInterval().getStartPosition();
    }

    @Override
    public int getEndPosition() {
        return getTextInterval().getEndPosition();
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
    public ITokenSequence getTokens() {
        if (tokens == null) {
            tokens = getTextProvider().getTokens(getTextInterval());
        }
        return tokens;
    }


    @Override
    public boolean contains(ITextSource iTextSource) {
        return getTextInterval().contains(iTextSource.getTextInterval()) && contains(iTextSource.getText());
    }

    @Override
    public boolean properlyContains(ITextSource iTextSource) {
        return getTextInterval().properlyContains(iTextSource.getTextInterval()) && contains(iTextSource.getText());
    }

    @Override
    public boolean contains(String text) {
        return getText().contains(text);
    }

    @Override
    public boolean properlyContains(String text) {
        return  contains(text) && !(startsWith(text) || endsWith(text));
    }

    @Override
    public boolean startsWith(String text) {
        return getText().startsWith(text);
    }

    @Override
    public boolean endsWith(String text) {
        return getText().endsWith(text);
    }

    @Override
    public boolean matches(String regex) {
        return getText().matches(regex);
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ITextSource) {
            return compareTo((ITextSource) obj) == 0;
        }
        return false;
    }
}
