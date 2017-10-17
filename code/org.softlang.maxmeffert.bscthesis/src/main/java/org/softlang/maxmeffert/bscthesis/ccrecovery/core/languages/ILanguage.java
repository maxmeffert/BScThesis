package org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;

public interface ILanguage extends Comparable<ILanguage> {
    String getName();
    IParser getParser();
}
