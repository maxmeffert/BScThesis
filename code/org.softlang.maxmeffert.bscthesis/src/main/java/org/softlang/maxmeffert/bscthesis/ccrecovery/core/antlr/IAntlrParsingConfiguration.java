package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import java.io.IOException;
import java.io.InputStream;

public interface IAntlrParsingConfiguration {;

    IAntlrParsingResult parse(InputStream inputStream) throws IOException;

}
