package org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers.ITextProvider;

import java.util.List;

public interface ITextSource extends Comparable<ITextSource> {
    ITextInterval getTextInterval();
    int getStartPosition();
    int getEndPosition();
    String getText();
    List<String> getTokens();
    boolean contains(ITextSource iTextSource);
    boolean properlyContains(ITextSource iTextSource);
    boolean contains(String text);
    boolean properlyContains(String text);
    boolean startsWith(String text);
    boolean endsWith(String text);
    boolean matches(String regex);
}
