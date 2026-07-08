package database2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DoConnection {
	private static String driver_path = "com.mysql.cj.jdbc.Driver";
	private static String database_name = "batch_k_1316";
	private static String database_url = "jdbc:mysql://localhost:3306/";
	private static String username = "root";
	private static String password = "kaveri";
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static PreparedStatement preparedStatement = null;
	
	public static void updateEmployee(int id,Employee employee) {
		int row = 0;
		String update_query = "update employee set name = ?, salary = ?, designation = ?, d_id = ? where id = ?";
		try {
			openConnection();
			preparedStatement = connection.prepareStatement(update_query);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setDouble(2, employee.getSalary());
			preparedStatement.setString(3, employee.getDesignation());
			preparedStatement.setInt(4, employee.getDepartment_id());
			preparedStatement.setInt(5, id); //id passed
			
			row = preparedStatement.executeUpdate();
			
			if(row > 0) {
				System.out.println("Employee updated successfully");
			}else {
				 System.out.println("Employee not found / not updated");
			}
			
			
			
			
		}catch(SQLException e) {
	        System.out.println(e);
	    } finally {
	        closeConnection();
	    }
		
	}
	
	public static void deleteEmployeeById(int id) {
		int row = 0;
		String delete_query = "delete from employee where id = ?";
		
		try {
			openConnection();
			preparedStatement = connection.prepareStatement(delete_query);
			preparedStatement.setInt(1, id);
			
			row = preparedStatement.executeUpdate();
			
			if(row > 0) {
				System.out.println("Employee deleted successfully");
	        } else {
	            System.out.println("Employee not found");
	        }
		}catch(SQLException e) {
	        System.out.println(e);
	    } finally {
	        closeConnection();
	    }
		
	}
	
	public static Employee searchEmployeeById(int id) {
		Employee employee = null;
		String select_query = "select * from employee where id = ?";
		
		try {
			openConnection();
			preparedStatement = connection.prepareStatement(select_query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			employee = new Employee();
			while(resultSet.next()) {
				employee.setId(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setSalary(resultSet.getDouble(3));
				employee.setDesignation(resultSet.getString(4));
				employee.setDepartment_id(resultSet.getInt(5));
				
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		finally {
			closeConnection();
		}
		return employee;
	}
	
	public static void insertEmployee(Employee employee) {
		int row = 0;
		String insert_query = "insert into employee values(?,?,?,?,?)";
		try {
			openConnection();
			preparedStatement = connection.prepareStatement(insert_query);
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setDouble(3, employee.getSalary());
			preparedStatement.setString(4, employee.getDesignation());
			preparedStatement.setInt(5, employee.getDepartment_id());
			row = preparedStatement.executeUpdate();
			if(row > 0) {
				System.out.println("Employee Data Inserted");
			}
			else {
				System.out.println("Employee data not inserted");
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		finally {
		    closeConnection();
		}
	}
	
	
	public static void getAllEmployee() {
		String query = "select * from employee";
		try {
			openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				System.out.println("----------------");
				System.out.println("Id -: "+resultSet.getInt(1));
				System.out.println("Name -: "+resultSet.getString(2));
				System.out.println("Salary Rs. "+resultSet.getDouble(3)+" /-");
				System.out.println("Designation "+resultSet.getString(4));
				System.out.println("Department Id -: "+resultSet.getInt(5));
				
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		finally {
			closeConnection();
		}
	}
	
	
	public static void closeConnection() {
		try {
			if(connection != null) {
				connection.close();
				connection = null;
			}
			System.out.println("Connection closed...");
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public static void openConnection() {
		try {
			Class.forName(driver_path);
			connection = DriverManager.getConnection(database_url+database_name, username, password);
			System.out.println("Connection Established...");
			
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		} catch(SQLException e) {
			System.out.println(e);
		}
		
		
	}
	
	
}
