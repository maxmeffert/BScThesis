package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import com.google.inject.Inject;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;

public class AntlrConfigurationFactory implements IAntlrConfigurationFactory {

    private final IAntlrCharStreamFactory antlrCharStreamFactory;
    private final IAntlrTokenStreamFactory antlrTokenStreamFactory;
    private final IAntlrConfigurationBuilderFactory antlrConfigurationBuilderFactory;

    @Inject
    public AntlrConfigurationFactory(IAntlrCharStreamFactory antlrCharStreamFactory, IAntlrTokenStreamFactory antlrTokenStreamFactory, IAntlrConfigurationBuilderFactory antlrConfigurationBuilderFactory) {
        this.antlrCharStreamFactory = antlrCharStreamFactory;
        this.antlrTokenStreamFactory = antlrTokenStreamFactory;
        this.antlrConfigurationBuilderFactory = antlrConfigurationBuilderFactory;
    }

    @Override
    public <TLexer extends Lexer, TParser extends Parser> IAntlrParsingConfiguration newAntlrConfiguration(IAntlrLexerFactory<TLexer> antlrLexerFactory, IAntlrParserFactory<TParser> antlrParserFactory, IAntlrParseTreeFactory<TParser> antlrParseTreeFactory) {
        return antlrConfigurationBuilderFactory.<TLexer, TParser>newAntlrConfigurationBuilder()
                .withCharStreamFactory(antlrCharStreamFactory)
                .withTokenStreamFactory(antlrTokenStreamFactory)
                .withLexerFactory(antlrLexerFactory)
                .withParserFactory(antlrParserFactory)
                .withParseTreeFactory(antlrParseTreeFactory)
                .build();
    }
}
