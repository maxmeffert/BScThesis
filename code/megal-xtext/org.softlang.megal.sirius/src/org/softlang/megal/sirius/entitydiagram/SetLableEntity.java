package org.softlang.megal.sirius.entitydiagram;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.softlang.megal.MegalEntity;
import org.softlang.megal.MegalEntityType;
import org.softlang.megal.MegalFile;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.sirius.MegalServices;

public class SetLableEntity implements IExternalJavaAction {

	public SetLableEntity() {
	}

	@Override
	public boolean canExecute(Collection<? extends EObject> arg0) {

		return true;
	}

	@Override
	public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {

		String lable = (String) arg1.get("lable");
		MegalEntity entity = (MegalEntity) arg0.iterator().next();

		// Extract 'many' information.
		boolean many = false;
		if (lable.endsWith("+")) {
			many = true;
			lable = lable.substring(0, lable.length() - 1);
		}

		String[] fragments = lable.split(":");

		// Set name of entity if name is not already used in scope.
		if (fragments.length > 0) {
			String name = fragments[0];

			MegalEntity resolved = MegalServices.INSTANCE.resolveEntity((MegalFile) entity.eContainer(), name);

			entity.setMany(many);

			if (resolved == null) {
				entity.setName(name);
			}
		}

		// Change type if applicable to all relations that are in scope.
		if (fragments.length > 1) {
			MegalEntityType resolved = MegalServices.INSTANCE.resolveEntityType((MegalFile) entity.eContainer(),
					fragments[1]);

			if (resolved != null)
				entity.setType(resolved);
		}
	}

}
