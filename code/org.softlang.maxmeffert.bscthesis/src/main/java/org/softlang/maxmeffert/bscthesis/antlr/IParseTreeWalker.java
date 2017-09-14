package org.softlang.maxmeffert.bscthesis.antlr;

public interface IParseTreeWalker {
    void walk(IParseTree parseTree, IParseTreeWalkerListener parseTreeWalkerListener);
}
