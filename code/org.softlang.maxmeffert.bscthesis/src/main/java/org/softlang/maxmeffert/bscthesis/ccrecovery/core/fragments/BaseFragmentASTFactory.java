package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.FragmentPosition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPosition;

import java.util.Stack;
import java.util.function.Consumer;

public abstract class BaseFragmentASTFactory {

    protected String textOf(ParserRuleContext parserRuleContext) {
        int a = parserRuleContext.start.getStartIndex();
        int b = parserRuleContext.stop.getStopIndex();
        return parserRuleContext.getStart().getInputStream().getText(Interval.of(a,b)); //.replace(System.lineSeparator(), "");
    }

    protected IFragmentPosition positionOf(ParserRuleContext parserRuleContext) {
        int startLine = parserRuleContext.getStart().getLine();
        int startInLine = parserRuleContext.getStart().getCharPositionInLine();
        int stopLine = parserRuleContext.getStop().getLine();
        int stopInLine = parserRuleContext.getStop().getCharPositionInLine() + parserRuleContext.getStop().getText().length();
        return new FragmentPosition(startLine, startInLine, stopLine, stopInLine);
    }

    protected <TFragment extends IFragmentAST> TFragment initialize(TFragment fragment, ParserRuleContext parserRuleContext) {
        fragment.setText(textOf(parserRuleContext));
        fragment.setPosition(positionOf(parserRuleContext));
        return fragment;
    }

    protected <T> void popEach(Stack<T> stack, Consumer<T> consumer) {
        while (!stack.isEmpty()) {
            consumer.accept(stack.pop());
        }
    }

}
