package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrTextReader;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.FragmentPosition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPosition;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPositionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.ioc.IoC;

import java.util.Stack;
import java.util.function.Consumer;

public abstract class BaseFragmentFactory {

    protected final IAntlrTextReader antlrTextReader = IoC.get(IAntlrTextReader.class);
    protected final IFragmentPositionFactory fragmentPositionFactory = IoC.get(IFragmentPositionFactory.class);

    protected String textOf(ParserRuleContext parserRuleContext) {
        return antlrTextReader.readTextOf(parserRuleContext);
    }

    protected IFragmentPosition positionOf(ParserRuleContext parserRuleContext) {
        return fragmentPositionFactory.newFragmentPosition(parserRuleContext);
    }

    protected <TFragment extends IFragment> TFragment initialize(TFragment fragment, ParserRuleContext parserRuleContext) {
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
