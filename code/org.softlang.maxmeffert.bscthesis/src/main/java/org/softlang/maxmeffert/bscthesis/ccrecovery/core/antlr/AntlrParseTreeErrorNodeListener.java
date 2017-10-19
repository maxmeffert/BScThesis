package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import com.google.common.collect.Lists;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class AntlrParseTreeErrorNodeListener implements IAntlrParseTreeErrorNodeListener {

    private List<ErrorNode> errorNodes = Lists.newLinkedList();

    @Override
    public List<ErrorNode> getErrorNodes() {
        return errorNodes;
    }

    @Override
    public void visitTerminal(TerminalNode node) {

    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        errorNodes.add(node);
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {

    }


}
