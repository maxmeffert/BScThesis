package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class AntlrParseTreeWalkerFactory implements IAntlrParseTreeWalkerFactory {
    @Override
    public ParseTreeWalker newParseTreeWalker() {
        return new ParseTreeWalker();
    }
}
