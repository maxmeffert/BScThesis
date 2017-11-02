package org.softlang.megal.language;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.softlang.megal.MegalFile;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.MegamodelKB;
import org.softlang.megal.mi2.api.ModelExecutor;
import org.softlang.megal.mi2.api.Result;
import org.softlang.megal.mi2.api.resolution.LocalResolution;

public class MegalInteractive {
	public static void main(String[] args) throws IOException {
		// Assert that there are enough arguments
		if (args.length == 0) {
			System.out.println("Usage: model [import locations...]");
			return;
		}

		// Transform paths into files
		File[] files = new File[args.length];
		for (int i = 0; i < args.length; i++)
			files[i] = new File(args[i]);

		// Load files, where first is subject
		MegalFile megal = Megals.load(files[0], Arrays.copyOfRange(files, 1, files.length));

		// Display warnings and errors in code file
		EList<Diagnostic> warnings = megal.eResource().getWarnings();
		EList<Diagnostic> errors = megal.eResource().getErrors();

		for (Diagnostic d : warnings)
			System.out.println(d);

		if (!errors.isEmpty()) {
			for (Diagnostic d : errors)
				System.err.println(d);
			return;
		}

		// Interpret as knowledge base
		KB kb = MegamodelKB.loadAll(megal);

		// New executor, evaluate the KB with it
		ModelExecutor executor = new ModelExecutor();
		
		// Execute on KB
		Result result = executor.evaluate(new LocalResolution() {
			@Override
			protected File getRoot() {
				return new File(System.getProperty("user.dir"));
			}
		}, kb);

		// Simple dump
		System.out.println(":input");
		System.out.println(result.getInput());
		System.out.println(":output");
		System.out.println(result.getOutput());
		System.out.println(":valid");
		System.out.println(result.getValid());
		System.out.println(":info");
		System.out.println(result.getInfos());
		System.out.println(":warning");
		System.out.println(result.getWarnings());
		System.out.println(":error");
		System.out.println(result.getErrors());
	}
}
