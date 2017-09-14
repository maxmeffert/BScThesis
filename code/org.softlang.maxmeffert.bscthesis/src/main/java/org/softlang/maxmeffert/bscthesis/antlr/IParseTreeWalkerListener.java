package org.softlang.maxmeffert.bscthesis.antlr;

public interface IParseTreeWalkerListener {
    void enter(IParseTree parseTree);
    void exit(IParseTree parseTree);
}
