package org.softlang.megal.acme.nested;
import java.util.ArrayList;
import java.util.List;

public class Company {
	
	static enum ET {
		Manager;
		
		ET () {
			
		}
	}
	
	static interface Lala {
		
		public void foo ();
		
	}
	
	static public class Department {
	
		static public class Employee {
			
			private String name;
			private int salary;
			
			public Employee () {
				
			}
			
			public Employee (String name, int salary) {
				
				setName(name);
				setSalary(salary);
				
			}
			
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getSalary() {
				return salary;
			}
			public void setSalary(int salary) {
				this.salary = salary;
			}
			
			
			
		}
		
		private String name;
		private List<Employee> employees = new ArrayList<Employee>();
		
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Employee> getEmployees() {
			return employees;
		}
		public void setEmployees(List<Employee> employees) {
			this.employees = employees;
		}
		
		
		
	}

	private String name;
	private List<Department> departments = new ArrayList<Department>();
	
	public Company () {
		
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
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
	
	
	
}
