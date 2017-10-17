package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.antlr.Java8BaseListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.antlr.Java8Parser;

import java.util.Stack;

public class Java8FragmentBuildingListener extends Java8BaseListener implements IFragmentBuildingListener {

    private final Java8FragmentFactory java8FragmentFactory = new Java8FragmentFactory();

    private Stack<Java8MethodFragment> methods = new Stack<>();
    private Stack<Java8FieldFragment> fields = new Stack<>();
    private Stack<Java8ClassFragment> classes = new Stack<>();

    private IFragment rootFragment;

    @Override
    public void exitFieldDeclaration(Java8Parser.FieldDeclarationContext ctx) {
        for (Java8FieldFragment java8FieldFragment : java8FragmentFactory.newJava8FieldFragment(ctx)) {
            fields.push(java8FieldFragment);
        }
    }

    @Override
    public void exitMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        methods.push(java8FragmentFactory.newJava8MethodFragment(ctx));
    }

    @Override
    public void exitNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
        classes.push(java8FragmentFactory.newJava8ClassFragment(ctx, fields, methods));
    }

    @Override
    public void exitCompilationUnit(Java8Parser.CompilationUnitContext ctx) {
        rootFragment = classes.peek();
    }

    @Override
    public IFragment getFragment() {
        return rootFragment;
    }
}
