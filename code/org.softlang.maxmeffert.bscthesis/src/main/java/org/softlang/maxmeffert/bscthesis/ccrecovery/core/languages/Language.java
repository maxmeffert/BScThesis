package org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;

public class Language implements ILanguage {

    private final String name;
    private final IParser parser;

    public Language(String name, IParser parser) {
        this.name = name;
        this.parser = parser;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IParser getParser() {
        return parser;
    }

    @Override
    public int compareTo(ILanguage iLanguage) {
        return getName().toLowerCase().compareTo(iLanguage.getName().toLowerCase());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ILanguage) {
            return compareTo((ILanguage) obj) == 0;
        }
        return false;
    }
}
