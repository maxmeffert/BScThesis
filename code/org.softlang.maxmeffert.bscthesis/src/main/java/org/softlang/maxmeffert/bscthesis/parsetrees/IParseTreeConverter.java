package org.softlang.maxmeffert.bscthesis.parsetrees;

import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingResult;
import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.trees.ITree;

public interface IParseTreeConverter {

    ITree<ITextSource> toTextSourceTree(IAntlrParsingResult antlrParsingResult);

}
