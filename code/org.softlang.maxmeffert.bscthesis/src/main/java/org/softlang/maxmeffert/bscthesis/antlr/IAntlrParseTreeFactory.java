package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public interface IAntlrParseTreeFactory {
    ParseTree newParseTree(TokenStream tokenStream);
}
