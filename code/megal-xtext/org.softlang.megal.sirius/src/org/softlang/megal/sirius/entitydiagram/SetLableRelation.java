package org.softlang.megal.sirius.entitydiagram;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.softlang.megal.MegalFile;
import org.softlang.megal.MegalRelationship;
import org.softlang.megal.MegalRelationshipType;
import org.softlang.megal.sirius.MegalServices;

public class SetLableRelation implements IExternalJavaAction {

	public SetLableRelation() {
	}

	@Override
	public boolean canExecute(Collection<? extends EObject> arg0) {

		return true;
	}

	@Override
	public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {

		String lable = (String) arg1.get("lable");
		MegalRelationship relation = (MegalRelationship) arg0.iterator().next();

		MegalFile megamodel = MegalServices.INSTANCE.megalFile(relation);

		MegalRelationshipType type = MegalServices.INSTANCE.resolveRelationshipType(megamodel, lable);

		if (type != null)

			relation.setType(type);
	}
}
