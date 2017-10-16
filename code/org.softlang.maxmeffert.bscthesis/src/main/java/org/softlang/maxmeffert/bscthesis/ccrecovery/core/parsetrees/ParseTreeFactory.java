package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees;

import com.google.inject.Inject;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSourceFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;

public class ParseTreeFactory implements IParseTreeFactory {

    private final ITextSourceFactory textSourceFactory;
    private final ICollectionFactory collectionFactory;

    @Inject
    public ParseTreeFactory(ITextSourceFactory textSourceFactory, ICollectionFactory collectionFactory) {
        this.textSourceFactory = textSourceFactory;
        this.collectionFactory = collectionFactory;
    }

    @Override
    public IParseTree newParseTree(String name, ITextSource textSource) {
        return new ParseTree(name, textSource, collectionFactory.newList());
    }

    @Override
    public IParseTree newParseTree(TokenStream tokenStream, org.antlr.v4.runtime.tree.ParseTree parseTree) {
        return newParseTree(parseTree.getClass().getSimpleName(), textSourceFactory.newTextSource(tokenStream, parseTree));
    }

}
