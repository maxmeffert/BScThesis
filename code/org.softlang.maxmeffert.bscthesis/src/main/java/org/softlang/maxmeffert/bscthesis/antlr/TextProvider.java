package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

public class TextProvider implements ITextProvider {

    @Override
    public String getTextOfParserRuleContext(ParserRuleContext parserRuleContext) {
        int a = parserRuleContext.getStart().getStartIndex();
        int b = parserRuleContext.getStop().getStopIndex();
        Interval interval = new Interval(a,b);
        CharStream stream = parserRuleContext.getStart().getInputStream();
        return stream.getText(interval);
    }
}
