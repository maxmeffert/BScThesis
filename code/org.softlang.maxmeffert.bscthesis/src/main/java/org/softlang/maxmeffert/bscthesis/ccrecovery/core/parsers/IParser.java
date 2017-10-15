package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

import java.io.IOException;
import java.io.InputStream;

public interface IParser {
    ITree<ITextSource> parse(InputStream inputStream) throws IOException, ParserException;
    IParserResult tryParse(InputStream inputStream) throws IOException;
}
