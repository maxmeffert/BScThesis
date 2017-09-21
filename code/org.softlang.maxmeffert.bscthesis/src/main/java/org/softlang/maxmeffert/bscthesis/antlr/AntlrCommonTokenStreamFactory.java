package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

public class AntlrCommonTokenStreamFactory implements IAntlrTokenStreamFactory {
    @Override
    public TokenStream newTokenStream(Lexer lexer) {
        return new CommonTokenStream(lexer);
    }
}
