package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParsingConfiguration;

public interface IParserFactory {
    IParser newParser(IAntlrParsingConfiguration antlrConfiguration);
}
