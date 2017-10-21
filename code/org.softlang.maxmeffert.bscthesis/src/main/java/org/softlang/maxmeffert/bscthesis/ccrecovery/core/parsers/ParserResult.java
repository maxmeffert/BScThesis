package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;

public class ParserResult implements IParserResult {

    private final boolean hasAcceptedInput;
    private final IFragmentAST fragmentAST;
    private final Exception exception;

    public ParserResult(boolean hasAcceptedInput, IFragmentAST fragmentAST, Exception exception) {
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
    public IFragmentAST getFragmentAST() {
        return fragmentAST;
    }

    @Override
    public Exception getParserException() {
        return exception;
    }
}
