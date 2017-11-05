package org.softlang.megal.plugins.prelude;

import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.KBs;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.api.AbstractReasonerPlugin;
import org.softlang.megal.mi2.api.context.Context;

public class FilesElementOfFolderReasonerPlugin extends AbstractReasonerPlugin {
	@Override
	public KB derive(Context context, Relationship relationship) {
		if (!relationship.getRight().hasBinding())
			return KBs.empty();

		if (relationship.getLeft().hasBinding())
			return KBs.empty();

		return KBs.builder().setBindings(null).build();
	}
}
