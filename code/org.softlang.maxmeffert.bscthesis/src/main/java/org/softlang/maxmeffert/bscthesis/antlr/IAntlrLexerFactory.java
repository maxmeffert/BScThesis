package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;

import java.lang.reflect.InvocationTargetException;

public interface IAntlrLexerFactory {
    Lexer newLexer(CharStream charStream);
}
