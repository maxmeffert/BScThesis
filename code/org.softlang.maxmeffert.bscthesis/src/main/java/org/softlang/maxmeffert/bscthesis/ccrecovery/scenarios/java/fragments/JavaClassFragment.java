package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.fragments;

import java.util.LinkedList;
import java.util.List;

public class JavaClassFragment extends ModifiedJavaFragment {

    private List<JavaFieldFragment> java8FieldFragments = new LinkedList<>();
    private List<JavaMethodFragment> java8MethodFragments = new LinkedList<>();

    public List<JavaFieldFragment> getJava8FieldFragments() {
        return java8FieldFragments;
    }

    public void addJava8FieldFragment(JavaFieldFragment java8FieldFragment) {
        java8FieldFragments.add(java8FieldFragment);
        addChild(java8FieldFragment);
    }

    public List<JavaMethodFragment> getJava8MethodFragments() {
        return java8MethodFragments;
    }

    public void addJava8MethodFragment(JavaMethodFragment java8MethodFragment) {
        java8MethodFragments.add(java8MethodFragment);
        addChild(java8MethodFragment);
    }
}
