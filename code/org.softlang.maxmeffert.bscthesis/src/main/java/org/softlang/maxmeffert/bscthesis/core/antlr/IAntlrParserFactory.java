package org.softlang.maxmeffert.bscthesis.core.antlr;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;

public interface IAntlrParserFactory<TParser extends Parser> {
    TParser newParser(TokenStream tokenStream);
}
