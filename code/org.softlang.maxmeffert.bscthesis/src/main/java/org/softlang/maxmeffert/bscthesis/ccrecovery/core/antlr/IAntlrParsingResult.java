package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public interface IAntlrParsingResult {
    CharStream getCharStream();
    TokenStream getTokenStream();
    ParseTree getParseTree();
}
