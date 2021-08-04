package com.revature.bankingapiUTIL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClientJDBCConnection {
	private static Connection conn = null;

	public static Connection getConnection() {

		/*
		 * to establish a connection we need 3 credentials url (endpoints), username,
		 * password
		 */

		if (conn == null) {
			// establish connection
			String endpoint = "jacob-database.czxfkjoavfc1.us-east-2.rds.amazonaws.com";
			// URL FORMAT(postgres jdbc):
			// jdbc:postgresql://[endpoint]/[database]
			String url = "jdbc:postgresql://" + endpoint + "/postgres";
			String username = "jacob";
			String password = "password";

			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	/*
	 * This is for testing purposes only!!! No need to actually use jdbc
	 */
	public static void main(String[] args) {
		Connection conn1 = getConnection();
		Connection conn2 = getConnection();
		Connection conn3 = getConnection();

		System.out.println(conn1);
		System.out.println(conn2);
		System.out.println(conn3);

	}

}
