package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;

public interface IAntlrConfigurationBuilderFactory {
    <TLexer extends Lexer, TParser extends Parser> IAntlrConfigurationBuilder<TLexer, TParser> newAntlrConfigurationBuilder();
}
