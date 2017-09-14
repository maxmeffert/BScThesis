package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

public interface ISimpleParseTreeWalker {
    void walk(ISimpleParseTree parseTree, ISimpleParseTreeWalkerListener parseTreeWalkerListener);
}
