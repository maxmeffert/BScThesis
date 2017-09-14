package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

public interface ISimpleParseTreeWalkerListener {
    void enter(ISimpleParseTree parseTree);
    void exit(ISimpleParseTree parseTree);
}
