package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fast;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;

public class Java8ClassFragment extends Java8Fragment {

    private final List<Java8FieldFragment> fields;
    private final List<Java8MethodFragment> methods;

    public Java8ClassFragment(String identifier, String text, List<Java8FieldFragment> fields, List<Java8MethodFragment> methods) {
        super(identifier, text, Lists.newLinkedList(Iterables.concat(fields, methods)));
        this.fields = fields;
        this.methods = methods;
    }

    public List<Java8FieldFragment> getFields() {
        return fields;
    }

    public List<Java8MethodFragment> getMethods() {
        return methods;
    }
}
