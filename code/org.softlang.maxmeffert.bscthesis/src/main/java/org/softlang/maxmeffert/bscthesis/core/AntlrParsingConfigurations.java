package org.softlang.maxmeffert.bscthesis.core;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.core.antlr.IAntlrParsingConfiguration;
import org.softlang.maxmeffert.bscthesis.core.antlr.IAntlrConfigurationFactory;
import org.softlang.maxmeffert.bscthesis.core.java8.Java8Lexer;
import org.softlang.maxmeffert.bscthesis.core.java8.Java8Parser;

public class AntlrParsingConfigurations implements IAntlrParsingConfigurations {

    private final IAntlrConfigurationFactory antlrConfigurationFactory;

    @Inject
    public AntlrParsingConfigurations(IAntlrConfigurationFactory antlrConfigurationFactory) {
        this.antlrConfigurationFactory = antlrConfigurationFactory;
    }

    @Override
    public IAntlrParsingConfiguration newJava8Configuration() {
        return antlrConfigurationFactory.newAntlrConfiguration(Java8Lexer::new, Java8Parser::new, Java8Parser::compilationUnit);
    }
}
