package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;

public interface IAntlrParserFactory<TParser extends Parser> {
    TParser newParser(TokenStream tokenStream);
}
