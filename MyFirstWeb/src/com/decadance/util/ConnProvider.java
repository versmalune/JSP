package com.decadance.util;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnProvider {
	
	public static Connection getConnection() {
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/practice";
		String uid = "root";
		String upw = "decadance99";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, uid, upw);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return conn;
	}
}