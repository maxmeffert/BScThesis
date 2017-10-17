package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.BaseFragmentFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.antlr.Java8Parser;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Java8FragmentFactory extends BaseFragmentFactory {

    public List<Java8FieldFragment> newJava8FieldFragment(Java8Parser.FieldDeclarationContext fieldDeclarationContext) {
        List<Java8FieldFragment> java8FieldFragments = new LinkedList<>();
        for (Java8Parser.VariableDeclaratorContext variableDeclaratorContext : fieldDeclarationContext.variableDeclaratorList().variableDeclarator()) {
            Java8FieldFragment java8FieldFragment = initialize(new Java8FieldFragment(), fieldDeclarationContext);
            java8FieldFragment.setIdentifier(variableDeclaratorContext.variableDeclaratorId().Identifier().getText());
            java8FieldFragments.add(java8FieldFragment);
        }
        return java8FieldFragments;
    }

    public Java8MethodFragment newJava8MethodFragment(Java8Parser.MethodDeclarationContext methodDeclarationContext) {
        Java8MethodFragment java8MethodFragment = initialize(new Java8MethodFragment(), methodDeclarationContext);
        java8MethodFragment.setIdentifier(methodDeclarationContext.methodHeader().methodDeclarator().Identifier().getText());
        return java8MethodFragment;
    }

    public Java8ClassFragment newJava8ClassFragment(Java8Parser.NormalClassDeclarationContext normalClassDeclarationContext) {
        Java8ClassFragment java8ClassFragment = initialize(new Java8ClassFragment(), normalClassDeclarationContext);
        java8ClassFragment.setIdentifier(normalClassDeclarationContext.Identifier().getText());
        return java8ClassFragment;
    }

    public Java8ClassFragment newJava8ClassFragment(Java8Parser.NormalClassDeclarationContext normalClassDeclarationContext, Stack<Java8FieldFragment> java8FieldFragments, Stack<Java8MethodFragment> java8MethodFragments) {
        Java8ClassFragment java8ClassFragment = newJava8ClassFragment(normalClassDeclarationContext);
        while (!java8FieldFragments.isEmpty()) {
            java8ClassFragment.addField(java8FieldFragments.pop());
        }
        while (!java8MethodFragments.isEmpty()) {
            java8ClassFragment.addMethod(java8MethodFragments.pop());
        }
        return java8ClassFragment;
    }
}
