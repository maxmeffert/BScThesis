package org.softlang.megal.plugins.api.antlr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.FragmentizerPlugin;
import org.softlang.megal.plugins.api.fragmentation.Fragments;
import org.softlang.megal.plugins.api.fragmentation.Fragments.Fragment;
import org.antlr.v4.runtime.tree.ParseTreeListener;

public abstract class ParseTreeFragmentizerPlugin<P extends Parser, L extends Lexer> extends FragmentizerPlugin implements ANTLRBackedPlugin<P,L>{

	private class FragmentationListener implements ParseTreeListener {

		private Entity entity;
		private Artifact artifact;
		private Collection<Fragment> fragments = new HashSet<Fragment>();
		private Map<String,Integer> nameCounters = new TreeMap<String,Integer>();
		private Map<ParserRuleContext,Fragment> fragmentMap = new HashMap<ParserRuleContext,Fragment>();
		
		public FragmentationListener(Entity entity, Artifact artifact) {
			this.entity = entity;
			this.artifact = artifact;
			
		}
		
		
		
		public Collection<Fragment> getFragments() {
			return fragmentMap.values();
		}


		private String toLowerFirst(String s) {
			return Character.toLowerCase(s.charAt(0)) + s.substring(1);
		}

		@Override
		public void enterEveryRule(ParserRuleContext context) {
			
			String type = context.getClass().getSimpleName() + "Fragment";
			
			if (!nameCounters.containsKey(type)) {
				nameCounters.put(type, 0);
			}
			else {
				nameCounters.put(type, nameCounters.get(type) + 1);
			}
			
			int count = nameCounters.get(type);
			
			String name = toLowerFirst(type) + (count > 0 ? count : ""); 
			String text = ANTLRUtils.originalText(context);
			
			Fragment f = Fragments.create(name, type, text, entity, artifact);
			
			if (context.parent != null && fragmentMap.containsKey(context.parent)) {
//				f.setParent(fragmentMap.get(context.parent));
				fragmentMap.get(context.parent).addPart(f);
			}
			
			
			fragmentMap.put(context, f);
		}

		@Override
		public void exitEveryRule(ParserRuleContext arg0) {
			// TODO Auto-generated method stub

//			System.out.println(getFragments().size());
		}

		@Override
		public void visitErrorNode(ErrorNode arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void visitTerminal(TerminalNode arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	@Override
	public Collection<Fragment> getFragments(Entity entity, Artifact artifact) {
		// Create a new fragmentation listener
		FragmentationListener listener = new FragmentationListener(entity, artifact);
		
		// Create a new parse tree walker
		ParseTreeWalker walker = new ParseTreeWalker();
		
		System.out.println(entity.getName());
		System.out.println(entity.getBinding());
		
		try {
			
			// Create a new from the input stream above
			ParseTree parseTree = getParserFactory().getParseTree(artifact);
			
			// Walk the parse tree with the fragmentation listener to collect fragments
			walker.walk(listener, parseTree);
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} catch (Throwable e) {
			
			e.printStackTrace();
			
		}
//		System.out.println(listener.getFragments());
		return listener.getFragments();
	}

	
	
}
