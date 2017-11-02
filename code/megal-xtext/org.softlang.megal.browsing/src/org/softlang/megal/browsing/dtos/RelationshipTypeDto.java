package org.softlang.megal.browsing.dtos;

import org.softlang.megal.mi2.RelationshipType;

public class RelationshipTypeDto {
	
	static public RelationshipTypeDto from(RelationshipType type) {
		return new RelationshipTypeDto(type);
	}
	
	private String name;
	private String left;
	private String right;
	private boolean isLeftMany;
	private boolean isRightMany;
	
	public RelationshipTypeDto(RelationshipType type) {
		this(type.getName(), type.getLeft().getName(), type.getRight().getName(), type.isLeftMany(), type.isRightMany());
	}
	
	public RelationshipTypeDto(String name, String left, String right, boolean isLeftMany, boolean isRightMany) {
		this.name = name;
		this.left = left;
		this.right = right;
		this.isLeftMany = isLeftMany;
		this.isRightMany = isRightMany;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getLeft() {
		return left;
	}

	protected void setLeft(String left) {
		this.left = left;
	}

	protected String getRight() {
		return right;
	}

	protected void setRight(String right) {
		this.right = right;
	}

	protected boolean isLeftMany() {
		return isLeftMany;
	}

	protected void setLeftMany(boolean isLeftMany) {
		this.isLeftMany = isLeftMany;
	}

	protected boolean isRightMany() {
		return isRightMany;
	}

	protected void setRightMany(boolean isRightMany) {
		this.isRightMany = isRightMany;
	}
	
	
	
}