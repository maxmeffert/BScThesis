package org.softlang.maxmeffert.bscthesis.textsources;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public interface ITextSourceFactory {
    ITextSource newTextSource(TokenStream tokenStream, ParseTree parseTree);
}