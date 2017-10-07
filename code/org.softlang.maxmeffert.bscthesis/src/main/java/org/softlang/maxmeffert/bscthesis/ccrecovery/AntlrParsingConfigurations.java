package org.softlang.maxmeffert.bscthesis.ccrecovery;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrParsingConfiguration;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr.IAntlrConfigurationFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.Java8Lexer;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.Java8Parser;

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
