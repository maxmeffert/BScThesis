package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fast.IFragmentAST;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.antlr.Java8BaseListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.antlr.Java8Parser;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Java8FragmentAstBuilder extends Java8BaseListener {

    private Stack<IFragmentAST> methods = new Stack<>();
    private Stack<IFragmentAST> classes = new Stack<>();

    private void popAllInto(Stack<IFragmentAST> stack, IFragmentAST fragmentAST) {
        while (!stack.isEmpty()) {
            fragmentAST.addChild(stack.pop());
        }
    }

    private <T> void popAllInto(Stack<T> stack, List<T> list) {
        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }
    }

    @Override
    public void exitMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        super.exitMethodDeclaration(ctx);
        methods.push(Java8FragmentFactory.MethodFragment(ctx.methodHeader().methodDeclarator().Identifier().getText()));
    }

    @Override
    public void exitNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
        super.exitNormalClassDeclaration(ctx);
        List<IFragmentAST> fragments = new LinkedList<>();
        popAllInto(methods, fragments);
        classes.push(Java8FragmentFactory.ClassFragment(ctx.Identifier().getText(), fragments));
    }

    @Override
    public void exitCompilationUnit(Java8Parser.CompilationUnitContext ctx) {
        super.exitCompilationUnit(ctx);
        System.out.println(classes.peek().getChildren());
    }
}
