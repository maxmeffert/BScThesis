package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParsingResult;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;

public interface IParseTreeConverter {

    ITree<ITextSource> toTextSourceTree(IAntlrParsingResult antlrParsingResult) throws ParseTreeConverterException;

}
