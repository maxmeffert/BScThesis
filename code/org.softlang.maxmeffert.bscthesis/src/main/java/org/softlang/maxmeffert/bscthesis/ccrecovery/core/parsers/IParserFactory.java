package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.*;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs.IFragmentBuildingListener;

public interface IParserFactory {
    IParser newParser(IAntlrLexerFactory antlrLexerFactory, IAntlrParserFactory antlrParserFactory, IAntlrParseTreeFactory antlrParseTreeFactory, IFragmentBuildingListener fragmentBuildingListener);
}
