package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingResult;
import org.softlang.maxmeffert.bscthesis.textsources.*;
import org.softlang.maxmeffert.bscthesis.trees.ITree;
import org.softlang.maxmeffert.bscthesis.trees.ITreeFactory;

public class SimpleParseTreeFactory implements ISimpleParseTreeFactory {

    private final ITreeFactory treeFactory;
    private final ITextSourceFactory textSourceFactory;
    private final ISimpleParseTreeNormalizerFactory simpleParseTreeNormalizerFactory;

    public SimpleParseTreeFactory(ITreeFactory treeFactory, ITextSourceFactory textSourceFactory, ISimpleParseTreeNormalizerFactory simpleParseTreeNormalizerFactory) {
        this.treeFactory = treeFactory;
        this.textSourceFactory = textSourceFactory;
        this.simpleParseTreeNormalizerFactory = simpleParseTreeNormalizerFactory;
    }

    private ITextSource newTextSource(TokenStream tokenStream, ParseTree parseTree) {
        return textSourceFactory.newTextSource(tokenStream, parseTree);
    }

    @Override
    public ITree<ITextSource> newSimpleParseTree(TokenStream tokenStream, ParseTree parseTree) {
        ITree<ITextSource> tree = treeFactory.newTreeWithValue(newTextSource(tokenStream, parseTree));
        for (int i=0; i<parseTree.getChildCount(); i++) {
            tree.addChild(newSimpleParseTree(tokenStream, parseTree.getChild(i)));
        }
        return simpleParseTreeNormalizerFactory.newSimpleParseTreeNormalizer().normalize(tree);
    }

    @Override
    public ITree<ITextSource> newSimpleParseTree(IAntlrParsingResult antlrParsingResult) {
        return newSimpleParseTree(antlrParsingResult.getTokenStream(), antlrParsingResult.getParseTree());
    }

}
