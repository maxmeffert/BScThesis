package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.similarities;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fast.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.antlr.java8.Java8BaseListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.antlr.java8.Java8Parser;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.antlr.java8.fast.JavaClassFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.antlr.java8.fast.JavaFragmentFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.antlr.java8.fast.JavaMethodFragment;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Java8FragmentAstBuilder extends Java8BaseListener {

    private Stack<JavaMethodFragment> methods = new Stack<>();
    private Stack<JavaClassFragment> classes = new Stack<>();

    @Override
    public void exitMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        super.exitMethodDeclaration(ctx);
        methods.push(JavaFragmentFactory.MethodFragment(ctx.methodHeader().methodDeclarator().Identifier().getText()));
    }

    @Override
    public void exitNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
        super.exitNormalClassDeclaration(ctx);
        List<IFragmentAST> fragments = new LinkedList<>();
        fragments.addAll(methods);
        methods.clear();
        System.out.println(methods);
        classes.push(JavaFragmentFactory.ClassFragment(ctx.Identifier().getText(), fragments));
    }

    @Override
    public void exitCompilationUnit(Java8Parser.CompilationUnitContext ctx) {
        super.exitCompilationUnit(ctx);
        System.out.println(classes.peek().getChildren());
    }
}
