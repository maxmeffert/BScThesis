package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

public interface IAntlrParseTreeFactory<TParser extends Parser> {
    ParseTree newParseTree(TParser parser);
}
