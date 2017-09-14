package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

public class SimpleParseTreeWalker implements ISimpleParseTreeWalker {
    @Override
    public void walk(ISimpleParseTree parseTree, ISimpleParseTreeWalkerListener parseTreeWalkerListener) {
        parseTreeWalkerListener.enter(parseTree);
        for(ISimpleParseTree child : parseTree.getChildren()) {
            walk(child, parseTreeWalkerListener);
        }
        parseTreeWalkerListener.exit(parseTree);
    }
}
