package org.softlang.maxmeffert.bscthesis.antlr;

public class AntlrConfigurationBuilder implements IAntlrConfigurationBuilder {

    private final IAntlrCharStreamFactory antlrCharStreamFactory;
    private final IAntlrLexerFactory antlrLexerFactory;
    private final IAntlrTokenStreamFactory antlrTokenStreamFactory;
    private final IAntlrParseTreeFactory antlrParseTreeFactory;

    public AntlrConfigurationBuilder(IAntlrCharStreamFactory antlrCharStreamFactory, IAntlrLexerFactory antlrLexerFactory, IAntlrTokenStreamFactory antlrTokenStreamFactory, IAntlrParseTreeFactory antlrParseTreeFactory) {
        this.antlrCharStreamFactory = antlrCharStreamFactory;
        this.antlrLexerFactory = antlrLexerFactory;
        this.antlrTokenStreamFactory = antlrTokenStreamFactory;
        this.antlrParseTreeFactory = antlrParseTreeFactory;
    }

    @Override
    public IAntlrConfigurationBuilder withCharStreamFactory(IAntlrCharStreamFactory antlrCharStreamFactory) {
        return new AntlrConfigurationBuilder(antlrCharStreamFactory, antlrLexerFactory, antlrTokenStreamFactory, antlrParseTreeFactory);
    }

    @Override
    public IAntlrConfigurationBuilder withLexerFactory(IAntlrLexerFactory antlrLexerFactory) {
        return new AntlrConfigurationBuilder(antlrCharStreamFactory, antlrLexerFactory, antlrTokenStreamFactory, antlrParseTreeFactory);
    }

    @Override
    public IAntlrConfigurationBuilder withTokenStreamFactory(IAntlrTokenStreamFactory antlrTokenStreamFactory) {
        return new AntlrConfigurationBuilder(antlrCharStreamFactory, antlrLexerFactory, antlrTokenStreamFactory, antlrParseTreeFactory);
    }

    @Override
    public IAntlrConfigurationBuilder withParseTreeFactory(IAntlrParseTreeFactory antlrParseTreeFactory) {
        return new AntlrConfigurationBuilder(antlrCharStreamFactory, antlrLexerFactory, antlrTokenStreamFactory, antlrParseTreeFactory);
    }

    @Override
    public IAntlrConfiguration build() {
        return new AntlrConfiguration(antlrCharStreamFactory, antlrLexerFactory, antlrTokenStreamFactory, antlrParseTreeFactory);
    }
}
