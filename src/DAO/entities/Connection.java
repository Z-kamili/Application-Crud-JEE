package DAO.entities;

import java.sql.DriverManager;

public class Connection {
	
	private static java.sql.Connection connection;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	
		
		
	}

	public static java.sql.Connection getConnection() {
		return connection;
	}

	public static void setConnection(java.sql.Connection connection) {
		Connection.connection = connection;
	}
	
	

}
