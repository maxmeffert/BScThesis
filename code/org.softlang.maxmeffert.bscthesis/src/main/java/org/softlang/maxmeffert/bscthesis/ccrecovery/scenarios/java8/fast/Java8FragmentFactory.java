package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fast.IFragmentAST;

import java.util.List;

public class Java8FragmentFactory {

    public Java8FieldFragment newJava8FieldFragment(String identifier) {
        return new Java8FieldFragment(identifier);
    }

    public Java8MethodFragment newJava8MethodFragment(String identifier) {
        return new Java8MethodFragment(identifier);
    }

    public Java8ClassFragment newJava8ClassFragment(String identifier, List<Java8FieldFragment> fields, List<Java8MethodFragment> methods) {
        return new Java8ClassFragment(identifier, fields, methods);
    }
}
