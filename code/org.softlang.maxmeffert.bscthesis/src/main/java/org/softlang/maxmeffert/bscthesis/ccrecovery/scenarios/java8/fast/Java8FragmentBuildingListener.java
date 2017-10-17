package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.antlr.Java8BaseListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.antlr.Java8Parser;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Java8FragmentBuildingListener extends Java8BaseListener implements IFragmentBuildingListener {

    private final Java8FragmentFactory java8FragmentFactory = new Java8FragmentFactory();

    private Stack<Java8MethodFragment> methods = new Stack<>();
    private Stack<Java8FieldFragment> fields = new Stack<>();
    private Stack<Java8ClassFragment> classes = new Stack<>();

    private IFragment rootFragment;

    private <T> List<T> popAllInto(Stack<T> stack, List<T> list) {
        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    private String textof(ParserRuleContext parserRuleContext) {
        return parserRuleContext.getStart().getInputStream().getText(parserRuleContext.getSourceInterval());
    }

    @Override
    public void exitFieldDeclaration(Java8Parser.FieldDeclarationContext ctx) {
        super.exitFieldDeclaration(ctx);
        for (Java8Parser.VariableDeclaratorContext vctx : ctx.variableDeclaratorList().variableDeclarator()) {
            fields.push(java8FragmentFactory.newJava8FieldFragment(vctx.variableDeclaratorId().Identifier().getText(), textof(ctx)));
        }
    }

    @Override
    public void exitMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        super.exitMethodDeclaration(ctx);
        methods.push(java8FragmentFactory.newJava8MethodFragment(ctx.methodHeader().methodDeclarator().Identifier().getText(), textof(ctx)));
    }

    @Override
    public void exitNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
        super.exitNormalClassDeclaration(ctx);
        List<Java8MethodFragment> methods = popAllInto(this.methods, new LinkedList<>());
        List<Java8FieldFragment> fields = popAllInto(this.fields, new LinkedList<>());
        classes.push(java8FragmentFactory.newJava8ClassFragment(ctx.Identifier().getText(), fields, methods, textof(ctx)));
    }

    @Override
    public void exitCompilationUnit(Java8Parser.CompilationUnitContext ctx) {
        super.exitCompilationUnit(ctx);
//        System.out.println(classes.peek().getFields());
//        System.out.println(classes.peek().getMethods());
        rootFragment = classes.peek();
    }

    @Override
    public IFragment getFragment() {
        return rootFragment;
    }
}
