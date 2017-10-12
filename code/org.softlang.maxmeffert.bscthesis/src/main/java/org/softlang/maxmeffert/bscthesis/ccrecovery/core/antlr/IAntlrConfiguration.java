package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public interface IAntlrConfiguration {;
    IAntlrParsingResult parse(String string);
    IAntlrParsingResult parse(File file) throws IOException;
    IAntlrParsingResult parse(InputStream inputStream) throws IOException;
    IAntlrParsingResult parse(URI uri) throws IOException;
    IAntlrParsingResult parse(URL url) throws IOException;
}
