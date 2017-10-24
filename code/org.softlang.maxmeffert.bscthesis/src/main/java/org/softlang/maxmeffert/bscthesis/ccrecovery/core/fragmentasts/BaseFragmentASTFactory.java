package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

import java.util.Stack;
import java.util.function.Consumer;

public abstract class BaseFragmentASTFactory {

    protected String textOf(ParserRuleContext parserRuleContext) {
        int a = parserRuleContext.start.getStartIndex();
        int b = parserRuleContext.stop.getStopIndex();
        return parserRuleContext.getStart().getInputStream().getText(Interval.of(a,b)); //.replace(System.lineSeparator(), "");
    }

    protected <TFragment extends IFragmentAST> TFragment initialize(TFragment fragment, ParserRuleContext parserRuleContext) {
        fragment.setText(textOf(parserRuleContext));
        return fragment;
    }

    protected <T> void popEach(Stack<T> stack, Consumer<T> consumer) {
        while (!stack.isEmpty()) {
            consumer.accept(stack.pop());
        }
    }

}
