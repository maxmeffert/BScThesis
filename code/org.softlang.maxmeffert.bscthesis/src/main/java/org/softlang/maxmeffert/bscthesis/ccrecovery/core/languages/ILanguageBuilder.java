package org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParsingConfiguration;

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
