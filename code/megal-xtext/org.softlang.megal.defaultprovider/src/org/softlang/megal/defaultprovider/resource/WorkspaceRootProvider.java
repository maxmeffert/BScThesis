package org.softlang.megal.defaultprovider.resource;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.softlang.megal.fragmentprovider.RootProvider;

public class WorkspaceRootProvider implements RootProvider {

	@Override
	public List<Object> navigate(String protocol) {

		if ("workspace".equals(protocol))
			return Collections.singletonList((Object) ResourcesPlugin.getWorkspace().getRoot());

		return Collections.emptyList();
	}

}
