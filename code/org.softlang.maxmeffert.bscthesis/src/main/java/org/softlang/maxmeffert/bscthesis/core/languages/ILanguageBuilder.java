package org.softlang.maxmeffert.bscthesis.core.languages;

import org.softlang.maxmeffert.bscthesis.core.antlr.IAntlrParsingConfiguration;

import java.util.Collection;

public interface ILanguageBuilder {
    String getName();
    Collection<String> getFileExtensions();
    IAntlrParsingConfiguration getAntlrParsingConfiguration();
    ILanguageBuilder withName(String name);
    ILanguageBuilder withFileExtensions(String... fileExtension);
    ILanguageBuilder withAntlrParsingConfiguration(IAntlrParsingConfiguration antlrParsingConfiguration);
    ILanguage build();
}
