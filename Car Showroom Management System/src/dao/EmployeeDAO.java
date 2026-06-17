package dao;

import model.Employee;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	public void addEmployee(Employee employee) {
		
		String sql = "INSERT INTO employees(name, designation, salary) VALUES(?, ?, ?)";
		
		try (Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getDesignation());
			ps.setDouble(3, employee.getSalary());
			
			ps.executeUpdate();
			
			System.out.println("Employee Added.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee> getAllEmployees() {
		
		List<Employee> employees = new ArrayList<>();
		
		String sql = "SELECT * FROM employees";
		
		try (Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql)) {
			
			while (rs.next()) {
				Employee emp = new Employee();
				
				emp.setId(rs.getInt("employee_id"));
				emp.setName(rs.getString("name"));
				emp.setDesignation(rs.getString("designation"));
				emp.setSalary(rs.getDouble("salary"));
				
				employees.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return employees;
	}
	
	public Employee getEmployeeById(int id) {
		
		String sql = "SELECT * FROM employees WHERE employee_id = ?";
		
		try (Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Employee emp = new Employee();
				
				emp.setId(rs.getInt("employee_id"));
				emp.setName(rs.getString("name"));
				emp.setDesignation(rs.getString("designation"));
				emp.setSalary(rs.getDouble("salary"));
				
				return emp;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
