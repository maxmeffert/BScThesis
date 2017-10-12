package org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;

public interface ILanguageFactory {
    ILanguage newLanguage(String name, IParser parser);
}
