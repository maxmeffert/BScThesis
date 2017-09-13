package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ParseTreeWalkerFactory implements IParseTreeWalkerFactory {
    @Override
    public ParseTreeWalker newParseTreeWalker() {
        return new ParseTreeWalker();
    }
}
