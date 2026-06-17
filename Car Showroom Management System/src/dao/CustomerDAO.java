package dao;

import model.Customer;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
	
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO customers(name, phone, email) VALUES(?, ?, ?)";
		
		try (Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getPhone());
			ps.setString(3, customer.getEmail());
			
			ps.executeUpdate();
			
			System.out.println("Customer Added.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Customer> getAllCustomers() {
		
		List<Customer> customers = new ArrayList<>();
		
		String sql = "SELECT * FROM customers";
		
		try (Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql)) {
			
			while (rs.next()) {
				
				Customer c = new Customer();
				
				c.setId(rs.getInt("customer_id"));
				c.setName(rs.getString("name"));
				c.setPhone(rs.getString("phone"));
				c.setEmail(rs.getString("email"));
				
				customers.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return customers;
	}
	
	public Customer getCustomerById(int id) {
		
		String sql = "SELECT * FROM customers WHERE customer_id = ?";
		
		try (Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				Customer c = new Customer();
				
				c.setId(rs.getInt("customer_id"));
				c.setName(rs.getString("name"));
				c.setPhone(rs.getString("phone"));
				c.setEmail(rs.getString("email"));
				
				return c;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
