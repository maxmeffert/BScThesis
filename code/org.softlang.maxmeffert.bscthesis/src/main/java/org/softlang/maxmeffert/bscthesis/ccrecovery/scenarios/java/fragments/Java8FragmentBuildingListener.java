package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.antlr.java8.Java8BaseListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.antlr.java8.Java8Parser;

import java.util.Stack;

public class Java8FragmentBuildingListener extends Java8BaseListener implements IFragmentBuildingListener {

    private final Java8FragmentFactory java8FragmentFactory = new Java8FragmentFactory();

    private Stack<JavaMethodFragment> java8MethodFragments = new Stack<>();
    private Stack<JavaFieldFragment> java8FieldFragments = new Stack<>();
    private Stack<JavaClassFragment> java8ClassFragments = new Stack<>();
    private Stack<JavaModifierFragment> java8ClassModifierFragments = new Stack<>();
    private Stack<JavaModifierFragment> java8FieldModifierFragments = new Stack<>();
    private Stack<JavaModifierFragment> java8MethodModifierFragments = new Stack<>();


    private IFragment rootFragment;

    @Override
    public void exitClassModifier(Java8Parser.ClassModifierContext ctx) {
        java8ClassModifierFragments.push(java8FragmentFactory.newJavaModifierFragment(ctx));
    }

    @Override
    public void exitFieldModifier(Java8Parser.FieldModifierContext ctx) {
        java8FieldModifierFragments.push(java8FragmentFactory.newJavaModifierFragment(ctx));
    }

    @Override
    public void exitMethodModifier(Java8Parser.MethodModifierContext ctx) {
        java8MethodModifierFragments.push(java8FragmentFactory.newJavaModifierFragment(ctx));
    }

    @Override
    public void exitFieldDeclaration(Java8Parser.FieldDeclarationContext ctx) {
        for (JavaFieldFragment java8FieldFragment : java8FragmentFactory.newJavaFieldFragment(ctx)) {
            java8FieldFragments.push(java8FieldFragment);
        }
    }

    @Override
    public void exitMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        java8MethodFragments.push(java8FragmentFactory.newJavaMethodFragment(ctx));
    }

    @Override
    public void exitNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
        java8ClassFragments.push(java8FragmentFactory.newJavaClassFragment(ctx, java8ClassModifierFragments, java8FieldFragments, java8MethodFragments));
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
