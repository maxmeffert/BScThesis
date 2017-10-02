package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingResult;
import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.trees.ITree;

public interface ISimpleParseTreeFactory {

    ISimpleParseTree newSimpleParseTree(ITree<ITextSource> tree);
    ISimpleParseTree newSimpleParseTree(IAntlrParsingResult antlrParsingResult);

}
