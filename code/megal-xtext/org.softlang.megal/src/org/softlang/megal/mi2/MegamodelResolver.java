package org.softlang.megal.mi2;

import org.softlang.megal.MegalDeclaration;
import org.softlang.megal.MegalEntity;
import org.softlang.megal.MegalEntityType;
import org.softlang.megal.MegalFile;
import org.softlang.megal.MegalLink;
import org.softlang.megal.MegalRelationship;
import org.softlang.megal.MegalRelationshipType;

public final class MegamodelResolver {
	private final boolean transitive;

	private final MegalFile file;

	private MegamodelResolver(boolean transitive, MegalFile file) {
		this.transitive = transitive;
		this.file = file;
	}

	public static MegamodelResolver local(MegalFile file) {
		return new MegamodelResolver(false, file);
	}

	public static MegamodelResolver local(MegalDeclaration declaration) {
		return local((MegalFile) declaration.eContainer());
	}

	public static MegamodelResolver local(MegalLink link) {
		return local((MegalFile) link.eContainer());
	}

	public static MegamodelResolver transitive(MegalFile file) {
		return new MegamodelResolver(true, file);
	}

	public static MegamodelResolver transitive(MegalDeclaration declaration) {
		return transitive((MegalFile) declaration.eContainer());
	}

	public static MegamodelResolver transitive(MegalLink link) {
		return transitive((MegalFile) link.eContainer());
	}

	public MegalEntityType resolve(EntityType entityType) {
		return MegamodelKB.resolve(transitive, file, entityType);
	}

	public MegalRelationshipType resolve(RelationshipType relationshipType) {
		return MegamodelKB.resolve(transitive, file, relationshipType);
	}

	public MegalEntity resolve(Entity entity) {
		return MegamodelKB.resolve(transitive, file, entity);
	}

	public MegalRelationship resolve(Relationship relationship) {
		return MegamodelKB.resolve(transitive, file, relationship);
	}
}
