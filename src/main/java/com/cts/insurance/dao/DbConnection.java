package com.cts.insurance.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	public Connection getConnection() throws ClassNotFoundException, IOException, SQLException {
		final Properties prop = new Properties();
		final InputStream inputStream = DbConnection.class.getClassLoader()
				.getResourceAsStream("properties/db.properties"); // prepare connection
		prop.load(inputStream); // passing connection string
		//System.out.println("Connectiong...");
		Class.forName(prop.getProperty("driver")); // getting JDBC property driver is like destination
		// Building connection
		final Connection connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password")); // connection string - url, username, password
				//System.out.println("Successfully Connected to DB");
		return connection;
	}
}
