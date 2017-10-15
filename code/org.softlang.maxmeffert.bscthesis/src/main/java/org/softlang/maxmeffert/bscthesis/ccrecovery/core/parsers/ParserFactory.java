package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParsingConfiguration;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.IParseTreeConverter;

public class ParserFactory implements IParserFactory {

    private final IParserResultFactory parserResultFactory;
    private final IParseTreeConverter parseTreeConverter;

    @Inject
    public ParserFactory(IParserResultFactory parserResultFactory, IParseTreeConverter parseTreeConverter) {
        this.parserResultFactory = parserResultFactory;
        this.parseTreeConverter = parseTreeConverter;
    }

    @Override
    public IParser newParser(IAntlrParsingConfiguration antlrConfiguration) {
        return new AntlrParser(parserResultFactory, parseTreeConverter, antlrConfiguration);
    }
}
