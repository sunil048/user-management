package com.repository.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	protected  Connection connection;
	public  void start() {
		try {
			Class.forName("org.postgresql.Driver");
			 connection = DriverManager.getConnection("jdbc:postgresql://192.168.92.137:5432/user-management","postgres","admin1");
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void stop() {
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
