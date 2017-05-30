package org.softlang.maxmeffert.bscthesis.scenarios.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="company")
public class Company {

	private int id;
	private String name;
	
	@XmlElementWrapper(name="departments")
	@XmlElement(name="department")
	private List<Department> departments = new LinkedList<Department>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Department> getDepartments() {
		return departments;
	}
	public boolean add(Department e) {
		return departments.add(e);
	}
	public boolean remove(Object o) {
		return departments.remove(o);
	}
	public boolean addAll(Collection<? extends Department> c) {
		return departments.addAll(c);
	}
	public boolean removeAll(Collection<?> c) {
		return departments.removeAll(c);
	}
	
}
