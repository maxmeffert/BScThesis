package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fast.FragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fast.IFragmentAST;

import java.util.List;

public class Java8Fragment extends FragmentAST {
    private final String identifier;

    public Java8Fragment(String identifier, List<IFragmentAST> children) {
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
