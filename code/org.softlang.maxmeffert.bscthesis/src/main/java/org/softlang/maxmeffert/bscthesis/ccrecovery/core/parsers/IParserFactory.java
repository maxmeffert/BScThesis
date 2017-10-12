package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrConfiguration;

public interface IParserFactory {
    IParser newParser(IAntlrConfiguration antlrConfiguration);
}
