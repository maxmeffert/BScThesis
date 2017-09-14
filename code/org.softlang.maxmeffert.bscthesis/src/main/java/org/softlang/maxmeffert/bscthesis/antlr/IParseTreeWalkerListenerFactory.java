package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

public interface IParseTreeWalkerListenerFactory {
    IParseTreeWalkerListener newParseTreeWalkerListener(ParseTreeListener parseTreeListener);
}
