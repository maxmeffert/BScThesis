package org.softlang.megal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.softlang.megal.fragmentprovider.Evaluator;
import org.softlang.sourcesupport.SourceSupportPlugin;

public class MegalPlugin implements BundleActivator {
	public static final String PLUGIN_ID = "org.softlang.megal";

	private static Evaluator evaluator;

	public static Evaluator getEvaluator() {
		return evaluator;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		evaluator = new Evaluator();

		SourceSupportPlugin.getSupport();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
	}

}
