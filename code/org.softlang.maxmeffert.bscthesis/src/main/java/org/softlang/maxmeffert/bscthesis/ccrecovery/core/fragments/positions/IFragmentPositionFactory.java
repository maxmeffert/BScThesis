package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions;

import org.antlr.v4.runtime.ParserRuleContext;

public interface IFragmentPositionFactory {
    IFragmentPosition newFragmentPosition(int startLine, int startCharInLine, int stopLine, int stopCharInLine);
    IFragmentPosition newFragmentPosition(ParserRuleContext parserRuleContext);
    IFragmentPosition newEmptyFragmentPosition();
}
