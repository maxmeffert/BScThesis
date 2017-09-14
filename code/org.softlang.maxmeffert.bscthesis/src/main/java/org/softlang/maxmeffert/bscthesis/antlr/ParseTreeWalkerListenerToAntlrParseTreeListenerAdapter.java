package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ParseTreeWalkerListenerToAntlrParseTreeListenerAdapter implements ParseTreeListener {


    private final IParseTreeWalkerListener parseTreeWalkerListener;

    public ParseTreeWalkerListenerToAntlrParseTreeListenerAdapter(IParseTreeWalkerListener parseTreeWalkerListener) {
        this.parseTreeWalkerListener = parseTreeWalkerListener;
    }

    @Override
    public void visitTerminal(TerminalNode node) {

    }

    @Override
    public void visitErrorNode(ErrorNode node) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
//        parseTreeWalkerListener.enter();
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
//        parseTreeWalkerListener.exit();
    }
}
