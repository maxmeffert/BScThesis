package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fast;

import com.google.common.collect.Lists;

import java.util.List;

public class Java8FragmentFactory {

    public Java8FieldFragment newJava8FieldFragment(String identifier, String text) {
        return new Java8FieldFragment(identifier, text, Lists.newLinkedList());
    }

    public Java8MethodFragment newJava8MethodFragment(String identifier, String text) {
        return new Java8MethodFragment(identifier, text, Lists.newLinkedList());
    }

    public Java8ClassFragment newJava8ClassFragment(String identifier, List<Java8FieldFragment> fields, List<Java8MethodFragment> methods, String text) {
        return new Java8ClassFragment(identifier, text, fields, methods);
    }
}
