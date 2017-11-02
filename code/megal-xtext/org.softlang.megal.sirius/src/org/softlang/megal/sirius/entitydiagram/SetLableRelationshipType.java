package org.softlang.megal.sirius.entitydiagram;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.softlang.megal.MegalFactory;
import org.softlang.megal.MegalFile;
import org.softlang.megal.MegalPackage;
import org.softlang.megal.MegalRelationshipType;
import org.softlang.megal.sirius.MegalServices;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class SetLableRelationshipType implements IExternalJavaAction {

	@Override
	public boolean canExecute(Collection<? extends EObject> arg0) {
		return true;
	}

	@Override
	public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
		String lable = (String) arg1.get("lable");

		MegalRelationshipType relation = (MegalRelationshipType) arg0.iterator().next();

		MegalFile megamodel = MegalServices.INSTANCE.megalFile(relation);

		// Target RelationshipTypes.
		List<MegalRelationshipType> merged = MegalServices.INSTANCE.merged(relation);

		List<String> lables = Splitter.on(CharMatcher.anyOf(MegalServices.SEPARATOR)).omitEmptyStrings().splitToList(lable);
	
		// TODO: Implement this based on difference.
		for (int i = 0; i < lables.size(); i++) {
			if (i < merged.size())
				// Rename.
				merged.get(i).setName(lables.get(i));
			else {
				// Create.
				MegalRelationshipType newRelationshipType = MegalFactory.eINSTANCE.createMegalRelationshipType();
				newRelationshipType.setName(lables.get(i));
				newRelationshipType.setLeft(relation.getLeft());
				newRelationshipType.setRight(relation.getRight());
				megamodel.getDeclarations().add(newRelationshipType);
			}
		}
		// Delete.
		for (int i = lables.size(); i < merged.size(); i++) {
			megamodel.getDeclarations().remove(merged.get(i));
		}
	}
}
