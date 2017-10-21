package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;

public interface IParserResult {
    boolean hasAcceptedInput();
    boolean hasNotAcceptedInput();
    IFragmentAST getFragmentAST();
    Exception getParserException();
}
