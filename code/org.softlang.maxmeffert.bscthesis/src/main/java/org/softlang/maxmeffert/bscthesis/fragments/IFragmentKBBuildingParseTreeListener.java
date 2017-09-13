package org.softlang.maxmeffert.bscthesis.fragments;

import org.antlr.v4.runtime.tree.ParseTreeListener;

public interface IFragmentKBBuildingParseTreeListener extends ParseTreeListener {

    IFragmentKB getFragmentKB();
}
