package org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages.ILanguage;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Artifact implements IArtifact {

    private final ILanguage language;
    private final InputStream contents;

    public Artifact(ILanguage language, InputStream contents) {
        this.language = language;
        this.contents = contents;
    }

    @Override
    public ILanguage getLanguage() {
        return language;
    }

    @Override
    public InputStream getContents() {
        return contents;
    }

    @Override
    public ITree<ITextSource> getParseTree() throws IOException {
        return getLanguage().getParser().parse(getContents());
    }

}
