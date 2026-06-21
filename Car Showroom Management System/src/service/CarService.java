package service;

import dao.CarDAO;
import model.Car;

import java.util.List;

public class CarService {

	private CarDAO carDAO = new CarDAO();
	
	public void addCar(Car car) {
		carDAO.addCar(car);
	}
	
	public List<Car> getAllCars() {
		return carDAO.getAllCars();
	}
	
	public Car getCarById(int id) {
		return carDAO.getCarById(id);
	}
	
	public void deleteCar(int id) {
		carDAO.deleteCar(id);
	}
	
	public void updateStock(int id, int stock) {
		carDAO.updateStock(id, stock);
	}
}
