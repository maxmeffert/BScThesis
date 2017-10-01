package org.softlang.maxmeffert.bscthesis.languages;

import org.softlang.maxmeffert.bscthesis.antlr.IAntlrParsingConfiguration;

import java.util.Collection;

public class LanguageBuilder implements ILanguageBuilder {

    private final String name;

    public LanguageBuilder(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Collection<String> getFileExtensions() {
        return null;
    }

    @Override
    public IAntlrParsingConfiguration getAntlrParsingConfiguration() {
        return null;
    }

    @Override
    public ILanguageBuilder withName(String name) {
        return null;
    }

    @Override
    public ILanguageBuilder withFileExtensions(String... fileExtension) {
        return null;
    }

    @Override
    public ILanguageBuilder withAntlrParsingConfiguration(IAntlrParsingConfiguration antlrParsingConfiguration) {
        return null;
    }

    @Override
    public ILanguage build() {
        return null;
    }
}
