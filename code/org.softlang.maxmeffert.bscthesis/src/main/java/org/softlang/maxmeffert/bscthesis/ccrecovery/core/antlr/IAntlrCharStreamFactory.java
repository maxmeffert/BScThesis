package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.CharStream;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public interface IAntlrCharStreamFactory {
    CharStream newCharStreamFromString(String string);
    CharStream newCharStreamFromFile(File file) throws IOException;
    CharStream newCharStreamFromFilename(String filename) throws IOException;
    CharStream newCharStreamFromInputStream(InputStream inputStream) throws IOException;
    CharStream newCharStreamFromURI(URI uri) throws IOException;
    CharStream newCharStreamFromURL(URL url) throws IOException;
}
