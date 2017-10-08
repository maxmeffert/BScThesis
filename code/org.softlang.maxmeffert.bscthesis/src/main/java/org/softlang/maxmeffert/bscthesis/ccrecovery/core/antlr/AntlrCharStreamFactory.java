package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public class AntlrCharStreamFactory implements IAntlrCharStreamFactory {
    @Override
    public CharStream newCharStreamFromString(String string) {
        return CharStreams.fromString(string);
    }

    @Override
    public CharStream newCharStreamFromFile(File file) throws IOException {
        return newCharStreamFromFilename(file.getName());
    }

    @Override
    public CharStream newCharStreamFromFilename(String filename) throws IOException {
        return CharStreams.fromFileName(filename);
    }

    @Override
    public CharStream newCharStreamFromInputStream(InputStream inputStream) throws IOException {
        return CharStreams.fromStream(inputStream);
    }

    @Override
    public CharStream newCharStreamFromURI(URI uri) throws IOException {
        return newCharStreamFromURL(uri.toURL());
    }

    @Override
    public CharStream newCharStreamFromURL(URL url) throws IOException {
        return newCharStreamFromInputStream(url.openStream());
    }
}
