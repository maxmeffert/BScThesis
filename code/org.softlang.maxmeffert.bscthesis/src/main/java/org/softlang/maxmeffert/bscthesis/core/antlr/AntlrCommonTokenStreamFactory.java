package org.softlang.maxmeffert.bscthesis.core.antlr;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;

public class AntlrCommonTokenStreamFactory implements IAntlrTokenStreamFactory<CommonTokenStream> {
    @Override
    public CommonTokenStream newTokenStream(Lexer lexer) {
        return new CommonTokenStream(lexer);
    }
}
