package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

public interface IAntlrParseTreeListenerFactory {

    ParseTreeListener newParseTreeListener(IParseTreeWalkerListener parseTreeWalkerListener);

}
