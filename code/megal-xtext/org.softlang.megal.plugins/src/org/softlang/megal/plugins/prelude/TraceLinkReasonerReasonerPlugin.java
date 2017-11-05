package org.softlang.megal.plugins.prelude;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Iterables.concat;

import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.KBs;
import org.softlang.megal.mi2.Ref;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.api.AbstractReasonerPlugin;
import org.softlang.megal.mi2.api.context.Context;

import org.softlang.megal.plugins.util.Prelude;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class TraceLinkReasonerReasonerPlugin extends AbstractReasonerPlugin {
	@Override
	public KB derive(Context context, Relationship relationship) {

		if (Prelude.isElementOfLanguage(relationship.getLeft(), "XML")
				&& Prelude.isElementOfLanguage(relationship.getRight(), "XSD")) {

			Multimap<String, String> ab = HashMultimap.create();
			// ...
			return KBs
					.builder()
					.setEntities(
							from(concat(ab.keys(), ab.values())).toMap(
									x -> Ref.to("Fragment", false)))
					.setRelationships(null)
					.setBindings(null)
							.build();
		}
		return super.derive(context, relationship);
	}
}
