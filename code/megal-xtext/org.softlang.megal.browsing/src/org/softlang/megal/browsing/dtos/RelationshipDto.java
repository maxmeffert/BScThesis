package org.softlang.megal.browsing.dtos;

import org.softlang.megal.mi2.Relationship;

public class RelationshipDto {

	static public RelationshipDto from(Relationship rel) {
		return new RelationshipDto(rel);
	}
	
	private String name;
	private String left;
	private String right;
	
	public RelationshipDto(Relationship rel) {
		this(rel.getTypeName(), rel.getLeft().getName(), rel.getRight().getName());
	}
	
	public RelationshipDto(String name, String left, String right) {
		setName(name);
		setLeft(left);
		setRight(right);
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
	
	
	
}
