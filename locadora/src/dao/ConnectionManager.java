package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static Connection connection;
	
	private ConnectionManager() {
		
	}
	
	public static Connection getConnection() {
		if(connection == null) {
			try {
				String DATABASE = "jdbc:sqlite:/home/ownard/Documentos/aula_db";
				connection = DriverManager.getConnection(DATABASE);
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		return connection;
	}
}
