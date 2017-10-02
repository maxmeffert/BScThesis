package org.softlang.maxmeffert.bscthesis.core.antlr;

import org.antlr.v4.runtime.CharStream;

import java.io.File;
import java.io.IOException;

public interface IAntlrCharStreamFactory {
    CharStream newCharStreamFromString(String string);
    CharStream newCharStreamFromFile(File file) throws IOException;
}
