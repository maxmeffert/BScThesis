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
    public CharStream newCharStream(String string) {
        return CharStreams.fromString(string);
    }

    @Override
    public CharStream newCharStream(File file) throws IOException {
        return CharStreams.fromFileName(file.getName());    }


    @Override
    public CharStream newCharStream(InputStream inputStream) throws IOException {
        return CharStreams.fromStream(inputStream);
    }

    @Override
    public CharStream newCharStream(URI uri) throws IOException {
        return newCharStream(uri.toURL());
    }

    @Override
    public CharStream newCharStream(URL url) throws IOException {
        return newCharStream(url.openStream());
    }
}
