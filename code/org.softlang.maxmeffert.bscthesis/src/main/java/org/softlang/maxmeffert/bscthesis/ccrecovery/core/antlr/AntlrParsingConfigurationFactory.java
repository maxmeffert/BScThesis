package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import com.google.inject.Inject;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;

public class AntlrParsingConfigurationFactory implements IAntlrParsingConfigurationFactory {

    private final IAntlrCharStreamFactory antlrCharStreamFactory;
    private final IAntlrTokenStreamFactory antlrTokenStreamFactory;

    @Inject
    public AntlrParsingConfigurationFactory(IAntlrCharStreamFactory antlrCharStreamFactory, IAntlrTokenStreamFactory antlrTokenStreamFactory) {
        this.antlrCharStreamFactory = antlrCharStreamFactory;
        this.antlrTokenStreamFactory = antlrTokenStreamFactory;
    }

    @Override
    public <TLexer extends Lexer, TParser extends Parser> IAntlrParsingConfiguration newAntlrConfiguration(IAntlrLexerFactory<TLexer> antlrLexerFactory, IAntlrParserFactory<TParser> antlrParserFactory, IAntlrParseTreeFactory<TParser> antlrParseTreeFactory) {
        return new AntlrParsingConfiguration(antlrCharStreamFactory,  antlrLexerFactory, antlrTokenStreamFactory, antlrParserFactory, antlrParseTreeFactory);
    }
}
