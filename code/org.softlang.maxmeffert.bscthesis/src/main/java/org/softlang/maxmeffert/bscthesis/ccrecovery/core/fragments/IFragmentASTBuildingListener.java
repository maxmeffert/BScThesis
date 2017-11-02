package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts;

import org.antlr.v4.runtime.tree.ParseTreeListener;

public interface IFragmentASTBuildingListener extends ParseTreeListener {
    IFragmentAST getFragmentAST();
}
