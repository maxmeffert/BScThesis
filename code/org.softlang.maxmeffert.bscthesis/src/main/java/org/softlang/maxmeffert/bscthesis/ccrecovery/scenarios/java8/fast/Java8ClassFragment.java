package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fast;

import java.util.LinkedList;
import java.util.List;

public class Java8ClassFragment extends Java8Fragment {

    private List<Java8FieldFragment> fields = new LinkedList<>();
    private List<Java8MethodFragment> methods = new LinkedList<>();

    public List<Java8FieldFragment> getFields() {
        return fields;
    }

    public void addField(Java8FieldFragment field) {
        fields.add(field);
        addChild(field);
    }

    public List<Java8MethodFragment> getMethods() {
        return methods;
    }

    public void addMethod(Java8MethodFragment method) {
        methods.add(method);
        addChild(method);
    }
}
