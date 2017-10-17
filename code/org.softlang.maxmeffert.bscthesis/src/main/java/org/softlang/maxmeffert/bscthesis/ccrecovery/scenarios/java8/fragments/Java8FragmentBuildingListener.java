package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.antlr.Java8BaseListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.antlr.Java8Parser;

import java.util.Stack;

public class Java8FragmentBuildingListener extends Java8BaseListener implements IFragmentBuildingListener {

    private final Java8FragmentFactory java8FragmentFactory = new Java8FragmentFactory();

    private Stack<Java8MethodFragment> java8MethodFragments = new Stack<>();
    private Stack<Java8FieldFragment> java8FieldFragments = new Stack<>();
    private Stack<Java8ClassFragment> java8ClassFragments = new Stack<>();
    private Stack<Java8ModifierFragment> java8ClassModifierFragments = new Stack<>();
    private Stack<Java8ModifierFragment> java8FieldModifierFragments = new Stack<>();
    private Stack<Java8ModifierFragment> java8MethodModifierFragments = new Stack<>();


    private IFragment rootFragment;

    @Override
    public void exitClassModifier(Java8Parser.ClassModifierContext ctx) {
        java8ClassModifierFragments.push(java8FragmentFactory.newJava8ModifierFragment(ctx));
    }

    @Override
    public void exitFieldModifier(Java8Parser.FieldModifierContext ctx) {
        java8FieldModifierFragments.push(java8FragmentFactory.newJava8ModifierFragment(ctx));
    }

    @Override
    public void exitMethodModifier(Java8Parser.MethodModifierContext ctx) {
        java8MethodModifierFragments.push(java8FragmentFactory.newJava8ModifierFragment(ctx));
    }

    @Override
    public void exitFieldDeclaration(Java8Parser.FieldDeclarationContext ctx) {
        for (Java8FieldFragment java8FieldFragment : java8FragmentFactory.newJava8FieldFragment(ctx)) {
            java8FieldFragments.push(java8FieldFragment);
        }
    }

    @Override
    public void exitMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        java8MethodFragments.push(java8FragmentFactory.newJava8MethodFragment(ctx));
    }

    @Override
    public void exitNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
        java8ClassFragments.push(java8FragmentFactory.newJava8ClassFragment(ctx, java8ClassModifierFragments, java8FieldFragments, java8MethodFragments));
    }

    @Override
    public void exitCompilationUnit(Java8Parser.CompilationUnitContext ctx) {
        rootFragment = java8ClassFragments.peek();
    }

    @Override
    public IFragment getFragment() {
        return rootFragment;
    }
}
