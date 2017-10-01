package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingResult;
import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.graphs.trees.ITree;

public interface ISimpleParseTreeFactory {

    ITree<ITextSource> newSimpleParseTree(TokenStream tokenStream, ParseTree parseTree);

    ITree<ITextSource> newSimpleParseTree(IAntlrParsingResult antlrParsingResult);

}
