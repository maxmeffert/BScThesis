package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParsingConfiguration;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.IParseTreeConverter;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.IParseTreeConverterFactory;

public class ParserFactory implements IParserFactory {

    private final IParserResultFactory parserResultFactory;
    private final IParseTreeConverterFactory parseTreeConverterFactory;

    @Inject
    public ParserFactory(IParserResultFactory parserResultFactory, IParseTreeConverterFactory parseTreeConverterFactory) {
        this.parserResultFactory = parserResultFactory;
        this.parseTreeConverterFactory = parseTreeConverterFactory;
    }

    @Override
    public IParser newParser(IAntlrParsingConfiguration antlrConfiguration) {
        return new AntlrParser(parserResultFactory, parseTreeConverterFactory.newParseTreeConverter(), antlrConfiguration);
    }
}
