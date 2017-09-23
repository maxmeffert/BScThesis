package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingResult;
import org.softlang.maxmeffert.bscthesis.text.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.trees.ITree;

public interface ISimpleParseTreeFactory {

    ITree<ITextSource> newSimpleParseTree(TokenStream tokenStream, ParseTree parseTree);

    ITree<ITextSource> newSimpleParseTree(IAntlrParsingResult antlrParsingResult);

}
