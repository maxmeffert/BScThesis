package org.softlang.maxmeffert.bscthesis;

import org.softlang.maxmeffert.bscthesis.text.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.trees.ITree;

public class Language implements ILanguage {
    @Override
    public boolean accept(String string) {
        return false;
    }

    @Override
    public ITree<ITextSource> parse(String string) {
        return null;
    }
}
