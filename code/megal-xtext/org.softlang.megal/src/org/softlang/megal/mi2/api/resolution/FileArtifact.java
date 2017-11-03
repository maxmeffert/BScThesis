package org.softlang.megal.mi2.api.resolution;

import static com.google.common.base.Objects.equal;
import static com.google.common.collect.Lists.transform;

import java.io.File;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.softlang.megal.mi2.api.Artifact;

import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Files;

public class FileArtifact extends Artifact {
	private final File file;

	public FileArtifact(File file) {
		this.file = file;
	}

	@Override
	public boolean exists() {
		return file.exists();
	}

	@Override
	public URI getLocation() {
		return file.toURI();
	}

	@Override
	public String getName() {
		return file.getName();
	}

	@Override
	public Artifact getParent() {
		return LocalArtifacts.toArtifact(file.getParentFile());
	}

	@Override
	public List<? extends Artifact> getChildren() {
		return transform(Arrays.asList(file.listFiles()), LocalArtifacts::toArtifact);
	}

	@Override
	public boolean hasContent() {
		return file.isFile();
	}

	@Override
	public ByteSource getBytes() {
		return Files.asByteSource(file);
	}

	@Override
	public CharSource getChars() {
		return Files.asCharSource(file, Charset.defaultCharset());
	}

	@Override
	public int hashCode() {
		return file.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (obj instanceof FileArtifact) {
			FileArtifact other = (FileArtifact) obj;

			return equal(file, other.file);
		}

		if (obj instanceof Artifact) {
			Artifact other = (Artifact) obj;

			return equal(getLocation(), other.getLocation());
		}

		return false;
	}

	@Override
	public String toString() {
		return file.toString();
	}
}
