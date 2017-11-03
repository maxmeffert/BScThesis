package org.softlang.megal.defaultprovider.resource;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaCore;

import com.google.common.io.Files;

public class JavaAstFragmentProvider extends ResourceFragmentProvider {

	private static final String KEY = "ast";

	@Override
	public boolean accept(Object node) {
		return super.accept(node) && node instanceof IFile
				&& "java".equals(Files.getFileExtension(((IFile) node).getName()));
	}

	@Override
	public List<? extends Object> navigate(Object node, String segment) {
		if (KEY.equals(segment)) {
			// Get access to java AST of IFile.
			IJavaElement myJavaFile = JavaCore.create((IFile) node);

			return Collections.singletonList(myJavaFile);
		}
		return Collections.emptyList();
	}

	@Override
	public Set<String> next(Object node) {
		return Collections.singleton(KEY);
	}

}
