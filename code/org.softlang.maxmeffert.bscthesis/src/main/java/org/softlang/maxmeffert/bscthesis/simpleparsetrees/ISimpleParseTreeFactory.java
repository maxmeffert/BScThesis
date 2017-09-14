package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public interface ISimpleParseTreeFactory {

    ISimpleParseTree newSimpleParseTree(TokenStream tokenStream, ParseTree antlrParseTree);

}
