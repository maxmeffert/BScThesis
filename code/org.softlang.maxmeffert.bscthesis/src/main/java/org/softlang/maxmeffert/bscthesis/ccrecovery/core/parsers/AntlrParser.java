package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParsingConfiguration;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.IParseTree;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.IParseTreeConverter;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.ParseTreeConverterException;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public class AntlrParser implements IParser {

    private final IParserResultFactory parserResultFactory;
    private final IParseTreeConverter parseTreeConverter;
    private final IAntlrParsingConfiguration antlrConfiguration;

    public AntlrParser(IParserResultFactory parserResultFactory, IParseTreeConverter parseTreeConverter, IAntlrParsingConfiguration antlrConfiguration) {
        this.parserResultFactory = parserResultFactory;
        this.parseTreeConverter = parseTreeConverter;
        this.antlrConfiguration = antlrConfiguration;
    }

    @Override
    public IParseTree parse(InputStream inputStream) throws IOException, ParserException {
        try {
            return parseTreeConverter.toParseTree(antlrConfiguration.parse(inputStream));
        } catch (ParseTreeConverterException e) {
            throw new ParserException(e.getMessage());
        }
    }

    @Override
    public IParserResult tryParse(InputStream inputStream) throws IOException {
        try {
            return parserResultFactory.accepted(parse(inputStream));
        } catch (ParserException parserException) {
            return parserResultFactory.notAccepted(parserException);
        }
    }

}
