package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrConfiguration;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.IParseTreeConverter;

public class ParserFactory implements IParserFactory {

    private final IParseTreeConverter parseTreeConverter;

    @Inject
    public ParserFactory(IParseTreeConverter parseTreeConverter) {
        this.parseTreeConverter = parseTreeConverter;
    }

    @Override
    public IParser newParser(IAntlrConfiguration antlrConfiguration) {
        return new AntlrParser(parseTreeConverter, antlrConfiguration);
    }
}
