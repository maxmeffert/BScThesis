package org.softlang.maxmeffert.bscthesis.textsources;

import org.antlr.v4.runtime.TokenStream;

public interface ITextProviderFactory {
    ITextProvider newTextProvider(TokenStream tokenStream);
}
