package org.softlang.megal.browsing.dtos;

import org.softlang.megal.mi2.EntityType;

public class EntityTypeDto {
	
	static public EntityTypeDto from(EntityType entityType) {
		return new EntityTypeDto(entityType);
	}
	
	private String name;
	private String superType;
	
	public EntityTypeDto(EntityType entityType) {
		this(entityType.getName(), entityType.getSupertype() != null ? entityType.getSupertype().getName() : "");
	}
	
	public EntityTypeDto(String name, String superType) {
		setName(name);
		setSuperType(superType);
	}
	
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected String getSuperType() {
		return superType;
	}
	protected void setSuperType(String superType) {
		this.superType = superType;
	}
	
}