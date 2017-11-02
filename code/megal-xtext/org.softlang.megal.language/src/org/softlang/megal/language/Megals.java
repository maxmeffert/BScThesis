package org.softlang.megal.language;

import static com.google.common.collect.FluentIterable.from;
import static java.util.Collections.emptyMap;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.softlang.megal.MegalFile;
import org.softlang.megal.MegalPackage;
import org.softlang.megal.language.util.ReaderInputStream;
import org.softlang.sourcesupport.SourceSupportPlugin;

import com.google.common.io.CharSource;
import com.google.common.io.Files;

public class Megals {
	public static MegalFile load(String source, String... imports) throws IOException {
		CharSource csSource = CharSource.wrap(source);
		CharSource[] csImports = new CharSource[imports.length];

		for (int i = 0; i < imports.length; i++)
			csImports[i] = CharSource.wrap(imports[i]);

		return load(csSource, csImports);
	}

	public static MegalFile load(File source, File... imports) throws IOException {
		return load(Charset.defaultCharset(), source, imports);
	}

	public static MegalFile load(Charset charset, File source, File... imports) throws IOException {
		CharSource csSource = Files.asCharSource(source, charset);
		CharSource[] csImports = new CharSource[imports.length];
		
		for (int i = 0; i < imports.length; i++)
			csImports[i] = Files.asCharSource(imports[i], charset);

		return load(csSource, csImports);
	}

	public static MegalFile load(CharSource source, CharSource... imports) throws IOException {
		MegalPackage.eINSTANCE.eClass();

		MegalStandaloneSetup.doSetup();

		ResourceSet set = new ResourceSetImpl();
		
		// FYI: this creates resources with invalid urls regarding SourceSupportPlugin.findProjectName
		// Regards, Max
		
		for (int i = 0; i < imports.length; i++) {
			Resource importResource = set.createResource(URI.createURI("dummy:/import" + i + ".megal"));
			importResource.load(new ReaderInputStream(imports[i].openStream()), emptyMap());
		}

		Resource sourceResource = set.createResource(URI.createURI("dummy:/source.megal"));
		sourceResource.load(new ReaderInputStream(source.openStream()), emptyMap());

		return from(sourceResource.getContents()).filter(MegalFile.class).first().orNull();
	}
}
