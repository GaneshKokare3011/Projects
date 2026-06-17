package dao;

import model.Sale;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO {

	public void AddSale(Sale sale) {
		
		String sql = "INSERT INTO sales(customer_id, car_id, employee_id, sale_date) VALUES(?, ?, ?, ?)";
		
		try (Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, sale.getCustomerId());
			ps.setInt(2, sale.getCarId());
			ps.setInt(3, sale.getEmployeeId());
			ps.setDate(4, sale.getSaleDate());
			
			ps.executeUpdate();
			
			System.out.println("Sale Recorded.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Sale> getAllSales() {
		
		List<Sale> sales = new ArrayList<>();
		
		String sql = "SELECT * FROM sales";
		
		try (Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql)) {
			
			while (rs.next()) {
				Sale sale = new Sale();
				
				sale.setSaleId(rs.getInt("sale_id"));
				sale.setCustomerId(rs.getInt("customer_id"));
				sale.setCarId(rs.getInt("customer_id"));
				sale.setEmployeeId(rs.getInt("employee_id"));
				sale.setSaleDate(rs.getDate("sale_date"));
				
				sales.add(sale);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sales;
	}
}
