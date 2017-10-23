package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JavaAnnotationFragmentAST extends IdentifiedJavaFragmentAST {

    private final Map<String, String> namedParameters = Maps.newHashMap();
    private final List<String> unnamedParameters = Lists.newLinkedList();

    public Map<String, String> getNamedParameters() {
        return namedParameters;
    }

    public List<String> getUnnamedParameters() {
        return unnamedParameters;
    }

    public void addNamedParameter(String name, String value) {
        namedParameters.put(name, value);
    }

    public void addUnnamedParameter(String value) {
        unnamedParameters.add(value);
    }
}
