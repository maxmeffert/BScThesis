package org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrConfiguration;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParser;

import java.util.Collection;

public interface ILanguageFactory {
    ILanguage newLanguage(String name, IParser parser);
}
