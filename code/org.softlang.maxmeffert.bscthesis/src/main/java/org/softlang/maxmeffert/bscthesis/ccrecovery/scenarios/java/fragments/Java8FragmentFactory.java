package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.BaseFragmentFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.antlr.java8.Java8Parser;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Java8FragmentFactory extends BaseFragmentFactory {

    public List<JavaFieldFragment> newJavaFieldFragment(Java8Parser.FieldDeclarationContext fieldDeclarationContext) {
        List<JavaFieldFragment> java8FieldFragments = new LinkedList<>();
        for (Java8Parser.VariableDeclaratorContext variableDeclaratorContext : fieldDeclarationContext.variableDeclaratorList().variableDeclarator()) {
            JavaFieldFragment java8FieldFragment = initialize(new JavaFieldFragment(), fieldDeclarationContext);
            java8FieldFragment.setIdentifier(variableDeclaratorContext.variableDeclaratorId().Identifier().getText());
            java8FieldFragment.setType(fieldDeclarationContext.unannType().getText());
            java8FieldFragments.add(java8FieldFragment);
        }
        return java8FieldFragments;
    }

    public JavaMethodFragment newJavaMethodFragment(Java8Parser.MethodDeclarationContext methodDeclarationContext) {
        JavaMethodFragment java8MethodFragment = initialize(new JavaMethodFragment(), methodDeclarationContext);
        java8MethodFragment.setIdentifier(methodDeclarationContext.methodHeader().methodDeclarator().Identifier().getText());
        java8MethodFragment.setType(methodDeclarationContext.methodHeader().result().getText());
        return java8MethodFragment;
    }

    public JavaClassFragment newJavaClassFragment(Java8Parser.NormalClassDeclarationContext normalClassDeclarationContext) {
        JavaClassFragment java8ClassFragment = initialize(new JavaClassFragment(), normalClassDeclarationContext);
        java8ClassFragment.setIdentifier(normalClassDeclarationContext.Identifier().getText());
        return java8ClassFragment;
    }

    public JavaClassFragment newJavaClassFragment(
            Java8Parser.NormalClassDeclarationContext normalClassDeclarationContext,
            Stack<JavaModifierFragment> java8ModifierFragments,
            Stack<JavaFieldFragment> java8FieldFragments,
            Stack<JavaMethodFragment> java8MethodFragments) {
        JavaClassFragment java8ClassFragment = newJavaClassFragment(normalClassDeclarationContext);
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

    private JavaModifierFragment newJavaModifierFragment(Java8Parser.AnnotationContext annotationContext) {
        return null;
    }

    public JavaModifierFragment newJavaModifierFragment(Java8Parser.ClassModifierContext classModifierContext) {
        if (classModifierContext.annotation() != null) {
            return newJavaModifierFragment(classModifierContext.annotation());
        }
        JavaModifierFragment java8ModifierFragment = initialize(new JavaModifierFragment(), classModifierContext);
        java8ModifierFragment.setName(classModifierContext.getText());
        return java8ModifierFragment;
    }

    public JavaModifierFragment newJavaModifierFragment(Java8Parser.FieldModifierContext fieldModifierContext) {
        if (fieldModifierContext.annotation() != null) {
            return newJavaModifierFragment(fieldModifierContext.annotation());
        }
        JavaModifierFragment java8ModifierFragment = initialize(new JavaModifierFragment(), fieldModifierContext);
        java8ModifierFragment.setName(fieldModifierContext.getText());
        return java8ModifierFragment;
    }

    public JavaModifierFragment newJavaModifierFragment(Java8Parser.MethodModifierContext methodModifierContext) {
        if (methodModifierContext.annotation() != null) {
            return newJavaModifierFragment(methodModifierContext.annotation());
        }
        JavaModifierFragment java8ModifierFragment = initialize(new JavaModifierFragment(), methodModifierContext);
        java8ModifierFragment.setName(methodModifierContext.getText());
        return java8ModifierFragment;
    }
}
