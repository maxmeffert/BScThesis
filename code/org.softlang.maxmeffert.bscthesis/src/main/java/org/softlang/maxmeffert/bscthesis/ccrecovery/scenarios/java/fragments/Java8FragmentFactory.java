package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.BaseFragmentFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.antlr.java8.Java8Parser;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Java8FragmentFactory extends BaseFragmentFactory {

    public List<Java8FieldFragment> newJava8FieldFragment(Java8Parser.FieldDeclarationContext fieldDeclarationContext) {
        List<Java8FieldFragment> java8FieldFragments = new LinkedList<>();
        for (Java8Parser.VariableDeclaratorContext variableDeclaratorContext : fieldDeclarationContext.variableDeclaratorList().variableDeclarator()) {
            Java8FieldFragment java8FieldFragment = initialize(new Java8FieldFragment(), fieldDeclarationContext);
            java8FieldFragment.setIdentifier(variableDeclaratorContext.variableDeclaratorId().Identifier().getText());
            java8FieldFragment.setType(fieldDeclarationContext.unannType().getText());
            java8FieldFragments.add(java8FieldFragment);
        }
        return java8FieldFragments;
    }

    public Java8MethodFragment newJava8MethodFragment(Java8Parser.MethodDeclarationContext methodDeclarationContext) {
        Java8MethodFragment java8MethodFragment = initialize(new Java8MethodFragment(), methodDeclarationContext);
        java8MethodFragment.setIdentifier(methodDeclarationContext.methodHeader().methodDeclarator().Identifier().getText());
        java8MethodFragment.setType(methodDeclarationContext.methodHeader().result().getText());
        return java8MethodFragment;
    }

    public Java8ClassFragment newJava8ClassFragment(Java8Parser.NormalClassDeclarationContext normalClassDeclarationContext) {
        Java8ClassFragment java8ClassFragment = initialize(new Java8ClassFragment(), normalClassDeclarationContext);
        java8ClassFragment.setIdentifier(normalClassDeclarationContext.Identifier().getText());
        return java8ClassFragment;
    }

    public Java8ClassFragment newJava8ClassFragment(
            Java8Parser.NormalClassDeclarationContext normalClassDeclarationContext,
            Stack<Java8ModifierFragment> java8ModifierFragments,
            Stack<Java8FieldFragment> java8FieldFragments,
            Stack<Java8MethodFragment> java8MethodFragments) {
        Java8ClassFragment java8ClassFragment = newJava8ClassFragment(normalClassDeclarationContext);
        while (!java8ModifierFragments.isEmpty()) {
            java8ClassFragment.addJava8ModifierFragment(java8ModifierFragments.pop());
        }
        while (!java8FieldFragments.isEmpty()) {
            java8ClassFragment.addJava8FieldFragment(java8FieldFragments.pop());
        }
        while (!java8MethodFragments.isEmpty()) {
            java8ClassFragment.addJava8MethodFragment(java8MethodFragments.pop());
        }
        return java8ClassFragment;
    }

    private Java8ModifierFragment newJava8ModifierFragment(Java8Parser.AnnotationContext annotationContext) {
        return null;
    }

    public Java8ModifierFragment newJava8ModifierFragment(Java8Parser.ClassModifierContext classModifierContext) {
        if (classModifierContext.annotation() != null) {
            return newJava8ModifierFragment(classModifierContext.annotation());
        }
        Java8ModifierFragment java8ModifierFragment = initialize(new Java8ModifierFragment(), classModifierContext);
        java8ModifierFragment.setName(classModifierContext.getText());
        return java8ModifierFragment;
    }

    public Java8ModifierFragment newJava8ModifierFragment(Java8Parser.FieldModifierContext fieldModifierContext) {
        if (fieldModifierContext.annotation() != null) {
            return newJava8ModifierFragment(fieldModifierContext.annotation());
        }
        Java8ModifierFragment java8ModifierFragment = initialize(new Java8ModifierFragment(), fieldModifierContext);
        java8ModifierFragment.setName(fieldModifierContext.getText());
        return java8ModifierFragment;
    }

    public Java8ModifierFragment newJava8ModifierFragment(Java8Parser.MethodModifierContext methodModifierContext) {
        if (methodModifierContext.annotation() != null) {
            return newJava8ModifierFragment(methodModifierContext.annotation());
        }
        Java8ModifierFragment java8ModifierFragment = initialize(new Java8ModifierFragment(), methodModifierContext);
        java8ModifierFragment.setName(methodModifierContext.getText());
        return java8ModifierFragment;
    }
}
