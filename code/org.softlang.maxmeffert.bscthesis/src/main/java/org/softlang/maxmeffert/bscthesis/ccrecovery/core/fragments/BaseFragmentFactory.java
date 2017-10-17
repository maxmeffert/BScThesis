package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

public abstract class BaseFragmentFactory {

    protected String textOf(ParserRuleContext parserRuleContext) {
        int a = parserRuleContext.start.getStartIndex();
        int b = parserRuleContext.stop.getStopIndex();
        return parserRuleContext.getStart().getInputStream().getText(Interval.of(a,b));
    }

}
