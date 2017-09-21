package org.softlang.maxmeffert.bscthesis.fragments;

import org.softlang.maxmeffert.bscthesis.textsources.ITextSource;
import org.softlang.maxmeffert.bscthesis.trees.ITreeWalkerListener;

public interface IFragmentKBBuildingParseTreeListener extends ITreeWalkerListener<ITextSource> {

    IFragmentKB getFragmentKB();
}
