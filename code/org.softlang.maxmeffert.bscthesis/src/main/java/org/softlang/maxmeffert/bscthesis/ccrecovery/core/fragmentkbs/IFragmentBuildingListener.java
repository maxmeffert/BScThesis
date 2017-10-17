package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs;

import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

public interface IFragmentBuildingListener extends ParseTreeListener {
    IFragment getFragment();
}
