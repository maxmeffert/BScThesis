package org.softlang.megal.util;

import java.io.IOException;
import java.io.Reader;

import com.google.common.io.CharSource;

public class ErrorCharSource extends CharSource {
	private final Throwable throwable;

	public ErrorCharSource(Throwable throwable) {
		this.throwable = throwable;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	@Override
	public Reader openStream() throws IOException {
		throw new IOException(throwable);
	}
}
