package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.readers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.positions.IFragmentPosition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public interface IFragmentReader {
    String read(String contents, IFragmentPosition fragmentPosition) throws IOException;
    String read(File file, IFragmentPosition fragmentPosition) throws IOException;
    String read(InputStream inputStream, IFragmentPosition fragmentPosition) throws IOException;
    String read(String contents, IFragment fragment) throws IOException;
    String read(File file, IFragment fragment) throws IOException;
    String read(InputStream inputStream, IFragment fragment) throws IOException;
    String read(URI uri) throws IOException;
}
