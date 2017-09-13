package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.tree.ParseTree;

public interface IParseTreeFactory {

    ParseTree newParseTreeFromFileName(String fileName);

}
