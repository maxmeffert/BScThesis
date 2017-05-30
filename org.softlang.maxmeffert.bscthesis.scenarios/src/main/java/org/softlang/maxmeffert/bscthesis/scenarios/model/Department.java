package org.softlang.maxmeffert.bscthesis.scenarios.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@XmlRootElement(name="department")
public class Department {
	
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	private int id;
	private String name;
	
	@XmlElementWrapper(name="employees") 
	@XmlElement(name="employee")
	@OneToMany(mappedBy="department", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Employee> employees = new LinkedList<Employee>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="company_id", insertable=false)
	private Company company;
	
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
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
}
