package org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.providers;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;

public interface ITextProviderFactory {
    ITextProvider newTextProvider(CharStream charStream);
    ITextProvider newTextProvider(TokenStream tokenStream);
}
