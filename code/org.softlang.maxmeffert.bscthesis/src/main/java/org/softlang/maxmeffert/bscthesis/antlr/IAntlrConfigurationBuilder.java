package org.softlang.maxmeffert.bscthesis.antlr;

public interface IAntlrConfigurationBuilder {
    IAntlrConfigurationBuilder withCharStreamFactory(IAntlrCharStreamFactory antlrCharStreamFactory);
    IAntlrConfigurationBuilder withLexerFactory(IAntlrLexerFactory antlrLexerFactory);
    IAntlrConfigurationBuilder withTokenStreamFactory(IAntlrTokenStreamFactory antlrTokenStreamFactory);
    IAntlrConfigurationBuilder withParseTreeFactory(IAntlrParseTreeFactory antlrParseTreeFactory);
    IAntlrConfiguration build();
}
