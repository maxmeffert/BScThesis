package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fast;

import org.antlr.v4.runtime.tree.ParseTreeListener;

public interface IFragmentBuildingListener extends ParseTreeListener {
    IFragmentAST getFragment();
}
