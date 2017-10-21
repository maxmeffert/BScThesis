package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;

import java.io.IOException;
import java.io.InputStream;

public interface IParser {
    IFragmentAST parse(InputStream inputStream) throws IOException, ParserException;
    IParserResult tryParse(InputStream inputStream) throws IOException;
}
