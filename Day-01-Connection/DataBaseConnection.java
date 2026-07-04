package database1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Step 1 : Load the Driver class");
			
			Connection connection = 
		    DriverManager.getConnection("jdbc:mySQL://localhost:3306/db_name","root","your_password");
			System.out.println("Step 2 : Establish the connection");
			
			String query = "select * from employee";
			System.out.println("Step 3 : Create the required statement");
			
			Statement statement=connection.createStatement();
			System.out.println("Step 4 : Prepare the required SQL Statement");
			
			ResultSet resultSet = statement.executeQuery(query);
			System.out.println("Step 5 : Submit the SQL Statement to database");
			
			while(resultSet.next()) {
				System.out.println("----------------");
				System.out.println("Id -: "+resultSet.getInt(1));
				System.out.println("Name -: "+resultSet.getString(2));
				System.out.println("Salary Rs. "+resultSet.getDouble(3)+" /-");
				System.out.println("Designation "+resultSet.getString(4));
				System.out.println("Department Id -: "+resultSet.getInt(5));
				
				
				
			}
			System.out.println("Step 6: Process the Results");
			
			statement.close();
			connection.close();
			System.out.println("Step 7: Release the Resources");

		}
		
		
		catch(ClassNotFoundException e) {
			System.out.println(e);
		} catch(SQLException e) {
			System.out.println(e);
		}

	}

}
