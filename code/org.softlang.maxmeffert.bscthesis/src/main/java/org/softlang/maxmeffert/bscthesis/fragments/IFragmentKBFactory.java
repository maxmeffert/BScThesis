package org.softlang.maxmeffert.bscthesis.fragments;

import org.antlr.v4.runtime.tree.ParseTree;

public interface IFragmentKBFactory {

    IFragmentKB newFragmentKB(ParseTree parseTree);

}
