package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public interface IAntlrParsingResult {
    TokenStream getTokenStream();
    ParseTree getParseTree();
}