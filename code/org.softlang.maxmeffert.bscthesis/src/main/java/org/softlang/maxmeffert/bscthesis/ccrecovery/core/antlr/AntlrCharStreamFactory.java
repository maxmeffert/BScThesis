package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;
import java.io.InputStream;

public class AntlrCharStreamFactory implements IAntlrCharStreamFactory {


    @Override
    public CharStream newCharStream(InputStream inputStream) throws IOException {
        return CharStreams.fromStream(inputStream);
    }

}
