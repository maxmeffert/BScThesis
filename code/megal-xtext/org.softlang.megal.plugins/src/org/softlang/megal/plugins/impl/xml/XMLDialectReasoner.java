package org.softlang.megal.plugins.impl.xml;

import static com.google.common.collect.Iterables.filter;
import static org.softlang.megal.plugins.api.fragmentation.Fragments.fragmentOf;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.plugins.api.GuidedReasonerPlugin;

/**
 * 
 * @author maxmeffert
 *
 */
public class XMLDialectReasoner extends GuidedReasonerPlugin {

	
	/*
	 * TODO
	 * Create a plugin whose PARTS!!! 'resolve' XML elements based on the XML-namespace 
	 * i.e. XSDFragmentResovloer should be a part of this plugin
	 * 
	 */
	
	static private abstract class XMLResolutionRule {
		
		private String xmlName;
		private String entityTypeName;
		
		public XMLResolutionRule (String xmlName, String entityTypeName) {
			this.xmlName = xmlName;
			this.entityTypeName = entityTypeName;
		}
		
		public String getXmlName() {
			return xmlName;
		}
		
		public String getEntityTypeName() {
			return entityTypeName;
		}
		
	}

	static private class AttributeResolutionRule extends XMLResolutionRule {

		static public AttributeResolutionRule create (String xmlName, String entityTypeName) {
			return new AttributeResolutionRule(xmlName, entityTypeName);
		}

		public AttributeResolutionRule(String xmlName, String entityTypeName) {
			super(xmlName, entityTypeName);
		}
		
		
	}
	
	static private class ElementResolutionRule extends XMLResolutionRule {

		static public ElementResolutionRule create (String xmlName, String entityTypeName) {
			return new ElementResolutionRule(xmlName, entityTypeName);
		}

		private List<AttributeResolutionRule> attributeRules = new ArrayList<AttributeResolutionRule>();
		private List<ElementResolutionRule> elementRules = new ArrayList<ElementResolutionRule>();
		
		public ElementResolutionRule(String xmlName, String entityTypeName) {
			super(xmlName, entityTypeName);
		}
		
		public List<AttributeResolutionRule> attributeRules () {
			return attributeRules;
		}

		public List<ElementResolutionRule> elementRules () {
			return elementRules;
		}
		
		public ElementResolutionRule attribute (AttributeResolutionRule rule) {
			
			attributeRules.add(rule);
			
			return this;
			
		}
		
		public ElementResolutionRule element (ElementResolutionRule rule) {
			
			elementRules.add(rule);
			
			return this;
			
		}
		
	}
	
	static private class NamespaceResolution {
		
		private String uri;
		private List<ElementResolutionRule> elementRules = new ArrayList<ElementResolutionRule>();
		
		public NamespaceResolution (String uri) {
			this.uri = uri;
		}
		
		public String uri () {
			return uri;
		}
		
		public List<ElementResolutionRule> elementRules () {
			return elementRules;
		}
		
		public NamespaceResolution element (ElementResolutionRule rule) {
			
			elementRules.add(rule);
			
			return this;
			
		}
		
	}
	
	static public abstract class XMLNSResolver {
		
		abstract public void resolve ();
		
		private NamespaceResolution resolution;
		
		final protected ElementResolutionRule XMLElement (String xmlName, String entityTypeName) {
			return new ElementResolutionRule(xmlName, entityTypeName);
		}
		
		final protected NamespaceResolution namespace () {
			return resolution;
		}
		
		final protected NamespaceResolution namespace (String uri) {
			
			resolution = new NamespaceResolution(uri);
			
			return resolution;
			
		}
		
	}
	
	static private class XSDResolver extends XMLNSResolver {

		@Override
		public void resolve() {
			
			namespace("uri")
				.element(XMLElement("",""))
				;
			
		}
		
	}
	
	private void resolve (AttributeResolutionRule aRule) {
		
	}
	
	
	private void resolve (ElementResolutionRule rule) {
	
		
		for (ElementResolutionRule r : rule.elementRules()) {
			resolve(r);
		}
		
	}
	
	private void resolve (List<ElementResolutionRule> eRules) {
		
		
		
	}
	
	@Override
	protected void guidedDerive(Entity entity) throws Throwable {
		
		when(entity.isInstance(entity.getKB().getEntityType("XMLNSAttribute")) 
				&& fragmentOf(entity).isPresent());
		
		String nsAttributeText = fragmentOf(entity).get().getText();
		
		// For all partial fragmentation plugins
		for (XMLNSResolver resolver : filter(getParts(), XMLNSResolver.class)) {
			
			if (resolver.namespace() != null) {
				
				
				
				Pattern pattern = Pattern.compile("^xmlns:(\\S+)=\"" + resolver.namespace().uri() + "\"");
				Matcher matcher = pattern.matcher(nsAttributeText);
				
				if (matcher.find()) {
					
					
					
					
				}
				
			}
			
			
		}
		
	}
	
}
