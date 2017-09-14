package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class AntlrParseTreeWalker extends ParseTreeWalker implements IAntlrParseTreeWalker {
    @Override
    public void walk(IAntlrParseTree antlrParseTree, IAntlrParseTreeListener antlrParseTreeListener) {
        walk(antlrParseTreeListener, antlrParseTree);
    }
}
