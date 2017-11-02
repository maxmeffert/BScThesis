package org.softlang.megal.plugins.api.antlr;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;


import static com.google.common.collect.Iterables.*;

/**
 * Utility class for ANTLR stuff.
 * @author maxmeffert
 *
 */
public abstract class ANTLRUtils {

	/**
	 * Gets the original source text for a given ParserRuleContext
	 * @param context
	 * @return
	 */
	static public String originalText (ParserRuleContext context) {
		
		int a = context.getStart().getStartIndex();
		int b = context.getStop().getStopIndex();
		Interval interval = new Interval(a,b);
		CharStream stream = context.getStart().getInputStream();
		
		return stream.getText(interval);
		
	}
	
	static public List<ParseTree> childrenOf (ParseTree parent) {
		
		List<ParseTree> children = new ArrayList<ParseTree>();
		
		for (int i=0; i < parent.getChildCount(); i++) {
			
			children.add(parent.getChild(i));
			
		}
		
		return children;
		
	}
		
	static public Optional<ParseTree> childAt (ParseTree parent, int i) {
		
		List<ParseTree> children = childrenOf(parent);
		
		if (0 < children.size() && children.size() < i) {
			
			Optional.of(children.get(i));
			
		}
		
		return Optional.empty();
		
	}
	
	static public boolean hasChildren (ParseTree parent) {
		
		return parent.getChildCount() > 0;
		
	}
	
	static public boolean isLeaf (ParseTree tree) {
		
		return !hasChildren(tree);
		
	}
	
	static public Optional<ParseTree> parentOf(ParseTree child) {
		
		return Optional.of(child.getParent());
		
	}
	
	static public boolean hasParent (ParseTree child) {
		
		return parentOf(child).isPresent();
		
	}
	
	static public boolean isRoot (ParseTree tree) {
		
		return !hasParent(tree);
		
	}
	
	static public List<ParseTree> ancestorsOf (ParseTree decendant) {
		
		List<ParseTree> ancestors = new ArrayList<ParseTree>();
		
		Optional<ParseTree> p;
		
		while ((p = parentOf(decendant)).isPresent()) {
			
			ParseTree parent = p.get();
			
			ancestors.add(parent);
			
			decendant = parent;
			
		}
		
		return ancestors;
		
	}
	
	static public List<ParseTree> decendantsOf (ParseTree ancestor) {
		
		List<ParseTree> decendants = new ArrayList<ParseTree>();
		
		for (int i=0; i < ancestor.getChildCount(); i++) {
			
			decendants.add(ancestor.getChild(i));
			decendants.addAll(decendantsOf(ancestor.getChild(i)));
			
		}
		
		return decendants;
		
	}
	
	static public boolean isAncestorOf(ParseTree decendant, Class<? extends ParseTree> ancestor) {
		
		return any(ancestorsOf(decendant), a -> ancestor.isInstance(a));
		
	}
	
	static public boolean isDecendantOf (ParseTree ancestor, Class<? extends ParseTree> decendant) {
		
		return any(decendantsOf(ancestor), d -> decendant.isInstance(d));
		
	}
	
	
}
