package com.cdw.dao;

import java.io.FileInputStream;
// import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public abstract class AbstractDAO {
	protected Connection conn = null;
	protected PreparedStatement state = null;
	protected ResultSet result = null;
	
	protected void establishConnection() {
		try {
			// Making a new Properties object
			Properties prop = new Properties();
			
			// Derives where the db.properties file exists
			FileInputStream fs = new FileInputStream(
						this.getClass().getClassLoader()
						.getResource("com/cdw/resources/db.properties")
						.getFile()
					);
			
			// Loads the file from the input stream into the prop object
			prop.load(fs);
			
			// Initializing variables to store property keys
			String driver 	= prop.getProperty("driver");
			String url 		= prop.getProperty("url");
			String user 	= prop.getProperty("user");
			String password = prop.getProperty("password");
			
			// Knows what type of driver to load
			Class.forName(driver);
			
			// Derives connection from DriverManager's loading of the driver
			conn = DriverManager.getConnection(url, user, password);
		}
		catch (Exception e) { e.printStackTrace(); }
	}
	
	protected void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}