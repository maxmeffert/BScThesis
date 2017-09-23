package org.softlang.maxmeffert.bscthesis.fragments;

import org.softlang.maxmeffert.bscthesis.text.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.graphs.trees.ITreeWalkerListener;

public interface IFragmentKBBuildingParseTreeListener extends ITreeWalkerListener<ITextSource> {

    IFragmentKB getFragmentKB();
}
