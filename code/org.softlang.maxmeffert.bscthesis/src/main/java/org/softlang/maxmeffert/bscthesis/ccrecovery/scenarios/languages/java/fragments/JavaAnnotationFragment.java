package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class JavaAnnotationFragment extends IdentifiedJavaFragment {

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

    public boolean hasNamedParameter(String name) {
        return namedParameters.containsKey(name);
    }

    public String getNamedParamterValue(String name) {
        return namedParameters.get(name);
    }

    public void addUnnamedParameter(String value) {
        unnamedParameters.add(value);
    }
}
