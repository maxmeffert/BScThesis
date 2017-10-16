package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.antlr.java8.fast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fast.FragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fast.IFragmentAST;

import java.util.List;

public class JavaFragment extends FragmentAST {
    private final String identifier;

    public JavaFragment(String identifier, List<IFragmentAST> children) {
        super(children);
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return identifier;
    }
}
