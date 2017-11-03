package org.softlang.megal.language.validation;

import static org.softlang.megal.MegalPackage.Literals.MEGAL_NAMED__NAME;
import static org.softlang.megal.MegalPackage.Literals.MEGAL_RELATIONSHIP__TYPE;

import org.eclipse.xtext.validation.Check;
import org.softlang.megal.MegalEntityType;
import org.softlang.megal.MegalFile;
import org.softlang.megal.MegalRelationship;
import org.softlang.megal.language.MegalReasoning;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.MegamodelKB;
import org.softlang.megal.mi2.Relationship;

public class IntegrityValidation extends AbstractMegalValidator {

	@Check
	public void validateEntityName(MegalEntityType entityType) {
		// Check applies to the 'Entity' type only
		if (entityType.getSupertype() != null)
			return;

		// If not matching with KB, this is a severe error
		if (!KB.ENTITY.equals(entityType.getName()))
			error("Root not called " + KB.ENTITY, MEGAL_NAMED__NAME);
	}

	@Check
	public void validateRelationship(MegalRelationship relationship) {
		MegalFile megamodel = (MegalFile) relationship.eContainer();

		KB kb = MegalReasoning.getKB(megamodel);
		Relationship match = kb.getRelationship(relationship.getLeft().getName(), relationship.getType().getName(),
				relationship.getRight().getName());

		if (match != null && match.getType() == null)
			error("No applicable relationship type for " + match + ".", MEGAL_RELATIONSHIP__TYPE);
	}

}
