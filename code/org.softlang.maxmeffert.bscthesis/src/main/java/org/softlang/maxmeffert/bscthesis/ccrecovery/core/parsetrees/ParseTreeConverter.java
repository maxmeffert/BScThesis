package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees;

import com.google.inject.Inject;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParsingResult;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSourceFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITreeFactory;

public class ParseTreeConverter implements IParseTreeConverter {

    private final ITreeFactory treeFactory;
    private final ITextSourceFactory textSourceFactory;
    private final IParseTreeNormalizerFactory simpleParseTreeNormalizerFactory;
    private final IParseTreeFactory parseTreeFactory;

    @Inject
    public ParseTreeConverter(ITreeFactory treeFactory, ITextSourceFactory textSourceFactory, IParseTreeNormalizerFactory simpleParseTreeNormalizerFactory, IParseTreeFactory parseTreeFactory) {
        this.treeFactory = treeFactory;
        this.textSourceFactory = textSourceFactory;
        this.simpleParseTreeNormalizerFactory = simpleParseTreeNormalizerFactory;
        this.parseTreeFactory = parseTreeFactory;
    }

//    private ITextSource newTextSource(TokenStream tokenStream, ParseTree parseTree) {
//        return textSourceFactory.newTextSource(tokenStream, parseTree);
//    }
//
//    private ITree<ITextSource> newTree(ITextSource textSource) {
//        return treeFactory.newTree(textSource);
//    }
//
//    private ITree<ITextSource> newTree(TokenStream tokenStream, ParseTree parseTree) {
//        return newTree(newTextSource(tokenStream, parseTree));
//    }
//
//    private ParseTreeConverterException newParseTreeConverterException(ErrorNode errorNode) {
//        return new ParseTreeConverterException("ErrorNode for " + errorNode.getText() + " at " + errorNode.getSourceInterval());
//    }
//
//    private ParseTreeConverterException newParseTreeConverterException(ParseTree parseTree) {
//        return newParseTreeConverterException((ErrorNode) parseTree);
//    }
//
//    private ITree<ITextSource> newTextSourceTree(TokenStream tokenStream, ParseTree parseTree) throws ParseTreeConverterException {
//        if (parseTree instanceof ErrorNode) {
//            throw newParseTreeConverterException(parseTree);
//        }
//        ITree<ITextSource> tree = newTree(tokenStream, parseTree);
//        for (int i=0; i<parseTree.getChildCount(); i++) {
//            tree.addChild(newTextSourceTree(tokenStream, parseTree.getChild(i)));
//        }
//        return tree;
//    }
//
//    private ITree<ITextSource> newTextSourceTree(IAntlrParsingResult antlrParsingResult) throws ParseTreeConverterException {
//        return newTextSourceTree(antlrParsingResult.getTokenStream(), antlrParsingResult.getParseTree());
//    }
//
    private IParseTree normalize(IParseTree simpleParseTree) {
        IParseTreeNormalizer normalizer = simpleParseTreeNormalizerFactory.newSimpleParseTreeNormalizer();
        return normalizer.normalize(simpleParseTree);
    }
//
//    @Override
//    public ITree<ITextSource> toTextSourceTree(IAntlrParsingResult antlrParsingResult) throws ParseTreeConverterException {
//        return normalize(newTextSourceTree(antlrParsingResult));
//    }

    private IParseTree toParseTree(TokenStream tokenStream, ParseTree parseTree) {
        IParseTree iParseTree = parseTreeFactory.newParseTree(tokenStream, parseTree);
        for (int i=0;i<parseTree.getChildCount(); i++) {
            iParseTree.addChild(toParseTree(tokenStream, parseTree.getChild(i)));
        }
        return iParseTree;
    }

    @Override
    public IParseTree toParseTree(IAntlrParsingResult antlrParsingResult) throws ParseTreeConverterException {
        return normalize(toParseTree(antlrParsingResult.getTokenStream(), antlrParsingResult.getParseTree()));
    }

}
