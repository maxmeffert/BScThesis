package org.softlang.maxmeffert.bscthesis.scenarios.model;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

import org.hibernate.annotations.GenericGenerator;



@Entity
@XmlRootElement(name="company")
public class Company {

	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	private int id;
	private String name;
	
	@XmlElementWrapper(name="departments")
	@XmlElement(name="department")
	@OneToMany(mappedBy="company", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Collection<Department> departments = new LinkedList<Department>();
	
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
	public Collection<Department> getDepartments() {
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
