package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.fast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs.IFragmentBuildingListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments.IFragment;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.antlr.Java8BaseListener;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.java8.antlr.Java8Parser;

import java.util.Stack;

public class Java8FragmentBuildingListener extends Java8BaseListener implements IFragmentBuildingListener {

    private final Java8FragmentFactory java8FragmentFactory = new Java8FragmentFactory();

    private Stack<Java8MethodFragment> methods = new Stack<>();
    private Stack<Java8FieldFragment> fields = new Stack<>();
    private Stack<Java8ClassFragment> classes = new Stack<>();

    private IFragment rootFragment;

    private String textof(ParserRuleContext parserRuleContext) {
        int a = parserRuleContext.start.getStartIndex();
        int b = parserRuleContext.stop.getStopIndex();
        return parserRuleContext.getStart().getInputStream().getText(Interval.of(a,b));
    }

    @Override
    public void exitFieldDeclaration(Java8Parser.FieldDeclarationContext ctx) {
        for (Java8Parser.VariableDeclaratorContext vctx : ctx.variableDeclaratorList().variableDeclarator()) {
            String identifier = vctx.variableDeclaratorId().Identifier().getText();
            String text = textof(ctx);
            Java8FieldFragment java8FieldFragment = java8FragmentFactory.newJava8FieldFragment();
            java8FieldFragment.setIdentifier(identifier);
            java8FieldFragment.setText(text);
            fields.push(java8FieldFragment);
        }
    }

    @Override
    public void exitMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        String identifier = ctx.methodHeader().methodDeclarator().Identifier().getText();
        String text = textof(ctx);
        Java8MethodFragment java8MethodFragment = java8FragmentFactory.newJava8MethodFragment();
        java8MethodFragment.setIdentifier(identifier);
        java8MethodFragment.setText(text);
        methods.push(java8MethodFragment);
    }

    @Override
    public void exitNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
        String identifier = ctx.Identifier().getText();
        String text = textof(ctx);
        Java8ClassFragment java8ClassFragment = java8FragmentFactory.newJava8ClassFragment();
        java8ClassFragment.setIdentifier(identifier);
        java8ClassFragment.setText(text);
        while (!methods.isEmpty()) {
            java8ClassFragment.addMethod(methods.pop());
        }
        while (!fields.isEmpty()) {
            java8ClassFragment.addField(fields.pop());
        }
        classes.push(java8ClassFragment);
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
