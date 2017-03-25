package com.adb.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthenticationService {

	public int isValid(String logonId, String password) {

		Connection connect = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/addrbook?" + "user=root&password=root");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();

			// Result set get the result of the SQL query
			String sql = "select * from addrbook.users where logon_id='" + logonId + "'" + " and password='" + password
					+ "'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int userId = resultSet.getInt("id");
				String logon_id = resultSet.getString("logon_id");
				String password_db = resultSet.getString("password");
				System.out.println("Row:" + userId + ", logon_id=" + logon_id + ", Password=" + password_db);
				return userId;
			}

			return -1;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return -1;
	}
}
