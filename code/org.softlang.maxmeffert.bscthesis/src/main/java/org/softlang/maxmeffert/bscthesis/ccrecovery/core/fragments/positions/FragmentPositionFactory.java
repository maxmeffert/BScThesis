package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions;

import org.antlr.v4.runtime.ParserRuleContext;

public class FragmentPositionFactory implements IFragmentPositionFactory {
    @Override
    public IFragmentPosition newFragmentPosition(int startLine, int startCharInLine, int stopLine, int stopCharInLine) {
        return new FragmentPosition(startLine, startCharInLine, stopLine, stopCharInLine);
    }

    @Override
    public IFragmentPosition newFragmentPosition(ParserRuleContext parserRuleContext) {
        int startLine = parserRuleContext.getStart().getLine();
        int startCharInLine = parserRuleContext.getStart().getCharPositionInLine();
        int stopLine = parserRuleContext.getStop().getLine();
        int stopCharInLine = parserRuleContext.getStop().getCharPositionInLine() + parserRuleContext.getStop().getText().length();
        return newFragmentPosition(startLine, startCharInLine, stopLine, stopCharInLine);
    }

    @Override
    public IFragmentPosition newEmptyFragmentPosition() {
        return newFragmentPosition(0,0,0,0);
    }
}
