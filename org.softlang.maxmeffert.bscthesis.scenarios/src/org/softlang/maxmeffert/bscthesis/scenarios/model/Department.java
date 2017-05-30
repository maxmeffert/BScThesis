package org.softlang.maxmeffert.bscthesis.scenarios.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="department")
public class Department {
	
	private String name;
	
	@XmlElementWrapper(name="employees")
	@XmlElement(name="employee")
	private List<Employee> employees = new LinkedList<Employee>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public boolean add(Employee e) {
		return employees.add(e);
	}
	public boolean remove(Object o) {
		return employees.remove(o);
	}
	public boolean addAll(Collection<? extends Employee> c) {
		return employees.addAll(c);
	}
	public boolean removeAll(Collection<?> c) {
		return employees.removeAll(c);
	}
}
