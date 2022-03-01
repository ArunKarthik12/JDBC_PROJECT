package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	public static Connection getConnection() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/products","arun","Arun@123");
			if(con!=null) {
				return con;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}