package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fragments;

import java.util.LinkedList;
import java.util.List;

public class Java8ClassFragment extends ModifiedJava8Fragment {

    private List<Java8FieldFragment> java8FieldFragments = new LinkedList<>();
    private List<Java8MethodFragment> java8MethodFragments = new LinkedList<>();

    public List<Java8FieldFragment> getJava8FieldFragments() {
        return java8FieldFragments;
    }

    public void addJava8FieldFragment(Java8FieldFragment java8FieldFragment) {
        java8FieldFragments.add(java8FieldFragment);
        addChild(java8FieldFragment);
    }

    public List<Java8MethodFragment> getJava8MethodFragments() {
        return java8MethodFragments;
    }

    public void addJava8MethodFragment(Java8MethodFragment java8MethodFragment) {
        java8MethodFragments.add(java8MethodFragment);
        addChild(java8MethodFragment);
    }
}
