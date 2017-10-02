package org.softlang.maxmeffert.bscthesis.core.parsetrees;

import org.softlang.maxmeffert.bscthesis.core.antlr.IAntlrParsingResult;
import org.softlang.maxmeffert.bscthesis.core.trees.ITree;
import org.softlang.maxmeffert.bscthesis.core.texts.sources.ITextSource;

public interface IParseTreeConverter {

    ITree<ITextSource> toTextSourceTree(IAntlrParsingResult antlrParsingResult);

}
