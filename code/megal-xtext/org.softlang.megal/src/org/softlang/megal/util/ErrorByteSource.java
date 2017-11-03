package org.softlang.megal.util;

import java.io.IOException;
import java.io.InputStream;

import com.google.common.io.ByteSource;

public final class ErrorByteSource extends ByteSource {
	private final Throwable throwable;

	public ErrorByteSource(Throwable throwable) {
		this.throwable = throwable;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	@Override
	public InputStream openStream() throws IOException {
		throw new IOException(throwable);
	}
}
