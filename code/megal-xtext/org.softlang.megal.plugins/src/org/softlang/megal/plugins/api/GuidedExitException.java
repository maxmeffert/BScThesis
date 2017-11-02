package org.softlang.megal.plugins.api;

import org.softlang.megal.mi2.api.context.Context;

import com.google.common.base.Throwables;

public class GuidedExitException extends RuntimeException {
	public static enum Level {
		NOT_RESPONSIBLE, WARNING, ERROR
	}

	private static final long serialVersionUID = -2849721969483884329L;

	private final Level level;

	public GuidedExitException(Level level) {
		this.level = level;
	}

	public GuidedExitException(Level level, String message) {
		super(message);
		this.level = level;
	}

	public GuidedExitException(Level level, Throwable cause) {
		super(cause);
		this.level = level;
	}

	public GuidedExitException(Level level, String message, Throwable cause) {
		super(message, cause);
		this.level = level;
	}

	public Level getLevel() {
		return level;
	}

	public static void handleGuideException(Context context,
			GuidedExitException e) {
		switch (e.getLevel()) {
		case NOT_RESPONSIBLE:
			break;
		case WARNING:
			context.warning(e.getMessage());
			break;
		case ERROR:
			context.error(e.getMessage());
			break;
		}
	}

	public static void handleOtherException(Context context, Throwable e) {
		context.warning(Throwables.getStackTraceAsString(e));
	}
}