package org.softlang.maxmeffert.bscthesis.core.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;

public interface IAntlrLexerFactory<TLexer extends Lexer> {
    TLexer newLexer(CharStream charStream);
}
