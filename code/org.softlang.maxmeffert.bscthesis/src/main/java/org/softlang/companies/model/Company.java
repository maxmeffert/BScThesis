package org.softlang.companies.model;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.*;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.*;

@Entity
@XmlRootElement(name="company")
@XmlAccessorType(XmlAccessType.FIELD)
public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@XmlAttribute
	private int id;
	
	@XmlAttribute
	private String name;
	
	@XmlElementWrapper(name="departments")
	@XmlElement(name="department")
	@OneToMany(mappedBy="company", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Collection<Department> departments;
	
	public Company() {
		departments = new LinkedList<>();
	}
	
	public Company(String name) {
		this();
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
