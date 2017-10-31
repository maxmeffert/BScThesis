package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmenttexts;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentPosition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface IFragmentReader {
    String read(String contents, IFragmentPosition position) throws IOException;
    String read(File file, IFragmentPosition position) throws IOException;
    String read(InputStream inputStream, IFragmentPosition position) throws IOException;

}
