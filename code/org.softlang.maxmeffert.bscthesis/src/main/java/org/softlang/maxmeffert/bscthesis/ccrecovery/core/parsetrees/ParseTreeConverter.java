package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParsingResult;

public class ParseTreeConverter implements IParseTreeConverter {

    private final IParseTreeFactory parseTreeFactory;
    private final IParseTreeNormalizerFactory parseTreeNormalizerFactory;

    public ParseTreeConverter(IParseTreeFactory parseTreeFactory, IParseTreeNormalizerFactory parseTreeNormalizerFactory) {
        this.parseTreeFactory = parseTreeFactory;
        this.parseTreeNormalizerFactory = parseTreeNormalizerFactory;
    }

    private IParseTree normalize(IParseTree simpleParseTree) {
        IParseTreeNormalizer normalizer = parseTreeNormalizerFactory.newSimpleParseTreeNormalizer();
        return normalizer.normalize(simpleParseTree);
    }

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
