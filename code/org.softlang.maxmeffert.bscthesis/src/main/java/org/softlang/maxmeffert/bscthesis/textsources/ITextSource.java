package org.softlang.maxmeffert.bscthesis.textsources;

public interface ITextSource {
    ITextInterval getTextInterval();
    ITextProvider getTextProvider();
    String getText();
}
