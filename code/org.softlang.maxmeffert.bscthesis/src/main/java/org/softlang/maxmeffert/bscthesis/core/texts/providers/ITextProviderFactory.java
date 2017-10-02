package org.softlang.maxmeffert.bscthesis.core.texts.providers;

import org.antlr.v4.runtime.TokenStream;

public interface ITextProviderFactory {
    ITextProvider newTextProvider(TokenStream tokenStream);
}
