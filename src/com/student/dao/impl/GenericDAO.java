package com.student.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class GenericDAO {
	
	public static final String driver="com.mysql.jdbc.Driver";
	public static final String connectionURL = "jdbc:mysql://localhost/database2"; 
	public static final String username="root";
	public static final String password="system";
	
	public static Connection getConnection(){
		Connection connection = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(connectionURL,username,password);
		} catch (Exception e) {
			System.err.println("Not able to build the connection");
			e.printStackTrace();
		}
				
		return connection;
	}
	
	public void closeConnection(Connection connection){
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("Not able to close the connection");
			e.printStackTrace();
		}
	}

}
