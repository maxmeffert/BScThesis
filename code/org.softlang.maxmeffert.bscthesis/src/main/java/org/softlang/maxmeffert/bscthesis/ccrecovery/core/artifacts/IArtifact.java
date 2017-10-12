package org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public interface IArtifact {
    ILanguage getLanguage();
    InputStream getContents();
    ITree<ITextSource> getParseTree() throws IOException;
}
