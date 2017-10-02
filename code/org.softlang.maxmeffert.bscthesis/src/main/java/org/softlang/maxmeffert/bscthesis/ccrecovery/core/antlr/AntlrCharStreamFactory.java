package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.File;
import java.io.IOException;

public class AntlrCharStreamFactory implements IAntlrCharStreamFactory {
    @Override
    public CharStream newCharStreamFromString(String string) {
        return CharStreams.fromString(string);
    }

    @Override
    public CharStream newCharStreamFromFile(File file) throws IOException {
        return CharStreams.fromFileName(file.getName());
    }
}
