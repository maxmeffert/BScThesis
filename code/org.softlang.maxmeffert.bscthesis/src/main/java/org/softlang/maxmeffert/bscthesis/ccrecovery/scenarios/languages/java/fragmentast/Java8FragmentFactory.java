package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.BaseFragmentFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.antlr.java8.Java8Parser;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Java8FragmentFactory extends BaseFragmentFactory {

    public List<JavaFieldFragment> newJavaFieldFragment(Java8Parser.FieldDeclarationContext fieldDeclarationContext, Stack<JavaModifierFragment> javaModifierFragments) {
        List<JavaFieldFragment> javaFieldFragments = new LinkedList<>();
        for (Java8Parser.VariableDeclaratorContext variableDeclaratorContext : fieldDeclarationContext.variableDeclaratorList().variableDeclarator()) {
            JavaFieldFragment javaFieldFragment = initialize(new JavaFieldFragment(), fieldDeclarationContext);
            javaFieldFragment.setIdentifier(variableDeclaratorContext.variableDeclaratorId().Identifier().getText());
            javaFieldFragment.setType(fieldDeclarationContext.unannType().getText());

            while (!javaModifierFragments.isEmpty()) {
                javaFieldFragment.addJavaModifierFragment(javaModifierFragments.pop());
            }

            javaFieldFragments.add(javaFieldFragment);
        }
        return javaFieldFragments;
    }

    public JavaMethodFragment newJavaMethodFragment(Java8Parser.MethodDeclarationContext methodDeclarationContext, Stack<JavaModifierFragment> javaModifierFragments) {
        JavaMethodFragment javaMethodFragment = initialize(new JavaMethodFragment(), methodDeclarationContext);
        javaMethodFragment.setIdentifier(methodDeclarationContext.methodHeader().methodDeclarator().Identifier().getText());
        javaMethodFragment.setType(methodDeclarationContext.methodHeader().result().getText());

        while (!javaModifierFragments.isEmpty()) {
            javaMethodFragment.addJavaModifierFragment(javaModifierFragments.pop());
        }

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

    private JavaAnnotationFragment newJavaAnnotationFragment(Java8Parser.AnnotationContext annotationContext) {
        JavaAnnotationFragment javaAnnotationFragment = initialize(new JavaAnnotationFragment(), annotationContext);
        if (annotationContext.normalAnnotation() != null) {
            Java8Parser.NormalAnnotationContext normalAnnotationContext = annotationContext.normalAnnotation();
            javaAnnotationFragment.setIdentifier(normalAnnotationContext.typeName().getText());
            for (Java8Parser.ElementValuePairContext elementValuePairContext : normalAnnotationContext.elementValuePairList().elementValuePair()) {
                String namedParameterName = elementValuePairContext.Identifier().getText();
                String namedParameterValue = elementValuePairContext.elementValue().getText();
                javaAnnotationFragment.addNamedParameter(namedParameterName, namedParameterValue);
            }
        }
        else if (annotationContext.markerAnnotation() != null) {
            Java8Parser.MarkerAnnotationContext markerAnnotationContext = annotationContext.markerAnnotation();
            javaAnnotationFragment.setIdentifier(markerAnnotationContext.typeName().getText());
        }
        else if(annotationContext.singleElementAnnotation() != null) {
            Java8Parser.SingleElementAnnotationContext singleElementAnnotationContext = annotationContext.singleElementAnnotation();
            javaAnnotationFragment.setIdentifier(singleElementAnnotationContext.typeName().getText());
            javaAnnotationFragment.addUnnamedParameter(singleElementAnnotationContext.elementValue().getText());
        }
        return javaAnnotationFragment;
    }

    public JavaModifierFragment newJavaModifierFragment(Java8Parser.ClassModifierContext classModifierContext) {
        JavaModifierFragment javaModifierFragment = initialize(new JavaModifierFragment(), classModifierContext);
        if (classModifierContext.annotation() != null) {
            javaModifierFragment.setJavaAnnotationFragment(newJavaAnnotationFragment(classModifierContext.annotation()));
        }
        else {
            javaModifierFragment.setName(classModifierContext.getText());
        }
        return javaModifierFragment;
    }

    public JavaModifierFragment newJavaModifierFragment(Java8Parser.FieldModifierContext fieldModifierContext) {
        JavaModifierFragment javaModifierFragment = initialize(new JavaModifierFragment(), fieldModifierContext);
        if (fieldModifierContext.annotation() != null) {
            javaModifierFragment.setJavaAnnotationFragment(newJavaAnnotationFragment(fieldModifierContext.annotation()));
        }
        else {
            javaModifierFragment.setName(fieldModifierContext.getText());
        }
        return javaModifierFragment;
    }

    public JavaModifierFragment newJavaModifierFragment(Java8Parser.MethodModifierContext methodModifierContext) {
        JavaModifierFragment javaModifierFragment = initialize(new JavaModifierFragment(), methodModifierContext);
        if (methodModifierContext.annotation() != null) {
            javaModifierFragment.setJavaAnnotationFragment(newJavaAnnotationFragment(methodModifierContext.annotation()));
        }
        else {
            javaModifierFragment.setName(methodModifierContext.getText());
        }
        return javaModifierFragment;
    }
}
