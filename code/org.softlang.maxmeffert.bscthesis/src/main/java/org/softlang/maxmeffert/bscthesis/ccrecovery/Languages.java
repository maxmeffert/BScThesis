package org.softlang.maxmeffert.bscthesis.ccrecovery;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrConfigurationFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguageFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers.IParserFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.Java8Lexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.Java8Parser;

public class Languages implements ILanguages {

    private final ILanguageFactory languageFactory;
    private final IParserFactory parserFactory;
    private final IAntlrConfigurationFactory antlrConfigurationFactory;

    @Inject
    public Languages(ILanguageFactory languageFactory, IParserFactory parserFactory, IAntlrConfigurationFactory antlrConfigurationFactory) {
        this.languageFactory = languageFactory;
        this.parserFactory = parserFactory;
        this.antlrConfigurationFactory = antlrConfigurationFactory;
    }

    @Override
    public ILanguage getJava8() {
        return languageFactory.newLanguage("Java8", parserFactory.newParser(antlrConfigurationFactory.newAntlrConfiguration(Java8Lexer::new, Java8Parser::new, Java8Parser::compilationUnit)));
    }
}
