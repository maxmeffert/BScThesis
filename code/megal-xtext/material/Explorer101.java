package superball;

import static org.softlang.megal.Annotations.*;

import org.softlang.megal.Entity;
import org.softlang.megal.api.Resolver;
import org.softlang.megal.api.URI;

public class Explorer101 extends Resolver {
	public static final String DEFAULT_BASE = "http://101companies.org/resources/";

	private String base;

	@Override
	public void load(Entity resolver) {
		// Override the base with the annotations value if present
		base = getAnnotation(resolver, "Base", DEFAULT_BASE);
	}

	@Override
	public boolean resolves(Entity e) {
		// Resolves if the name of the type is 'Technology' or 'Language'
		String typename = e.getType().getDefinition().getName();
		return "Language".equals(typename) || "Technology".equals(typename);
	}

	private static String uniformName(String n) {
		return n.replace(' ', '_');
	}

	@Override
	public String resolve(Entity e) {
		String typename = e.getType().getDefinition().getName();
		String value = uniformName(getEffectiveName(e));

		// Make an URI relative to the responsible root
		if ("Language".equals(typename))
			return base + "languages/" + value;
		if ("Technology".equals(typename))
			return base + "technologies/" + value;

		throw new IllegalStateException();
	}

	@Override
	public String toString() {
		if (!DEFAULT_BASE.equals(base))
			return "Explorer 101, base=" + base;

		return "Explorer 101";
	}
}
