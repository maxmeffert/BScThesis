package org.softlang.maxmeffert.bscthesis.fragments;

import org.softlang.maxmeffert.bscthesis.simpleparsetrees.ISimpleParseTree;

public interface IFragmentKBFactory {

    IFragmentKB newFragmentKB(ISimpleParseTree simpleParseTree);

}
