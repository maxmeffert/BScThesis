package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParsingConfiguration;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.IParseTreeConverter;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

import java.io.IOException;
import java.io.InputStream;

public class AntlrParser implements IParser {

    private final IParseTreeConverter parseTreeConverter;
    private final IAntlrParsingConfiguration antlrConfiguration;

    public AntlrParser(IParseTreeConverter parseTreeConverter, IAntlrParsingConfiguration antlrConfiguration) {
        this.parseTreeConverter = parseTreeConverter;
        this.antlrConfiguration = antlrConfiguration;
    }

    @Override
    public ITree<ITextSource> parse(InputStream inputStream) throws IOException {
        return parseTreeConverter.toTextSourceTree(antlrConfiguration.parse(inputStream));
    }

}
