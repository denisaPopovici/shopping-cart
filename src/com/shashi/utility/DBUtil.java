package com.shashi.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
	private static Connection conn;

	public static Connection provideConnection() {

		try {
			if (conn == null || conn.isClosed()) {
				ResourceBundle rb = ResourceBundle.getBundle("application");
				String connectionString = rb.getString("db.connectionString");
				String driverName = rb.getString("db.driverName");
				String username = rb.getString("db.username");
				String password = rb.getString("db.password");
				findClass(driverName);
				conn = DriverManager.getConnection(connectionString, username, password);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	private static void findClass(String driverName) {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void closeConnection(Connection con) {
	}

	public static void closeConnection(ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeConnection(PreparedStatement ps) {
		try {
			if (ps != null && !ps.isClosed()) {
					ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
