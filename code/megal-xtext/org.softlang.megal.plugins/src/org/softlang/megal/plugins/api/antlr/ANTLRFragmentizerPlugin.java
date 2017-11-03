package org.softlang.megal.plugins.api.antlr;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.FragmentizerPlugin;
import org.softlang.megal.plugins.api.fragmentation.Fragments.Fragment;

/**
 * Abstract base class for ANTLR base fragmentation reasoners
 * @author maxmeffert
 *
 */
public abstract class ANTLRFragmentizerPlugin<P extends Parser, L extends Lexer> extends FragmentizerPlugin implements ANTLRBackedPlugin<P,L> {

	//=============================================================================
	// Interface
	
	/**
	 * Interface for ANTLR parse tree fragmentation rules
	 * 
	 * @author maxmeffert
	 *
	 */
	static public abstract class FragmentationRule<C extends ParserRuleContext> {

		/**
		 * Exception for illegal context arguments
		 * 
		 * @author maxmeffert
		 *
		 */
		static final public class IllegalContextException extends IllegalArgumentException {

			/**
			 * The serial version UID
			 */
			private static final long serialVersionUID = -4814695582039036934L;
			
			/**
			 * Constructs a new IllegalContextException
			 * @param contextType
			 */
			public IllegalContextException (Class<? extends ParserRuleContext> contextType) {
				super("Parameter 'context' must be instance of " + contextType.getName() + "! "
					+ "Test FragmentationRule.accept(context) first!");
			}
			
			
		}
		
		//============================================================================================
		// Interface
		
		/**
		 * Gets the class of the targeted parser rule context
		 * @return
		 */
		abstract protected Class<C> contextType ();
		
		/**
		 * Whether the rule is for 'compound' fragments which contains further fragment parts.
		 * Defaults to false.
		 * 
		 * @return Whether the rule is for 'compound' fragments
		 */
		abstract protected boolean isAtom (C context);
		
		/**
		 * Tests whether the rule is applicable to the current parser rule context
		 * 
		 * @param context The parser rule context to test 
		 * @return Whether the rule is applicable to the current parser rule context
		 */
		abstract protected boolean test (C context);
		
		/**
		 * Creates a new fragment from a parser rule context
		 * 
		 * @param context The parser rule context from which the fragment is created
		 * @return A new fragment
		 */
		abstract protected Collection<Fragment> createFragment (Entity entity, Artifact artifact, C context);
		
		//============================================================================================
		// Hack for contra-variant method calls
		
		/**
		 * Checks whether the rule is applicable to a given parser rule context
		 * @param context
		 * @return
		 */
		final public boolean accept (ParserRuleContext context) {
			return contextType().isInstance(context) 
					&& test(contextType().cast(context));
		}
		
		/**
		 * Checks whether the rule is for a compound fragment depending on a given parser rule context
		 * @param context
		 * @return
		 */
		final public boolean isCompound (ParserRuleContext context) {
			if (!contextType().isInstance(context)) {
				throw new IllegalContextException(contextType());
			}
			return !isAtom(contextType().cast(context));
		}
		
		/**
		 * Creates a new fragment instance
		 * @param entity
		 * @param artifact
		 * @param context
		 * @return
		 */
		final public Collection<Fragment> newFragment (Entity entity, Artifact artifact, ParserRuleContext context) {
			if (!contextType().isInstance(context)) {
				throw new IllegalContextException(contextType());
			}
			return createFragment(entity, artifact, contextType().cast(context));
		}
		
	}
	
	/**
	 * Gets the collection for fragmentation rules
	 * @return
	 */
	abstract public Collection<FragmentationRule<? extends ParserRuleContext>> getRules ();
		
	//=============================================================================
	// Implementation
	 
	/**
	 * Interface for parse tree fragmentation listeners
	 * 
	 * @author maxmeffert
	 *
	 */
	static private interface ParseTreeFragmentationListener extends ParseTreeListener {
		
		/**
		 * Gets the collected fragments
		 * @return
		 */
		public Collection<Fragment> getFragments ();
		
	}
	
	/**
	 * ANTLR ParseTreeListener for code fragmentation
	 * @author maxmeffert
	 *
	 */
	static private class ParseTreeFragmentationListenerImpl implements ParseTreeFragmentationListener {

		/**
		 * The containing entity of the fragments to collect
		 */
		private Entity entity;
		
		/**
		 * The containing artifact of the fragments to collect
		 */
		private Artifact artifact;
		
		/**
		 * A List of fragmentation rules
		 */
		private Collection<FragmentationRule<?>> rules;
		
