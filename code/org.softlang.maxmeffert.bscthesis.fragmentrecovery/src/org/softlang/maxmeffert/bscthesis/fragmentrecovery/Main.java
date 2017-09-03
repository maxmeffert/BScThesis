package org.softlang.maxmeffert.bscthesis.fragmentrecovery;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Stack;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {

	
	
	public static void main(String[] args) throws IOException, RecognitionException {
		
		CharStream input = CharStreams.fromFileName("./input/fragments/Company.java");
		Lexer lexer = new Java8Lexer(input);
		TokenStream tokens = new CommonTokenStream(lexer);
		ParseTree parsetree = new Java8Parser(tokens).compilationUnit();
	
		Mereology<ParserRuleContext> m = new Mereology<>();
		Stack<ParserRuleContext> stack = new Stack<>();
		
		ParseTreeListener listener = new ParseTreeListener() {

			@Override
			public void enterEveryRule(ParserRuleContext context) {
				if (!stack.isEmpty()) {
					m.partOf(context, stack.peek());
				}
				stack.push(context);
			}

			@Override
			public void exitEveryRule(ParserRuleContext context) {
				stack.pop();
			}

			@Override
			public void visitErrorNode(ErrorNode arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void visitTerminal(TerminalNode arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(listener, parsetree);
		
		PrintStream out = System.out;
		out = new PrintStream(new File("./out.txt"));

		for(ParserRuleContext p : m.getValues()) {
			String pName = p.getClass().getSimpleName();
			System.out.println(pName);
			out.println("// " + pName);
			out.println("// " + p.getText());
			for(ParserRuleContext w : m.getWholesOf(p)) {
				String wName = w.getClass().getSimpleName();
				out.println(pName + " partOf " + wName);
			}
			out.println();
		}
		
	}

}
