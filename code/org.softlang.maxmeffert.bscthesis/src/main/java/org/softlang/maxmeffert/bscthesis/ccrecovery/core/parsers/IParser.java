package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsers;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public interface IParser {
    ITree<ITextSource> parse(String string);
    ITree<ITextSource> parse(File file) throws IOException;
    ITree<ITextSource> parse(InputStream inputStream) throws IOException;
    ITree<ITextSource> parse(URI uri) throws IOException;
    ITree<ITextSource> parse(URL url) throws IOException;
}
