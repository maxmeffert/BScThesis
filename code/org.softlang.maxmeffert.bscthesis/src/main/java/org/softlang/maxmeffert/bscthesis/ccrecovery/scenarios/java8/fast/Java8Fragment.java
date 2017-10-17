package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fast.BaseFragment;

public class Java8Fragment extends BaseFragment {
    private final String identifier;

    public Java8Fragment(String identifier) {
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
