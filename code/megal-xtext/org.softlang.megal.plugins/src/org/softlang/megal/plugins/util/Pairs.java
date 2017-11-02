package org.softlang.megal.plugins.util;

import static org.softlang.megal.plugins.util.Prelude.incomingFrom;
import static org.softlang.megal.plugins.util.Prelude.isInstance;

import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.Relationship;

public class Pairs {
	public static Entity firstEntityOf(Entity pair) {
		if (!isInstance(pair, "Pair"))
			return null;
		for (Entity first : incomingFrom(pair, "firstOf"))
			return first;

		return null;
	}

	public static Entity secondEntityOf(Entity pair) {
		if (!isInstance(pair, "Pair"))
			return null;
		for (Entity second : incomingFrom(pair, "secondOf"))
			return second;

		return null;
	}

	public static Relationship firstOf(Entity pair) {
		if (!isInstance(pair, "Pair"))
			return null;
		for (Relationship first : pair.incoming("firstOf"))
			return first;

		return null;
	}

	public static Relationship secondOf(Entity pair) {
		if (!isInstance(pair, "Pair"))
			return null;
		for (Relationship second : pair.incoming("secondOf"))
			return second;

		return null;
	}
}
