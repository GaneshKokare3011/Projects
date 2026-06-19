package model;

public class Employee extends Person {
	
	private String designation;
	private double salary;
	
	public Employee() {
	}
	
	public Employee(int id, String name, String designation, double salary) {
		super(id, name);
		this.designation = designation;
		this.salary = salary;
	}
	
	public void displayInfo() {
		
		System.out.println(id + " " + name + " " + designation + " " + salary);
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
