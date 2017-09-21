package org.softlang.maxmeffert.bscthesis;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.softlang.maxmeffert.bscthesis.antlr.*;
import org.softlang.maxmeffert.bscthesis.mereologies.old.Mereology;
import org.softlang.maxmeffert.bscthesis.simpleparsetrees.*;
import org.softlang.maxmeffert.bscthesis.textsources.*;
import org.softlang.maxmeffert.bscthesis.trees.ITree;
import org.softlang.maxmeffert.bscthesis.trees.ITreeWalkerListener;
import org.softlang.maxmeffert.bscthesis.trees.TreeFactory;
import org.softlang.maxmeffert.bscthesis.trees.TreeWalkerFactory;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		IAntlrConfigurationBuilderFactory antlrConfigurationBuilderFactory = new AntlrConfigurationBuilderFactory();
		IAntlrConfiguration antlrConfiguration = antlrConfigurationBuilderFactory.newAntlrConfigurationBuilder()
				.withLexerFactory(charStream -> new Java8Lexer(charStream))
				.withParseTreeFactory(tokenStream -> new Java8Parser(tokenStream).compilationUnit())
				.build();

		IAntlrParsingResult antlrParsingResult = antlrConfiguration.parse("class A {class A {}}");

//		CharStream input = CharStreams.fromString("class A {class A {}}");
//		Lexer lexer = new Java8Lexer(input);
//		TokenStream tokenStream = new CommonTokenStream(lexer);
//		ParseTree parseTree = new Java8Parser(tokenStream).compilationUnit();

		SimpleParseTreeFactory parseTreeFactory = new SimpleParseTreeFactory(
					new TreeFactory(),
					new TextSourceFactory(
					new TextSourceBuilderFactory(),
					new TextIntervalConverterFactory(new TextIntervalFactory(), new AntlrIntervalFactory()),
					new TextProviderFactory(new TextIntervalConverterFactory(new TextIntervalFactory(), new AntlrIntervalFactory()))
				),
				new SimpleParseTreeNormalizerFactory());
//
//		ISimpleParseTree parseTree = parseTreeFactory.newSimpleParseTree(tokenStream, antlrParseTree);
//		parseTree = new SimpleParseTreeNormalizer().normalize(parseTree);
//		ISimpleParseTreeWalker parseTreeWalker = new SimpleParseTreeWalker();
//		parseTreeWalker.walk(parseTree, new ISimpleParseTreeWalkerListener() {
//			@Override
//			public void enter(ISimpleParseTree parseTree) {
//				System.out.println(parseTree);
//			}
//
//			@Override
//			public void exit(ISimpleParseTree parseTree) {
//
//			}
//		});

		ITree<ITextSource> tree = parseTreeFactory.newSimpleParseTree(antlrParsingResult);
		new TreeWalkerFactory().<ITextSource>newTreeWalker().walk(tree, new ITreeWalkerListener<ITextSource>() {
			@Override
			public void enter(ITree<ITextSource> tree) {
				System.out.println(tree);
			}

			@Override
			public void exit(ITree<ITextSource> tree) {

			}
		});

	}

	public static void oldMain(String[] args) throws IOException, RecognitionException {

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
