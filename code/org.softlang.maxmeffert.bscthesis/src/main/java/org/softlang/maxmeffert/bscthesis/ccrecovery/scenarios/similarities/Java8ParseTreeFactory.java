package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.similarities;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParseTreeFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.antlr.java8.Java8Parser;

public class Java8ParseTreeFactory implements IAntlrParseTreeFactory<Java8Parser> {
    @Override
    public ParseTree newParseTree(Java8Parser parser) {
        ParseTree parseTree = parser.compilationUnit();
        new ParseTreeWalker().walk(new Java8FragmentAstBuilder(), parseTree);
        return parseTree;
    }
}
