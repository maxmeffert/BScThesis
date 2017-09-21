package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;

public class AntlrConfigurationBuilderFactory implements IAntlrConfigurationBuilderFactory {
    @Override
    public <TLexer extends Lexer, TParser extends Parser> IAntlrConfigurationBuilder<TLexer, TParser> newAntlrConfigurationBuilder() {
        return new AntlrConfigurationBuilder<>(null,null,null, null, null);
    }
}
