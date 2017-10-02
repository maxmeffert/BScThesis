package org.softlang.maxmeffert.bscthesis.ccrecovery.core.languages;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

import java.io.File;

public interface ILanguage {
    String getName();
    boolean accept(String string);
    boolean acceptFile(File file);
    ITree<ITextSource> parse(String string);
    ITree<ITextSource> parseFile(File file);
}
