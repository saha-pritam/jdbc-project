package org.pritam.jdbc_project.ConnectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static Connection connection;

	public static Connection getConnection() {
		if(connection==null) {
			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			} catch (SQLException e) {
				e.printStackTrace();
				System.exit(0);
			}
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb", "root", "9er$Y%F49yD4");
			} catch (SQLException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
		return connection;
	}
}
