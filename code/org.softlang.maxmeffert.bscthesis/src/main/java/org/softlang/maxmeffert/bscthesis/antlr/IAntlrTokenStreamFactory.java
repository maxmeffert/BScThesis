package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

public interface IAntlrTokenStreamFactory {
    TokenStream newTokenStream(Lexer lexer);
}
