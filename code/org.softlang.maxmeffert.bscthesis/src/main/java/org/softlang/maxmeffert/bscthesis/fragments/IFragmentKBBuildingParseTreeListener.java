package org.softlang.maxmeffert.bscthesis.fragments;

import org.softlang.maxmeffert.bscthesis.simpleparsetrees.ISimpleParseTreeWalkerListener;

public interface IFragmentKBBuildingParseTreeListener extends ISimpleParseTreeWalkerListener {

    IFragmentKB getFragmentKB();
}
