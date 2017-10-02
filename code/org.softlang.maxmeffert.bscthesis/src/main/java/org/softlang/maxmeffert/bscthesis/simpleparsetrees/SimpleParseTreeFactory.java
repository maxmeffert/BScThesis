package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import com.google.inject.Inject;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingResult;
import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSourceFactory;
import org.softlang.maxmeffert.bscthesis.trees.ITree;
import org.softlang.maxmeffert.bscthesis.trees.ITreeFactory;

public class SimpleParseTreeFactory implements ISimpleParseTreeFactory {

    private final ITreeFactory treeFactory;
    private final ITextSourceFactory textSourceFactory;
    private final ISimpleParseTreeNormalizerFactory simpleParseTreeNormalizerFactory;

    @Inject
    public SimpleParseTreeFactory(ITreeFactory treeFactory, ITextSourceFactory textSourceFactory, ISimpleParseTreeNormalizerFactory simpleParseTreeNormalizerFactory) {
        this.treeFactory = treeFactory;
        this.textSourceFactory = textSourceFactory;
        this.simpleParseTreeNormalizerFactory = simpleParseTreeNormalizerFactory;
    }

    private ITextSource newTextSource(TokenStream tokenStream, ParseTree parseTree) {
        return textSourceFactory.newTextSource(tokenStream, parseTree);
    }

    private ITree<ITextSource> newTree(ITextSource textSource) {
        return treeFactory.newTree(textSource);
    }

    private ITree<ITextSource> newTree(TokenStream tokenStream, ParseTree parseTree) {
        return newTree(newTextSource(tokenStream, parseTree));
    }

    private ITree<ITextSource> newTextSourceTree(TokenStream tokenStream, ParseTree parseTree) {
        ITree<ITextSource> tree = newTree(tokenStream, parseTree);
        for (int i=0; i<parseTree.getChildCount(); i++) {
            tree.addChild(newTextSourceTree(tokenStream, parseTree.getChild(i)));
        }
        return tree;
    }

    private ITree<ITextSource> newTextSourceTree(IAntlrParsingResult antlrParsingResult) {
        return newTextSourceTree(antlrParsingResult.getTokenStream(), antlrParsingResult.getParseTree());
    }

    private ISimpleParseTree normalize(ISimpleParseTree simpleParseTree) {
        ISimpleParseTreeNormalizer normalizer = simpleParseTreeNormalizerFactory.newSimpleParseTreeNormalizer();
        return normalizer.normalize(simpleParseTree);
    }

    @Override
    public ISimpleParseTree newSimpleParseTree(ITree<ITextSource> tree) {
        return normalize(new SimpleParseTree(tree));
    }

    @Override
    public ISimpleParseTree newSimpleParseTree(IAntlrParsingResult antlrParsingResult) {
        return newSimpleParseTree(newTextSourceTree(antlrParsingResult));
    }



//    @Override
//    public ITree<ITextSource> newSimpleParseTree(TokenStream tokenStream, ParseTree parseTree) {
//        ITree<ITextSource> tree = treeFactory.newTreeWithValue(newTextSource(tokenStream, parseTree));
//        for (int i=0; i<parseTree.getChildCount(); i++) {
//            tree.addChild(newSimpleParseTree(tokenStream, parseTree.getChild(i)));
//        }
//        return simpleParseTreeNormalizerFactory.newSimpleParseTreeNormalizer().normalize(tree);
//    }
//
//    @Override
//    public ITree<ITextSource> newSimpleParseTree(IAntlrParsingResult antlrParsingResult) {
//        return newSimpleParseTree(antlrParsingResult.getTokenStream(), antlrParsingResult.getParseTree());
//    }


}
