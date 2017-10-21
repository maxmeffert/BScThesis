package org.softlang.companies.model;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.*;
import javax.xml.bind.annotation.*;


@Entity
@XmlRootElement(name="department")
@XmlAccessorType(XmlAccessType.FIELD)
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@XmlAttribute
	private int id;
	
	@XmlAttribute
	private String name;
	
	@XmlElementWrapper(name="employees") 
	@XmlElement(name="employee")
	@OneToMany(mappedBy="department", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Collection<Employee> employees;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="company_id")
	@XmlTransient
	private Company company;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Employee manager;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="superDepartment_id")
	@XmlTransient
	private Department superDepartment;
	
	@OneToMany(mappedBy="superDepartment", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Collection<Department> subDepartments;
	
	public Department() {
		employees = new LinkedList<>();
		subDepartments = new LinkedList<>();
	}
	
	public Department(String name) {
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
	public Collection<Employee> getEmployees() {
		return employees;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public Department getSuperDepartment() {
		return superDepartment;
	}
	public void setSuperDepartment(Department superDepartment) {
		this.superDepartment = superDepartment;
	}
	public Collection<Department> getSubDepartments() {
		return subDepartments;
	}
}
