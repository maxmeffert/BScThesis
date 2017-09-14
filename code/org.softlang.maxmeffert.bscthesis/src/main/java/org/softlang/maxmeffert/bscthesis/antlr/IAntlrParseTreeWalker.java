package org.softlang.maxmeffert.bscthesis.antlr;

public interface IAntlrParseTreeWalker {
    void walk(IAntlrParseTree antlrParseTree, IAntlrParseTreeListener antlrParseTreeListener);
}
