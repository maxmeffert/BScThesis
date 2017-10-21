package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast;

import java.util.LinkedList;
import java.util.List;

public class JavaClassFragmentAST extends ModifiedJavaFragmentAST {

    private List<JavaFieldFragmentAST> javaFieldFragments = new LinkedList<>();
    private List<JavaMethodFragmentAST> javaMethodFragments = new LinkedList<>();

    public List<JavaFieldFragmentAST> getJavaFieldFragments() {
        return javaFieldFragments;
    }

    public void addJavaFieldFragment(JavaFieldFragmentAST java8FieldFragment) {
        javaFieldFragments.add(java8FieldFragment);
        addChild(java8FieldFragment);
    }

    public List<JavaMethodFragmentAST> getJavaMethodFragments() {
        return javaMethodFragments;
    }

    public void addJavaMethodFragment(JavaMethodFragmentAST java8MethodFragment) {
        javaMethodFragments.add(java8MethodFragment);
        addChild(java8MethodFragment);
    }
}
