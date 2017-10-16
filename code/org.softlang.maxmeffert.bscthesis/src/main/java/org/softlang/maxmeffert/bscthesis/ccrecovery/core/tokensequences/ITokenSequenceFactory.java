package org.softlang.maxmeffert.bscthesis.ccrecovery.core.tokensequences;

import org.antlr.v4.runtime.TokenStream;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextInterval;

public interface ITokenSequenceFactory {
    ITokenSequence newTokenSequence(TokenStream tokenStream, ITextInterval textInterval);
}
