package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public class ParserResult implements IParserResult {

    private final boolean hasAcceptedInput;
    private final IFragment fragmentAST;
    private final Exception exception;

    public ParserResult(boolean hasAcceptedInput, IFragment fragmentAST, Exception exception) {
        this.hasAcceptedInput = hasAcceptedInput;
        this.fragmentAST = fragmentAST;
        this.exception = exception;
    }

    @Override
    public boolean hasAcceptedInput() {
        return hasAcceptedInput;
    }

    @Override
    public boolean hasNotAcceptedInput() {
        return !hasAcceptedInput();
    }

    @Override
    public IFragment getFragmentAST() {
        return fragmentAST;
    }

    @Override
    public Exception getParserException() {
        return exception;
    }
}
