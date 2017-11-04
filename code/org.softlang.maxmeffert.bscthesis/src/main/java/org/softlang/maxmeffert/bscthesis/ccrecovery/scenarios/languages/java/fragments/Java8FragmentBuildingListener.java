package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.antlr.java8.Java8BaseListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.antlr.java8.Java8Parser;

import java.util.Stack;

public class Java8FragmentBuildingListener extends Java8BaseListener implements IFragmentBuildingListener {

    private final Java8FragmentFactory java8FragmentFactory = new Java8FragmentFactory();

    private String declaredPackage = "";
    private Stack<JavaMethodFragment> javaMethodFragments = new Stack<>();
    private Stack<JavaFieldFragment> javaFieldFragments = new Stack<>();
    private Stack<JavaClassFragment> javaClassFragments = new Stack<>();
    private Stack<JavaModifierFragment> javaClassModifierFragments = new Stack<>();
    private Stack<JavaModifierFragment> javaFieldModifierFragments = new Stack<>();
    private Stack<JavaModifierFragment> javaMethodModifierFragments = new Stack<>();


    private IFragment rootFragment;

    @Override
    public void exitPackageDeclaration(Java8Parser.PackageDeclarationContext ctx) {
       declaredPackage = java8FragmentFactory.newPackageDeclaration(ctx);
    }

    @Override
    public void exitClassModifier(Java8Parser.ClassModifierContext ctx) {
        javaClassModifierFragments.push(java8FragmentFactory.newJavaModifierFragment(ctx));
    }

    @Override
    public void exitFieldModifier(Java8Parser.FieldModifierContext ctx) {
        javaFieldModifierFragments.push(java8FragmentFactory.newJavaModifierFragment(ctx));
    }

    @Override
    public void exitMethodModifier(Java8Parser.MethodModifierContext ctx) {
        javaMethodModifierFragments.push(java8FragmentFactory.newJavaModifierFragment(ctx));
    }

    @Override
    public void exitFieldDeclaration(Java8Parser.FieldDeclarationContext ctx) {
        for (JavaFieldFragment javaFieldFragment : java8FragmentFactory.newJavaFieldFragment(ctx, javaFieldModifierFragments)) {
            javaFieldFragments.push(javaFieldFragment);
        }
    }

    @Override
    public void exitMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        javaMethodFragments.push(java8FragmentFactory.newJavaMethodFragment(ctx, javaMethodModifierFragments));
    }

    @Override
    public void exitNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
        javaClassFragments.push(java8FragmentFactory.newJavaClassFragment(ctx, javaClassModifierFragments, javaFieldFragments, javaMethodFragments, declaredPackage));
    }

    @Override
    public void exitCompilationUnit(Java8Parser.CompilationUnitContext ctx) {
        rootFragment = javaClassFragments.peek();
    }

    @Override
    public IFragment getFragment() {
        return rootFragment;
    }
}
