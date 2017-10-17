package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public interface IParserResultFactory {
    IParserResult notAccepted(Exception exception);
    IParserResult accepted(IFragment fragmentAST);
}
