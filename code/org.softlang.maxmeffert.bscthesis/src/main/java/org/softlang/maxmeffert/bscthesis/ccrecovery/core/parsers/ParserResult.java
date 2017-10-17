package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees.IParseTree;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

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
