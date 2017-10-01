package org.softlang.maxmeffert.bscthesis.languages;

import org.softlang.maxmeffert.bscthesis.graphs.ITree;
import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;

import java.io.File;

public interface ILanguage {
    String getName();
    boolean accept(String string);
    boolean acceptFile(File file);
    ITree<ITextSource> parse(String string);
    ITree<ITextSource> parseFile(File file);
}
