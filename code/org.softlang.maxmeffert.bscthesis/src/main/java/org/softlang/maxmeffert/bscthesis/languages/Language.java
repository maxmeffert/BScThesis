package org.softlang.maxmeffert.bscthesis.languages;

import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.trees.ITree;

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
