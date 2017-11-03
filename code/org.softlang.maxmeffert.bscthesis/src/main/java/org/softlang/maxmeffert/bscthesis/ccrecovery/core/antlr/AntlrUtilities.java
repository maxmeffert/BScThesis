package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

public class AntlrUtilities implements IAntlrUtilities {
    @Override
    public String getOriginalText(ParserRuleContext parserRuleContext) {
        int a = parserRuleContext.start.getStartIndex();
        int b = parserRuleContext.stop.getStopIndex();
        return parserRuleContext.getStart().getInputStream().getText(Interval.of(a,b));
    }
}
