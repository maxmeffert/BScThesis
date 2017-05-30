package org.softlang.maxmeffert.bscthesis.scenarios.model;

import javax.persistence.*;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private int age;
	private double salary;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="department_id")
	private Department department;
	
	@OneToOne(mappedBy="manager", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Department managedDepartment;
	
	public Employee() {}
	
	public Employee(String name, int age, double salary) {
		setName(name);
		setAge(age);
		setSalary(salary);
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}	
}
