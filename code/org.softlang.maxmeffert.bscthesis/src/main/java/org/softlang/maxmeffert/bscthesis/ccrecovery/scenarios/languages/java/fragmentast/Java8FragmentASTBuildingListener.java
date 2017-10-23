package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentASTBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.antlr.java8.Java8BaseListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.antlr.java8.Java8Parser;

import java.util.Stack;

public class Java8FragmentASTBuildingListener extends Java8BaseListener implements IFragmentASTBuildingListener {

    private final Java8FragmentASTFactory java8FragmentFactory = new Java8FragmentASTFactory();

    private Stack<JavaMethodFragmentAST> javaMethodFragments = new Stack<>();
    private Stack<JavaFieldFragmentAST> javaFieldFragments = new Stack<>();
    private Stack<JavaClassFragmentAST> javaClassFragments = new Stack<>();
    private Stack<JavaModifierFragmentAST> javaClassModifierFragments = new Stack<>();
    private Stack<JavaModifierFragmentAST> javaFieldModifierFragments = new Stack<>();
    private Stack<JavaModifierFragmentAST> javaMethodModifierFragments = new Stack<>();


    private IFragmentAST rootFragment;

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
        for (JavaFieldFragmentAST javaFieldFragment : java8FragmentFactory.newJavaFieldFragment(ctx, javaFieldModifierFragments)) {
            javaFieldFragments.push(javaFieldFragment);
        }
    }

    @Override
    public void exitMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        javaMethodFragments.push(java8FragmentFactory.newJavaMethodFragment(ctx, javaMethodModifierFragments));
    }

    @Override
    public void exitNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
        javaClassFragments.push(java8FragmentFactory.newJavaClassFragment(ctx, javaClassModifierFragments, javaFieldFragments, javaMethodFragments));
    }

    @Override
    public void exitCompilationUnit(Java8Parser.CompilationUnitContext ctx) {
        rootFragment = javaClassFragments.peek();
    }

    @Override
    public IFragmentAST getFragmentAST() {
        return rootFragment;
    }
}
