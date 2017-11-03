package org.softlang.megal.mi2.api;

import static com.google.common.base.Objects.equal;

import java.io.File;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;

import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;

public abstract class Artifact {
	
	public abstract boolean exists();

	public abstract URI getLocation();

	public abstract String getName();

	public abstract Artifact getParent();

	public abstract List<? extends Artifact> getChildren();

	public abstract boolean hasContent();

	public abstract ByteSource getBytes();
	
	/**
	 * <p>
	 * Gets the first child with the given name.
	 * </p>
	 * 
	 * @param name
	 *            The name to find
	 * @return Returns an artifact or null TODO: do not return null
	 */
	public Artifact getChild(String name) {
		for (Artifact child : getChildren())
			if (equal(name, child.getName()))
				return child;

		return null;
	}

	public CharSource getChars() {
		return getBytes().asCharSource(Charset.defaultCharset());
	}
	
	public File toFile () {
		return new File(getLocation());
	}
	
}
