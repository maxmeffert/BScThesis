package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;

public interface IAntlrConfigurationBuilder<TLexer extends Lexer, TParser extends Parser> {
    IAntlrConfigurationBuilder<TLexer,TParser> withCharStreamFactory(IAntlrCharStreamFactory antlrCharStreamFactory);
    IAntlrConfigurationBuilder<TLexer,TParser> withLexerFactory(IAntlrLexerFactory<TLexer> antlrLexerFactory);
    IAntlrConfigurationBuilder<TLexer,TParser> withTokenStreamFactory(IAntlrTokenStreamFactory antlrTokenStreamFactory);
    IAntlrConfigurationBuilder<TLexer,TParser> withParserFactory(IAntlrParserFactory<TParser> antlrParserFactory);
    IAntlrConfigurationBuilder<TLexer,TParser> withParseTreeFactory(IAntlrParseTreeFactory<TParser> antlrParseTreeFactory);
    IAntlrParsingConfiguration build();
}
