package org.softlang.maxmeffert.bscthesis.scenarios.model;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.*;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.*;

@Entity
@XmlRootElement(name="company")
public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	@XmlElementWrapper(name="departments")
	@XmlElement(name="department")
	@OneToMany(mappedBy="company", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Collection<Department> departments = new LinkedList<Department>();
	
	public Company() {}
	
	public Company(String name) {
		setName(name);
	}

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
	
}
