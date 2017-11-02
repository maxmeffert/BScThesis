package org.softlang.megal.browsing.dtos;

import org.softlang.megal.mi2.Entity;

public class EntityDto {
	
	static public EntityDto from(Entity entity) {
		return new EntityDto(entity);
	}
	
	private String name;
	private String type;
	
	public EntityDto(Entity entity) {
		this(entity.getName(), entity.getType().getName());
	}
	
	public EntityDto(String name, String type) {
		this.name = name;
		this.type = type;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getType() {
		return type;
	}

	protected void setType(String type) {
		this.type = type;
	}
	
	
	
}