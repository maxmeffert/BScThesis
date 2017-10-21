package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.BaseFragmentFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java.antlr.java8.Java8Parser;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Java8FragmentFactory extends BaseFragmentFactory {

    public List<JavaFieldFragment> newJavaFieldFragment(Java8Parser.FieldDeclarationContext fieldDeclarationContext) {
        List<JavaFieldFragment> javaFieldFragments = new LinkedList<>();
        for (Java8Parser.VariableDeclaratorContext variableDeclaratorContext : fieldDeclarationContext.variableDeclaratorList().variableDeclarator()) {
            JavaFieldFragment javaFieldFragment = initialize(new JavaFieldFragment(), fieldDeclarationContext);
            javaFieldFragment.setIdentifier(variableDeclaratorContext.variableDeclaratorId().Identifier().getText());
            javaFieldFragment.setType(fieldDeclarationContext.unannType().getText());
            javaFieldFragments.add(javaFieldFragment);
        }
        return javaFieldFragments;
    }

    public JavaMethodFragment newJavaMethodFragment(Java8Parser.MethodDeclarationContext methodDeclarationContext) {
        JavaMethodFragment javaMethodFragment = initialize(new JavaMethodFragment(), methodDeclarationContext);
        javaMethodFragment.setIdentifier(methodDeclarationContext.methodHeader().methodDeclarator().Identifier().getText());
        javaMethodFragment.setType(methodDeclarationContext.methodHeader().result().getText());
        return javaMethodFragment;
    }

    public JavaClassFragment newJavaClassFragment(Java8Parser.NormalClassDeclarationContext normalClassDeclarationContext) {
        JavaClassFragment javaClassFragment = initialize(new JavaClassFragment(), normalClassDeclarationContext);
        javaClassFragment.setIdentifier(normalClassDeclarationContext.Identifier().getText());
        return javaClassFragment;
    }

    public JavaClassFragment newJavaClassFragment(
            Java8Parser.NormalClassDeclarationContext normalClassDeclarationContext,
            Stack<JavaModifierFragment> javaModifierFragments,
            Stack<JavaFieldFragment> javaFieldFragments,
            Stack<JavaMethodFragment> javaMethodFragments) {
        JavaClassFragment javaClassFragment = newJavaClassFragment(normalClassDeclarationContext);
        while (!javaModifierFragments.isEmpty()) {
            javaClassFragment.addJavaModifierFragment(javaModifierFragments.pop());
        }
        while (!javaFieldFragments.isEmpty()) {
            javaClassFragment.addJavaFieldFragment(javaFieldFragments.pop());
        }
        while (!javaMethodFragments.isEmpty()) {
            javaClassFragment.addJavaMethodFragment(javaMethodFragments.pop());
        }
        return javaClassFragment;
    }

    private JavaModifierFragment newJavaModifierFragment(Java8Parser.AnnotationContext annotationContext) {
        return null;
    }

    public JavaModifierFragment newJavaModifierFragment(Java8Parser.ClassModifierContext classModifierContext) {
        if (classModifierContext.annotation() != null) {
            return newJavaModifierFragment(classModifierContext.annotation());
        }
        JavaModifierFragment javaModifierFragment = initialize(new JavaModifierFragment(), classModifierContext);
        javaModifierFragment.setName(classModifierContext.getText());
        return javaModifierFragment;
    }

    public JavaModifierFragment newJavaModifierFragment(Java8Parser.FieldModifierContext fieldModifierContext) {
        if (fieldModifierContext.annotation() != null) {
            return newJavaModifierFragment(fieldModifierContext.annotation());
        }
        JavaModifierFragment javaModifierFragment = initialize(new JavaModifierFragment(), fieldModifierContext);
        javaModifierFragment.setName(fieldModifierContext.getText());
        return javaModifierFragment;
    }

    public JavaModifierFragment newJavaModifierFragment(Java8Parser.MethodModifierContext methodModifierContext) {
        if (methodModifierContext.annotation() != null) {
            return newJavaModifierFragment(methodModifierContext.annotation());
        }
        JavaModifierFragment javaModifierFragment = initialize(new JavaModifierFragment(), methodModifierContext);
        javaModifierFragment.setName(methodModifierContext.getText());
        return javaModifierFragment;
    }
}
