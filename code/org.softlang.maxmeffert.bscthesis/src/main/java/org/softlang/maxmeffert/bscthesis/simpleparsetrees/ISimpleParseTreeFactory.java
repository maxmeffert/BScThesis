package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingResult;

public interface ISimpleParseTreeFactory {


    ISimpleParseTree newSimpleParseTree2(TokenStream tokenStream, ParseTree parseTree);

    ISimpleParseTree newSimpleParseTree2(IAntlrParsingResult antlrParsingResult);

}
