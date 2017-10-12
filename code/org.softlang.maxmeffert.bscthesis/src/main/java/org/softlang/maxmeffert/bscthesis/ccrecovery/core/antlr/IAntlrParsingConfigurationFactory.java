package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;

public interface IAntlrParsingConfigurationFactory {
    <TLexer extends Lexer, TParser extends Parser> IAntlrParsingConfiguration newAntlrConfiguration(
            IAntlrLexerFactory<TLexer> antlrLexerFactory,
            IAntlrParserFactory<TParser> antlrParserFactory,
            IAntlrParseTreeFactory<TParser> antlrParseTreeFactory);
}
