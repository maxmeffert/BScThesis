package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.CharStream;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public interface IAntlrCharStreamFactory {
    CharStream newCharStream(InputStream inputStream) throws IOException;
}
