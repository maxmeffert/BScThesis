package org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public interface ITextSourceFactory {
    ITextSource newTextSource(CharStream charStream, ParseTree parseTree);
    ITextSource newTextSource(TokenStream tokenStream, ParseTree parseTree);
}
