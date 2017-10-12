package org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.inputstreams;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface IInputStreamFactory {
    InputStream newInputStream(String string);
    InputStream newInputStream(File file) throws IOException;
}
