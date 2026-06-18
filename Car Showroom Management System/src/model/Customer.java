package model;

public class Customer extends Person {
	
	private String phone;
	private String email;
	
	public Customer() {
	}
	
	public Customer(int id, String name, String phone, String email) {
		super(id, name);
		this.phone = phone;
		this.email = email;
	}
	
	public void displayInfo() {
		
		System.out.println(id + " " + name + " " + phone + " " + email);
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
