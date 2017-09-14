package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class SimpleParseTreeFactory implements ISimpleParseTreeFactory {
    @Override
    public ISimpleParseTree newSimpleParseTree(TokenStream tokenStream, ParseTree antlrParseTree) {
        ISimpleParseTreeBuilder parseTreeBuilder = new SimpleParseTreeBuilder()
                .withSourceStream(tokenStream)
                .withSourceInterval(antlrParseTree.getSourceInterval());

        for (int i=0; i<antlrParseTree.getChildCount(); i++) {
            ISimpleParseTree child = newSimpleParseTree(tokenStream, antlrParseTree.getChild(i));
            parseTreeBuilder = parseTreeBuilder.withChild(child);
        }

        return parseTreeBuilder.build();
    }
}
