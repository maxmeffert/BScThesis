package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;

public class AntlrConfigurationBuilder<TLexer extends Lexer, TParser extends Parser> implements IAntlrConfigurationBuilder<TLexer, TParser> {

    private final IAntlrCharStreamFactory antlrCharStreamFactory;
    private final IAntlrLexerFactory antlrLexerFactory;
    private final IAntlrTokenStreamFactory antlrTokenStreamFactory;
    private final IAntlrParserFactory antlrParserFactory;
    private final IAntlrParseTreeFactory antlrParseTreeFactory;

    public AntlrConfigurationBuilder(IAntlrCharStreamFactory antlrCharStreamFactory, IAntlrLexerFactory antlrLexerFactory, IAntlrTokenStreamFactory antlrTokenStreamFactory, IAntlrParserFactory antlrParserFactory, IAntlrParseTreeFactory antlrParseTreeFactory) {
        this.antlrCharStreamFactory = antlrCharStreamFactory;
        this.antlrLexerFactory = antlrLexerFactory;
        this.antlrTokenStreamFactory = antlrTokenStreamFactory;
        this.antlrParserFactory = antlrParserFactory;
        this.antlrParseTreeFactory = antlrParseTreeFactory;
    }

    @Override
    public IAntlrConfigurationBuilder withCharStreamFactory(IAntlrCharStreamFactory antlrCharStreamFactory) {
        return new AntlrConfigurationBuilder(antlrCharStreamFactory, antlrLexerFactory, antlrTokenStreamFactory, antlrParserFactory, antlrParseTreeFactory);
    }

    @Override
    public IAntlrConfigurationBuilder withLexerFactory(IAntlrLexerFactory<TLexer> antlrLexerFactory) {
        return new AntlrConfigurationBuilder(antlrCharStreamFactory, antlrLexerFactory, antlrTokenStreamFactory, antlrParserFactory, antlrParseTreeFactory);
    }

    @Override
    public IAntlrConfigurationBuilder withTokenStreamFactory(IAntlrTokenStreamFactory antlrTokenStreamFactory) {
        return new AntlrConfigurationBuilder(antlrCharStreamFactory, antlrLexerFactory, antlrTokenStreamFactory, antlrParserFactory, antlrParseTreeFactory);
    }

    @Override
    public IAntlrConfigurationBuilder withParserFactory(IAntlrParserFactory<TParser> antlrParserFactory) {
        return new AntlrConfigurationBuilder(antlrCharStreamFactory, antlrLexerFactory, antlrTokenStreamFactory, antlrParserFactory, antlrParseTreeFactory);
    }

    @Override
    public IAntlrConfigurationBuilder withParseTreeFactory(IAntlrParseTreeFactory<TParser> antlrParseTreeFactory) {
        return new AntlrConfigurationBuilder(antlrCharStreamFactory, antlrLexerFactory, antlrTokenStreamFactory, antlrParserFactory, antlrParseTreeFactory);
    }

    @Override
    public IAntlrParsingConfiguration build() {
        return new AntlrConfiguration(antlrCharStreamFactory, antlrLexerFactory, antlrTokenStreamFactory, antlrParserFactory, antlrParseTreeFactory);
    }
}
