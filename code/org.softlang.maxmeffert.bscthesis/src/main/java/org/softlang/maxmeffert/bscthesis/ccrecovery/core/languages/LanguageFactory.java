package org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;

public class LanguageFactory implements ILanguageFactory {

    @Override
    public ILanguage newLanguate(String name, IParser parser) {
        return new Language(name, parser);
    }
}
