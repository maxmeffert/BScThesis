package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import org.antlr.v4.runtime.tree.ParseTreeListener;

public interface IFragmentBuildingListener extends ParseTreeListener {
    IFragment getFragment();
}