		/**
		 * Stack for the ParserRuleContext of the current compound fragment.
		 * <br>
		 * This variable keeps track of the current scope.
		 */
		private Stack<ParserRuleContext> stack = new Stack<ParserRuleContext>();
		
		/**
		 * Mapping between ParserRuleContexts and their respective collected fragments.
		 */
		private Map<ParserRuleContext,Collection<Fragment>> fragments = new HashMap<ParserRuleContext,Collection<Fragment>>();
		
		/**
		 * Constructs a new FragmentationListener
		 * @param entity
		 * @param artifact
		 * @param rules
		 */
		public ParseTreeFragmentationListenerImpl (Entity entity, Artifact artifact, Collection<FragmentationRule<? extends ParserRuleContext>> rules) {
			this.entity = entity;
			this.artifact = artifact;
			this.rules = rules;
		}
		
		/**
		 * Gets the collected fragments
		 * @return
		 */
		public Collection<Fragment> getFragments () {
			
			// Since the fragments map has entries for every collected fragment including their child nodes,
			// only fragments without parents, i.e. root fragments, are valid results
//			System.out.println(fragments.values().stream().flatMap(f -> f.stream()).collect(Collectors.toList()));
//			System.out.println(
//					fragments.values().stream()
//						.reduce(new HashSet<Fragment>(), (a,b) -> { a.addAll(b); return a;  })
//					);
			
			Collection<Fragment> result = fragments.values().stream()
					.reduce(new HashSet<Fragment>(), (a,b) -> { a.addAll(b); return a;  });
			
//			System.out.println(result);
			
			return result;
			
//			return fragments.values().stream()
//					.reduce(new HashSet<Fragment>(), (a,b) -> { a.addAll(b); return a;  });
//					.stream()
//					.filter( f -> f.isRoot() )
//					.collect(Collectors.toList());
		}
		
		/**
		 * Collects a new fragment for a context upon entering
		 */
		@Override
		public void enterEveryRule(ParserRuleContext context) {
			
			// for every fragmentation rule
			for (FragmentationRule<?> rule : rules) {
				
				// if the rule is applicable
				if (rule.accept(context)) {
					
					// create a fragment from the parser rule context
					Collection<Fragment> f = rule.newFragment(entity, artifact, context);

					// if the rule is for compound fragment
					if (rule.isCompound(context)) {
						
						// push the current scope onto the stack
						stack.push(context);
						
					}
					
					// map the fragments to its respective context/scope
					fragments.put(context, f);
					
// the following may not be necessary!!!
					
					// if the scope stack is not empty and the current scope is already mapped
//					if (!stack.isEmpty()
//							&& fragments.containsKey(stack.peek())) {

						// get the current compound fragment
//						Collection<Fragment> compounds = fragments.get(stack.peek());

						
						
						// add the new fragment to its compound
//						compound.addPart(f);
//						for(Fragment compound : compounds) {
//							System.out.println(compound.getName());
//							System.out.println(f);
//							compound.addParts(f);
//						}
						
						
//					}
					
					
				}
				
			}
			
		}

		/**
		 * Cleans the scope stack up
		 */
		@Override
		public void exitEveryRule(ParserRuleContext context) {
			
			// if the scope stack is not empty 
			// and the current context is identical to the top of the stack
			if (!stack.isEmpty() && stack.peek() == context) {
				
				// remove the current context from the stack
				stack.pop();
				
				// if the scope stack is not empty then
				// and the top of the stack and the current context is mapped
				if (!stack.isEmpty() 
						&& fragments.containsKey(stack.peek())
						&& fragments.containsKey(context)) {
					
					// then the top of the stack is mapped to a compound fragment
					// add the fragment mapped to the current context to this compound fragment
//					fragments.get(stack.peek().addPart(fragments.get(context));
					for (Fragment fragment : fragments.get(stack.peek())) {
						fragment.addParts(fragments.get(context));
					}
				}
				
			}
			
		}

		@Override
		public void visitErrorNode(ErrorNode arg0) {
			// do nothing			
		}

		@Override
		public void visitTerminal(TerminalNode arg0) {
			// do nothing			
		}
		
	}
	
	/**
	 * Gets the fragments of a given entity and its associated artifact
	 */
	@Override
	final public Collection<Fragment> getFragments(Entity entity, Artifact artifact) {
		
		// Create a new fragmentation listener
		ParseTreeFragmentationListener listener = new ParseTreeFragmentationListenerImpl(entity, artifact, getRules());
		
		// Create a new parse tree walker
		ParseTreeWalker walker = new ParseTreeWalker();
		
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
		// Return the collected fragments
		return listener.getFragments();
		
	}
	
}
