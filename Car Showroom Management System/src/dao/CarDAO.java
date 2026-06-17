package dao;

import model.Car;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
	
	public void addCar(Car car) {
		String sql = "INSERT INTO cars(brand, model, year, color, price, stock) VALUES(?, ?, ?, ?, ?, ?)";
		
		try (Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setString(1,  car.getBrand());
			ps.setString(2, car.getModel());
			ps.setInt(3, car.getYear());
			ps.setString(4, car.getColor());
			ps.setDouble(5, car.getPrice());
			ps.setInt(6, car.getStock());
			
			ps.executeUpdate();
			
			System.out.println("Car Added Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Car> getAllCars() {
		
		List<Car> cars = new ArrayList<>();
		
		String sql = "SELECT * FROM cars";
		
		try (Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql)) {
			
			while (rs.next()) {
				Car car = new Car();
				
				car.setCarId(rs.getInt("car_id"));
				car.setBrand(rs.getString("brand"));
				car.setModel(rs.getString("model"));
				car.setYear(rs.getInt("year"));
				car.setColor(rs.getString("color"));
				car.setPrice(rs.getDouble("price"));
				car.setStock(rs.getInt("stock"));
				
				cars.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cars;
	}
	
	public void updateStock(int carId, int stock) {
		
		String sql = "UPDATE cars SET stock = ? WHERE car_id = ?";
		
		try (Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, stock);
			ps.setInt(2, carId);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Car getCarById(int id) {
		
		String sql = "SELECT * FROM cars WHERE car_id = ?";
		
		try (Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				Car car = new Car();
				
				car.setCarId(rs.getInt("car_id"));
				car.setBrand(rs.getString("brand"));
				car.setModel(rs.getString("model"));
				car.setYear(rs.getInt("year"));
				car.setColor(rs.getString("color"));
				car.setPrice(rs.getDouble("price"));
				car.setStock(rs.getInt("stock"));
				
				return car;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void deleteCar(int id) {
		
		String sql = "DELETE FROM cars WHERE car_id = ?";
		
		try (Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			System.out.println("Car Deleted.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
