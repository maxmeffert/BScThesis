package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public interface IParserResult {
    boolean hasAcceptedInput();
    boolean hasNotAcceptedInput();
    IFragment getFragmentAST();
    Exception getParserException();
}
