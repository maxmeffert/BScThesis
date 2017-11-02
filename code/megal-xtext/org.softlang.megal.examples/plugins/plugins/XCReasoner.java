package plugins;

import org.softlang.megal.mi2.Entity;

import plugins.prelude.GuidedReasonerPlugin;
import plugins.util.Prelude;

public class XCReasoner extends GuidedReasonerPlugin {
	@Override
	public boolean isContextBased() {
		return false;
	}
	@Override
	protected void guidedDerive(Entity entity) throws Throwable {
		when(Prelude.isElementOfLanguage(entity, "TestLang"));
		int n = emitTree(entity, 0, 5, 10);
		entity("Count/" + n, "Entity");
	}

	private int emitTree(Entity parent, int n, int i, int j) {
		int r = 1;
		Entity current = entity(parent.getName() + "/" + n, "Fragment");
		relationship(current.getName(), parent.getName(), "partOf");
		if (i > 0)
			for (int x = 0; x < j; x++)
				r += emitTree(current, x, i - 1, j);
		return r;
	}
}
