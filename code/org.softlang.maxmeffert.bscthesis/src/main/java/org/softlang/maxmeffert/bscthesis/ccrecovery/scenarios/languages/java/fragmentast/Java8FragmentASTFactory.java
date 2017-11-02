package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.BaseFragmentASTFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.antlr.java8.Java8Parser;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Java8FragmentASTFactory extends BaseFragmentASTFactory {

    public List<JavaFieldFragmentAST> newJavaFieldFragment(Java8Parser.FieldDeclarationContext fieldDeclarationContext, Stack<JavaModifierFragmentAST> javaModifierFragments) {
        List<JavaFieldFragmentAST> javaFieldFragments = new LinkedList<>();
        for (Java8Parser.VariableDeclaratorContext variableDeclaratorContext : fieldDeclarationContext.variableDeclaratorList().variableDeclarator()) {
            JavaFieldFragmentAST javaFieldFragment = initialize(new JavaFieldFragmentAST(), fieldDeclarationContext);
            javaFieldFragment.setIdentifier(variableDeclaratorContext.variableDeclaratorId().Identifier().getText());
            javaFieldFragment.setType(fieldDeclarationContext.unannType().getText());

            while (!javaModifierFragments.isEmpty()) {
                javaFieldFragment.addJavaModifierFragment(javaModifierFragments.pop());
            }

            javaFieldFragments.add(javaFieldFragment);
        }
        return javaFieldFragments;
    }

    public JavaMethodFragmentAST newJavaMethodFragment(Java8Parser.MethodDeclarationContext methodDeclarationContext, Stack<JavaModifierFragmentAST> javaModifierFragments) {
        JavaMethodFragmentAST javaMethodFragment = initialize(new JavaMethodFragmentAST(), methodDeclarationContext);
        javaMethodFragment.setIdentifier(methodDeclarationContext.methodHeader().methodDeclarator().Identifier().getText());
        javaMethodFragment.setType(methodDeclarationContext.methodHeader().result().getText());

        while (!javaModifierFragments.isEmpty()) {
            javaMethodFragment.addJavaModifierFragment(javaModifierFragments.pop());
        }

        return javaMethodFragment;
    }

    public JavaClassFragmentAST newJavaClassFragment(Java8Parser.NormalClassDeclarationContext normalClassDeclarationContext) {
        JavaClassFragmentAST javaClassFragment = initialize(new JavaClassFragmentAST(), normalClassDeclarationContext);
        javaClassFragment.setIdentifier(normalClassDeclarationContext.Identifier().getText());
        return javaClassFragment;
    }

    public JavaClassFragmentAST newJavaClassFragment(
            Java8Parser.NormalClassDeclarationContext normalClassDeclarationContext,
            Stack<JavaModifierFragmentAST> javaModifierFragments,
            Stack<JavaFieldFragmentAST> javaFieldFragments,
            Stack<JavaMethodFragmentAST> javaMethodFragments) {
        JavaClassFragmentAST javaClassFragment = newJavaClassFragment(normalClassDeclarationContext);
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

    private JavaAnnotationFragmentAST newJavaAnnotationFragment(Java8Parser.AnnotationContext annotationContext) {
        JavaAnnotationFragmentAST javaAnnotationFragment = initialize(new JavaAnnotationFragmentAST(), annotationContext);
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

    public JavaModifierFragmentAST newJavaModifierFragment(Java8Parser.ClassModifierContext classModifierContext) {
        JavaModifierFragmentAST javaModifierFragment = initialize(new JavaModifierFragmentAST(), classModifierContext);
        if (classModifierContext.annotation() != null) {
            javaModifierFragment.setJavaAnnotationFragment(newJavaAnnotationFragment(classModifierContext.annotation()));
        }
        else {
            javaModifierFragment.setName(classModifierContext.getText());
        }
        return javaModifierFragment;
    }

    public JavaModifierFragmentAST newJavaModifierFragment(Java8Parser.FieldModifierContext fieldModifierContext) {
        JavaModifierFragmentAST javaModifierFragment = initialize(new JavaModifierFragmentAST(), fieldModifierContext);
        if (fieldModifierContext.annotation() != null) {
            javaModifierFragment.setJavaAnnotationFragment(newJavaAnnotationFragment(fieldModifierContext.annotation()));
        }
        else {
            javaModifierFragment.setName(fieldModifierContext.getText());
        }
        return javaModifierFragment;
    }

    public JavaModifierFragmentAST newJavaModifierFragment(Java8Parser.MethodModifierContext methodModifierContext) {
        JavaModifierFragmentAST javaModifierFragment = initialize(new JavaModifierFragmentAST(), methodModifierContext);
        if (methodModifierContext.annotation() != null) {
            javaModifierFragment.setJavaAnnotationFragment(newJavaAnnotationFragment(methodModifierContext.annotation()));
        }
        else {
            javaModifierFragment.setName(methodModifierContext.getText());
        }
        return javaModifierFragment;
    }
}
