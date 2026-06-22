package service;

import dao.CustomerDAO;
import dao.EmployeeDAO;
import dao.SaleDAO;

import model.Car;
import model.Customer;
import model.Employee;
import model.Sale;

import service.CarService;
import service.SaleService;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		CarService carService = new CarService();
		SaleService saleService = new SaleService();
		
		CustomerDAO customerDAO = new CustomerDAO();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		SaleDAO saleDAO = new SaleDAO();
		
		while (true) {
			
			System.out.println("\n=========================");
			System.out.println(" CAR SHOWROOM MANAGEMENT ");
			System.out.println("=========================");
			
			System.out.println("1. Add Car");
			System.out.println("2. View Cars");
			System.out.println("3. Delete Car");
			
			System.out.println("4. Add Customer");
			System.out.println("5. View Customers");
			
			System.out.println("6. Add Employee");
			System.out.println("7. View Employees");
			
			System.out.println("8. Sell Car");
			System.out.println("9. View Sales");
			
			System.out.println("10. Exit");
			System.out.println();
			System.out.print("Enter Your Choice: ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1: 
					Car car = new Car();
					
					System.out.print("Brand: ");
					car.setBrand(sc.next());
					
					System.out.print("Model: ");
					car.setModel(sc.next());
					
					System.out.print("Year: ");
					car.setYear(sc.nextInt());
					
					System.out.print("Color: ");
					car.setColor(sc.next());
					
					System.out.print("Price: ");
					car.setPrice(sc.nextDouble());
					
					System.out.print("Stock: ");
					car.setStock(sc.nextInt());
					
					carService.addCar(car);
					
					break;
					
				case 2:
					List<Car> cars = carService.getAllCars();
					
					System.out.println("\nCAR LIST");
					
					for (Car c : cars) {
						System.out.println(c.getCarId() + " | " + 
										   c.getBrand() + " | " +
										   c.getModel() + " | " +
										   c.getYear() + " | " +
										   c.getColor() + " | " +
										   c.getPrice() + " | Stock=" +
										   c.getStock());
					}
					
					break;
					
				case 3:
					System.out.print("Enter Car Id: ");
					
					int carId = sc.nextInt();
					carService.deleteCar(carId);
					
					break;
					
				case 4:
					Customer customer = new Customer();
					sc.nextLine();
					
					System.out.print("Name: ");
					customer.setName(sc.nextLine());
					
					System.out.print("Phone: ");
					customer.setPhone(sc.nextLine());
					
					System.out.print("Email: ");
					customer.setEmail(sc.nextLine());
					
					customerDAO.addCustomer(customer);
					
					break;
					
				case 5:
					List<Customer> customers = customerDAO.getAllCustomers();
					
					for (Customer c : customers) {
						System.out.println(c.getId() + " | " +
										   c.getName() + " | " +
										   c.getPhone() + " | " +
										   c.getEmail());
					}
					
					break;
					
				case 6:
					Employee employee = new Employee();
					sc.nextLine();
					
					System.out.print("Name: ");
					employee.setName(sc.nextLine());
					
					System.out.print("Designation: ");
					employee.setDesignation(sc.nextLine());
					
					System.out.println("Salary: ");
					employee.setSalary(sc.nextDouble());
					
					employeeDAO.addEmployee(employee);
					
					break;
					
				case 7:
					List<Employee> employees = employeeDAO.getAllEmployees();
					
					for (Employee e : employees) {
						System.out.println(e.getId() + " | " +
										   e.getName() + " | " +
										   e.getDesignation() + " | " +
										   e.getSalary());
					}
					
					break;
					
				case 8:
					System.out.print("Customer Id: ");
					int customerId = sc.nextInt();
					
					System.out.print("Car Id: ");
					int selectedCarId = sc.nextInt();
					
					System.out.print("Employee Id: ");
					int employeeId = sc.nextInt();
					
					saleService.sellCar(customerId, selectedCarId, employeeId);
					
					break;
					
				case 9:
					List<Sale> sales = saleDAO.getAllSales();
					
					System.out.println("\nSALES REPORT");
					
					for (Sale s : sales) {
						System.out.println("Sale Id: " + s.getSaleId() +
										   "Customer: " + s.getCustomerId() +
										   "Car: " + s.getCarId() +
										   "Employee: " + s.getEmployeeId() +
										   "Date: " + s.getSaleDate());
					}
					
					break;
					
				case 10:
					System.out.println("Thank You");
					System.exit(0);
					
				default:
					System.out.println("Invalid Choice");
			}
		}
	}
}
