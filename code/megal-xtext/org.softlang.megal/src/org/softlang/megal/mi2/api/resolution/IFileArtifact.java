package org.softlang.megal.mi2.api.resolution;

import static java.util.Collections.emptyList;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.softlang.megal.mi2.api.Artifact;

import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;

public class IFileArtifact extends IResourceArtifact {
	final IFile file;

	public IFileArtifact(IFile file) {
		this.file = file;
	}

	@Override
	protected IFile getResource() {
		return file;
	}

	@Override
	public List<? extends Artifact> getChildren() {
		return emptyList();
	}

	@Override
	public boolean hasContent() {
		return true;
	}

	@Override
	public ByteSource getBytes() {
		return new ByteSource() {
			@Override
			public InputStream openStream() throws IOException {
				try {
					return file.getContents();
				} catch (CoreException e) {
					throw new IOException(e);
				}
			}
		};
	}

	@Override
	public CharSource getChars() {
		return new CharSource() {
			@Override
			public Reader openStream() throws IOException {
				try {
					return new InputStreamReader(file.getContents(), file.getCharset());
				} catch (CoreException e) {
					throw new IOException(e);
				}
			}
		};
	}
}
