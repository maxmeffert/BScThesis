package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments;

import java.util.LinkedList;
import java.util.List;

public abstract class ModifiedJavaFragmentAST extends IdentifiedJavaFragmentAST {

    private List<JavaModifierFragmentAST> javaModifierFragments = new LinkedList<>();

    public List<JavaModifierFragmentAST> getJavaModifierFragments() {
        return javaModifierFragments;
    }

    public void addJavaModifierFragment(JavaModifierFragmentAST java8ModifierFragment) {
        javaModifierFragments.add(java8ModifierFragment);
        addChild(java8ModifierFragment);
    }
}
