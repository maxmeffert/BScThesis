/*
 * generated by Xtext
 */
package org.softlang.megal.language.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.softlang.megal.language.ui.internal.MegalActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class MegalExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return MegalActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return MegalActivator.getInstance().getInjector(MegalActivator.ORG_SOFTLANG_MEGAL_LANGUAGE_MEGAL);
	}
	
}
