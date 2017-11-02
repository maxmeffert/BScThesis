package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentAST;

public interface IParserResult {
    boolean hasAcceptedInput();
    boolean hasNotAcceptedInput();
    IFragmentAST getFragmentAST();
    Exception getParserException();
}
