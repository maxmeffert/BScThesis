package org.softlang.megal.plugins.impl.xsd;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.Ref;
import org.softlang.megal.plugins.api.GuidedReasonerPlugin;

import static org.softlang.megal.plugins.api.fragmentation.Fragments.*;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author darjeeling
 *
 */
public class XSDFragmentResolver extends GuidedReasonerPlugin {

	static private boolean matchesLower (String s, String pattern) {
		return s.toLowerCase().matches(pattern);
	}
	
	static private Pattern pattern = Pattern.compile("^xmlns:(\\S+)=\"http://www.w3.org/2001/XMLSchema\"");
	
	private KB kb;
	private String nsPrefix;
	
	
	private Entity setEntityType (String entity, String type) {
		
		kb.getRawEntities().put(entity, Ref.to(type, false));
		
		return kb.getEntity(entity);
		
	}
	
	private boolean matchesXSDSchema (String s) {
		
		return matchesLower(s, nsPrefix + ":schema");
		
	}
	
	private boolean matchesXSDElement (String s) {
		
		return matchesLower(s, nsPrefix + ":element");
		
	}
	
	private boolean matchesXSDSequence (String s) {
		
		return matchesLower(s, nsPrefix + ":sequence");
		
	}
	
	private boolean matchesXSDComplexType (String s) {
		
		return matchesLower(s, nsPrefix + ":complextype");
		
	}
		
	private void resolveXSDSchema (Fragment f) {
		
		if (matchesXSDSchema(f.getName())) {
			setEntityType(f.getQualifiedName(), "XSDSchema");
		}
		
	}
	
	private void resolveXSDElement (Fragment f) {
		
		if (matchesXSDElement(f.getName())) {
			setEntityType(f.getQualifiedName(), "XSDElement");
		}
		
	}
	
	private void resolveXSDSequence (Fragment f) {
		
		if (matchesXSDSequence(f.getName())) {
			setEntityType(f.getQualifiedName(), "XSDSequence");
		}
		
	}
	
	private void resolveXSDComplexType (Fragment f) {
		
		if (matchesXSDComplexType(f.getName())) {
			setEntityType(f.getQualifiedName(), "XSDComplexType");
		}
		
	}
	
	private void resolveXSDFragments (Collection<Fragment> fs) {
		
		for (Fragment f : fs) {
			
			resolveXSDSchema(f);
			resolveXSDElement(f);
			resolveXSDSequence(f);
			resolveXSDComplexType(f);
			
		}
		
	}
	
	@Override
	protected void guidedDerive(Entity entity) throws Throwable {
		
		when(entity.isInstance(entity.getKB().getEntityType("XMLNSAttribute")) 
				&& fragmentOf(entity).isPresent());
		
		Matcher matcher = pattern.matcher(fragmentOf(entity).get().getText());
		
		when(matcher.find());
		

		kb = entity.getKB();
		nsPrefix = matcher.group(1);
		
		
		resolveXSDFragments(fragmentsOf(fragmentOf(entity).get().getEntity()));
		
		
//		System.out.println(nsPrefix);
//		setEntityType(kb, entity.getName(), "XSDSchema");
//		System.out.println(fragmentsOf(fragmentOf(entity).get().getEntity()));
//		kb.getRawEntities().put(entity.getName(), Ref.to("XSDSchema", false));
		
		
	}
	
}
