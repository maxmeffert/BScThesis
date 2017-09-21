package org.softlang.maxmeffert.bscthesis.antlr;

public class AntlrConfigurationBuilderFactory implements IAntlrConfigurationBuilderFactory {

    @Override
    public IAntlrConfigurationBuilder newAntlrConfigurationBuilder() {
        return new AntlrConfigurationBuilder(
                new AntlrCharStreamFactory(),
                null,
                new AntlrCommonTokenStreamFactory(),
                null);
    }
}
