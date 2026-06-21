package service;

import dao.CarDAO;
import dao.SaleDAO;
import model.Car;
import model.Sale;

import java.sql.Date;

public class SaleService {

	private SaleDAO saleDAO = new SaleDAO();
	private CarDAO carDAO = new CarDAO();
	
	public void sellCar(int customerId, int carId, int employeeId) {
		Car car = carDAO.getCarById(carId);
		
		if (car == null) {
			System.out.println("Car Not Found.");
			return;
		}
		
		if (car.getStock() <= 0) {
			System.out.println("Car Out Of Stock.");
			return;
		}
		
		Sale sale = new Sale();
		
		sale.setCustomerId(customerId);
		sale.setCarId(carId);
		sale.setEmployeeId(employeeId);
		sale.setSaleDate(new Date(System.currentTimeMillis()));
		
		saleDAO.AddSale(sale);
		
		carDAO.updateStock(carId, car.getStock() - 1);
		
		System.out.println("Car Sold Successfully.");
	}
}
