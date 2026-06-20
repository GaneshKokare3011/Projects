package model;

import java.sql.Date;

public class Sale {
	
	private int saleId;
	private int customerId;
	private int carId;
	private int employeeId;
	private Date saleDate;
	
	public Sale() {
	}
	
	public Sale(int saleId, int customerId, int carId, int employeeId, Date saleDate) {
		this.saleId = saleId;
		this.customerId = customerId;
		this.carId = carId;
		this.employeeId = employeeId;
		this.saleDate = saleDate;
	}
	
	public int getSaleId() {
		return saleId;
	}
	
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int getCarId() {
		return carId;
	}
	
	public void setCarId(int carId) {
		this.carId = carId;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public Date getSaleDate() {
		return saleDate;
	}
	
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
}
