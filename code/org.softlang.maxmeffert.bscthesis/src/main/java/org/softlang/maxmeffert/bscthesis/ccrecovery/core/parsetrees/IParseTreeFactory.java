package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;

public interface IParseTreeFactory {
    IParseTree newParseTree(String name, ITextSource textSource);
    IParseTree newParseTree(TokenStream tokenStream, ParseTree parserRuleContext);
}
