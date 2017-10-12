package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrConfiguration;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.IParseTreeConverter;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public class AntlrParser implements IParser {

    private final IParseTreeConverter parseTreeConverter;
    private final IAntlrConfiguration antlrConfiguration;

    public AntlrParser(IParseTreeConverter parseTreeConverter, IAntlrConfiguration antlrConfiguration) {
        this.parseTreeConverter = parseTreeConverter;
        this.antlrConfiguration = antlrConfiguration;
    }

    @Override
    public ITree<ITextSource> parse(String string) {
        return parseTreeConverter.toTextSourceTree(antlrConfiguration.parse(string));
    }

    @Override
    public ITree<ITextSource> parse(File file) throws IOException {
        return parseTreeConverter.toTextSourceTree(antlrConfiguration.parse(file));
    }

    @Override
    public ITree<ITextSource> parse(InputStream inputStream) throws IOException {
        return parseTreeConverter.toTextSourceTree(antlrConfiguration.parse(inputStream));
    }

    @Override
    public ITree<ITextSource> parse(URI uri) throws IOException {
        return parseTreeConverter.toTextSourceTree(antlrConfiguration.parse(uri));
    }

    @Override
    public ITree<ITextSource> parse(URL url) throws IOException {
        return parseTreeConverter.toTextSourceTree(antlrConfiguration.parse(url));
    }
}
