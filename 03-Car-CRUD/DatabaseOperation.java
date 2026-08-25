package database2;
import java.sql.*;


public class DatabaseOperation {
	
	private static String driver_path = "com.mysql.cj.jdbc.Driver";
	private static String database_name = "batch_k_1316";
	private static String database_url = "jdbc:mysql://localhost:3306/";
	private static String username = "root";
	private static String password = "kaveri";
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static PreparedStatement preparedStatement = null;
	
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
	
	
	
	//Insert
	public static void insertCar(Car car) {
	    String query = "insert into car values(?,?,?,?,?,?)";

	    try {
	        openConnection();
	        preparedStatement = connection.prepareStatement(query);

	        preparedStatement.setInt(1, car.getId());
	        preparedStatement.setString(2, car.getModel_name());
	        preparedStatement.setString(3, car.getColor());
	        preparedStatement.setDouble(4, car.getPrice());
	        preparedStatement.setString(5, car.getCompany_name());
	        preparedStatement.setString(6, car.getFuel_type());

	        int row = preparedStatement.executeUpdate();

	        if(row > 0) System.out.println("Car Inserted");

	    } catch(Exception e) {
	        System.out.println(e);
	    } finally {
	        closeConnection();
	    }
	}
	
	//Read
	public static void getAllCars() {
	    String query = "select * from car";

	    try {
	        openConnection();
	        statement = connection.createStatement();
	        resultSet = statement.executeQuery(query);

	        while(resultSet.next()) {
	            System.out.println("ID: " + resultSet.getInt(1));
	            System.out.println("Model: " + resultSet.getString(2));
	            System.out.println("Color: " + resultSet.getString(3));
	            System.out.println("Price: " + resultSet.getDouble(4));
	            System.out.println("Company: " + resultSet.getString(5));
	            System.out.println("Fuel: " + resultSet.getString(6));
	            System.out.println("----------------");
	        }

	    } catch(Exception e) {
	        System.out.println(e);
	    } finally {
	        closeConnection();
	    }
	}
	
	//Update
	public static void updateCar(int id, Car car) {
	    String query = "update car set model_name=?, color=?, price=?, company_name=?, fuel_type=? where id=?";

	    try {
	        openConnection();
	        preparedStatement = connection.prepareStatement(query);

	        preparedStatement.setString(1, car.getModel_name());
	        preparedStatement.setString(2, car.getColor());
	        preparedStatement.setDouble(3, car.getPrice());
	        preparedStatement.setString(4, car.getCompany_name());
	        preparedStatement.setString(5, car.getFuel_type());
	        preparedStatement.setInt(6, id);

	        int row = preparedStatement.executeUpdate();

	        if(row > 0) System.out.println("Car Updated");

	    } catch(Exception e) {
	        System.out.println(e);
	    } finally {
	        closeConnection();
	    }
	}
	
	//Delete
	public static void deleteCar(int id) {
	    String query = "delete from car where id=?";

	    try {
	        openConnection();
	        preparedStatement = connection.prepareStatement(query);

	        preparedStatement.setInt(1, id);

	        int row = preparedStatement.executeUpdate();

	        if(row > 0) System.out.println("Car Deleted");

	    } catch(Exception e) {
	        System.out.println(e);
	    } finally {
	        closeConnection();
	    }
	}
	
	//search
	public static Car searchCarById(int id) {
	    Car car = null;
	    String query = "select * from car where id=?";

	    try {
	        openConnection();
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, id);

	        resultSet = preparedStatement.executeQuery();

	        if(resultSet.next()) {   // ✅ only one record expected
	            car = new Car();

	            car.setId(resultSet.getInt(1));
	            car.setModel_name(resultSet.getString(2));
	            car.setColor(resultSet.getString(3));
	            car.setPrice(resultSet.getDouble(4));
	            car.setCompany_name(resultSet.getString(5));
	            car.setFuel_type(resultSet.getString(6));
	        }

	    } catch(SQLException e) {
	        System.out.println(e);
	    } finally {
	        closeConnection();
	    }

	    return car;
	}

}
