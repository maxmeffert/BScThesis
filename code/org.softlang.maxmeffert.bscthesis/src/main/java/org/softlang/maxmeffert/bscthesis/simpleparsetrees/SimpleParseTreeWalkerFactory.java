package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

public class SimpleParseTreeWalkerFactory implements ISimpleParseTreeWalkerFactory {
    @Override
    public ISimpleParseTreeWalker newParseTreeWalker() {
        return new SimpleParseTreeWalker();
    }
}
