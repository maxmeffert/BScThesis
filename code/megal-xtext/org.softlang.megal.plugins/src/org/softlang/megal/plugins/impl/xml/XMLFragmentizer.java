package org.softlang.megal.plugins.impl.xml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.antlr.v4.runtime.ParserRuleContext;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.antlr.ANTLRFragmentizerPlugin;
import org.softlang.megal.plugins.api.antlr.ANTLRParserFactory;
import org.softlang.megal.plugins.api.antlr.ANTLRUtils;
import org.softlang.megal.plugins.api.fragmentation.Fragments;
import org.softlang.megal.plugins.api.fragmentation.Fragments.Fragment;
import org.softlang.megal.plugins.impl.xml.antlr.XMLLexer;
import org.softlang.megal.plugins.impl.xml.antlr.XMLParser;
import org.softlang.megal.plugins.impl.xml.antlr.XMLParser.AttributeContext;
import org.softlang.megal.plugins.impl.xml.antlr.XMLParser.ElementContext;
import org.softlang.megal.plugins.impl.xml.antlr.XMLParserFactory;

/**
 * Disassembles every XML artifact into XML fragments, that is XMLElement and XMLAttribute.
 * Also disassembles XSD artifacts and other subsets of XML.
 * 
 * @author maxmeffert
 *
 */
public class XMLFragmentizer extends ANTLRFragmentizerPlugin<XMLParser, XMLLexer> {
	
	/**
	 * Fragmentation rule for XMLElements and XMLAttributes
	 * @author maxmeffert
	 *
	 */
	static private class XMLElementRule extends FragmentationRule<ElementContext> {
				
		@Override
		protected Class<ElementContext> contextType() {
			return ElementContext.class;
		}

		@Override
		protected boolean isAtom(ElementContext context) {
			return ( context.content() == null || context.content().element().isEmpty() ) && context.attribute().isEmpty();
		}

		@Override
		protected boolean test(ElementContext context) {
			return !context.Name().isEmpty();
		}

		@Override
		protected Collection<Fragment> createFragment(Entity entity, Artifact artifact, ElementContext context) {
			
			// Create a new XMLElement fragment
			return Collections.singletonList(
					Fragments.create(
						context.Name(0).toString(),
						"XMLElement",
						ANTLRUtils.originalText(context),
						entity, 
						artifact
						)
					);
			
		}
		
	}
	
	static private class XMLAttributeRule extends FragmentationRule<AttributeContext> {

		@Override
		protected Class<AttributeContext> contextType() {
			return AttributeContext.class;
		}

		@Override
		protected boolean isAtom(AttributeContext context) {
			return true;
		}

		@Override
		protected boolean test(AttributeContext context) {
			return !context.Name().toString().toLowerCase().startsWith("xmlns");
		}

		@Override
		protected Collection<Fragment> createFragment(Entity entity, Artifact artifact, AttributeContext context) {
			return Collections.singletonList(
					Fragments.create(
						context.Name().toString(),
						"XMLAttribute",
						ANTLRUtils.originalText(context),
						entity, 
						artifact
						)
					);
		}
		
	}
	
	static private class XMLNSAttributeRule extends FragmentationRule<AttributeContext> {

		@Override
		protected Class<AttributeContext> contextType() {
			return AttributeContext.class;
		}

		@Override
		protected boolean isAtom(AttributeContext context) {
			return true;
		}

		@Override
		protected boolean test(AttributeContext context) {
			return context.Name().toString().toLowerCase().startsWith("xmlns");
		}

		@Override
		protected Collection<Fragment> createFragment(Entity entity, Artifact artifact, AttributeContext context) {
			return Collections.singletonList(
					Fragments.create(
						context.Name().toString(),
						"XMLNSAttribute",
						ANTLRUtils.originalText(context),
						entity, 
						artifact
						)
					);
		}
		
	}
	
	/**
	 * Gets the collection of XML fragmentation rules
	 */
	@Override
	public Collection<FragmentationRule<? extends ParserRuleContext>> getRules() {
		
		Collection<FragmentationRule<? extends ParserRuleContext>> rules = new ArrayList<FragmentationRule<? extends ParserRuleContext>>();
		rules.add(new XMLElementRule());
		rules.add(new XMLAttributeRule());
		rules.add(new XMLNSAttributeRule());
		
		return rules;
		
	}
	
	/**
	 * 
	 */
	@Override
	public ANTLRParserFactory<XMLParser, XMLLexer> getParserFactory() {
		return new XMLParserFactory();
	}

}
