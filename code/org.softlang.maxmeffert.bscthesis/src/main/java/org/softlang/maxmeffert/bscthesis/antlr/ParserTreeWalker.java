package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ParserTreeWalker implements IParseTreeWalker {

    private final IAntlrParseTreeWalkerFactory antlrParseTreeWalkerFactory;
    private final IAntlrParseTreeListenerFactory antlrParseTreeListenerFactory;

    public ParserTreeWalker(IAntlrParseTreeWalkerFactory antlrParseTreeWalkerFactory, IAntlrParseTreeListenerFactory antlrParseTreeListenerFactory) {
        this.antlrParseTreeWalkerFactory = antlrParseTreeWalkerFactory;
        this.antlrParseTreeListenerFactory = antlrParseTreeListenerFactory;
    }

    @Override
    public void walk(IParseTree parseTree, IParseTreeWalkerListener parseTreeWalkerListener) {
//        ParseTreeWalker antlrParseTreeWalker = antlrParseTreeWalkerFactory.newParseTreeWalker();
//        ParseTreeListener antlrParseTreeListener = antlrParseTreeListenerFactory.newParseTreeListener(parseTreeWalkerListener);
//        antlrParseTreeWalker.walk(parseTree, antlrParseTreeListener);
    }
}
