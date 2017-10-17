package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.Fragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;

import java.util.List;

public class Java8Fragment extends Fragment {
    private final String identifier;

    public Java8Fragment(String identifier, String text, List<IFragment> children) {
        super(text, children);
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
