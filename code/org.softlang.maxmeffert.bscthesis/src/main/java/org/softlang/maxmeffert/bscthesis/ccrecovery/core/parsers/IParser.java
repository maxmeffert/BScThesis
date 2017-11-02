package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

import java.io.IOException;
import java.io.InputStream;

public interface IParser {
    IFragment parse(InputStream inputStream) throws IOException, ParserException;
    IParserResult tryParse(InputStream inputStream) throws IOException;
}
