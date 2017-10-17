package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fast.IFragmentAST;

import java.util.LinkedList;
import java.util.List;

public class Java8FragmentFactory {
    public static Java8MethodFragment MethodFragment(String identifier) {
        return new Java8MethodFragment(identifier, new LinkedList<>());
    }

    public static Java8ClassFragment ClassFragment(String identifier, List<IFragmentAST> methods) {
        return new Java8ClassFragment(identifier, methods);
    }
}
