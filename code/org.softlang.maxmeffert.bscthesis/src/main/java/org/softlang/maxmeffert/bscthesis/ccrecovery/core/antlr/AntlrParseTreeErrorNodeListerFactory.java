package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

public class AntlrParseTreeErrorNodeListerFactory implements IAntlrParseTreeErrorNodeListenerFactory {
    @Override
    public IAntlrParseTreeErrorNodeListener newErrorNodeListener() {
        return new AntlrParseTreeErrorNodeListener();
    }
}
