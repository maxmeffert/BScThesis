package org.softlang.maxmeffert.bscthesis.core.languages;

import org.softlang.maxmeffert.bscthesis.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.core.trees.ITree;

import java.io.File;

public class Language implements ILanguage {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean accept(String string) {
        return false;
    }

    @Override
    public boolean acceptFile(File file) {
        return false;
    }

    @Override
    public ITree<ITextSource> parse(String string) {
        return null;
    }

    @Override
    public ITree<ITextSource> parseFile(File file) {
        return null;
    }
}
