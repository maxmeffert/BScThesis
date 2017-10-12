package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;

public interface IAntlrConfigurationFactory {
    <TLexer extends Lexer, TParser extends Parser> IAntlrConfiguration newAntlrConfiguration(
            IAntlrLexerFactory<TLexer> antlrLexerFactory,
            IAntlrParserFactory<TParser> antlrParserFactory,
            IAntlrParseTreeFactory<TParser> antlrParseTreeFactory);
}
