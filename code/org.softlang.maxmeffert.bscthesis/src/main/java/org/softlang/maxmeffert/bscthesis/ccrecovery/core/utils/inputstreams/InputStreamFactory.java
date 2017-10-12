package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.inputstreams;

import java.io.*;

public class InputStreamFactory implements IInputStreamFactory {
    @Override
    public InputStream newInputStream(String string) {
        return new ByteArrayInputStream(string.getBytes());
    }

    @Override
    public InputStream newInputStream(File file) throws IOException {
        return new FileInputStream(file);
    }
}
