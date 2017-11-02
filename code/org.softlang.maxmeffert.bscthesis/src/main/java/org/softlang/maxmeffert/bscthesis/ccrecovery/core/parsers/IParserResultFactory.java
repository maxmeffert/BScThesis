package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentAST;

public interface IParserResultFactory {
    IParserResult notAccepted(Exception exception);
    IParserResult accepted(IFragmentAST fragmentAST);
}
