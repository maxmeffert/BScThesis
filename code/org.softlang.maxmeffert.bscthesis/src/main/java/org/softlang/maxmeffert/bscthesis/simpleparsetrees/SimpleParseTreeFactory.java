package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import com.google.inject.Inject;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingResult;
import org.softlang.maxmeffert.bscthesis.texts.sources.*;
import org.softlang.maxmeffert.bscthesis.graphs.oldtrees.ITree;
import org.softlang.maxmeffert.bscthesis.graphs.oldtrees.ITreeFactory;

public class SimpleParseTreeFactory implements ISimpleParseTreeFactory {

    private final ITreeFactory treeFactory;
    private final ITextSourceFactory textSourceFactory;
    private final ISimpleParseTreeBuilderFactory simpleParseTreeBuilderFactory;
    private final ISimpleParseTreeNormalizerFactory simpleParseTreeNormalizerFactory;

    @Inject
    public SimpleParseTreeFactory(ITreeFactory treeFactory, ITextSourceFactory textSourceFactory, ISimpleParseTreeBuilderFactory simpleParseTreeBuilderFactory, ISimpleParseTreeNormalizerFactory simpleParseTreeNormalizerFactory) {
        this.treeFactory = treeFactory;
        this.textSourceFactory = textSourceFactory;
        this.simpleParseTreeBuilderFactory = simpleParseTreeBuilderFactory;
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

    @Override
    public ISimpleParseTree newSimpleParseTree2(TokenStream tokenStream, ParseTree parseTree) {
        return null;
    }

    public void newSimpleParseTree2(ISimpleParseTreeBuilder simpleParseTreeBuilder, TokenStream tokenStream, ParseTree parseTree) {
        ITextSource parent = newTextSource(tokenStream, parseTree);
        for(int i=0; i<parseTree.getChildCount(); i++) {
            ITextSource child = newTextSource(tokenStream, parseTree.getChild(i));
            simpleParseTreeBuilder.withChild(parent, child);
            newSimpleParseTree2(simpleParseTreeBuilder, tokenStream, parseTree.getChild(i));
        }
    }

    @Override
    public ISimpleParseTree newSimpleParseTree2(IAntlrParsingResult antlrParsingResult) {
        ISimpleParseTreeBuilder simpleParseTreeBuilder = simpleParseTreeBuilderFactory.newSimpleParseTreeBuilder();
        newSimpleParseTree2(simpleParseTreeBuilder, antlrParsingResult.getTokenStream(), antlrParsingResult.getParseTree());
        return simpleParseTreeBuilder.build();
    }

}
