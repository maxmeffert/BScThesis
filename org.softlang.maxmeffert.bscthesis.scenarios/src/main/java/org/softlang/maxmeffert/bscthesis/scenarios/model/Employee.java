package org.softlang.maxmeffert.bscthesis.scenarios.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Employee {

	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	private int id;
	private String name;
	private int age;
	private double salary;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="department_id", insertable=false)
	private Department department;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="managedDepartment_id", insertable=false, nullable=true)
	private Department managedDepartment;
	
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
