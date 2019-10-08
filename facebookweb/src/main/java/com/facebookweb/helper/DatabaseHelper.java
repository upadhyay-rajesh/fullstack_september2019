package com.facebookweb.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHelper {

	public static Connection createConnection(String a) {
		Connection con=null;
		if(a.equals("oracle")) {
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","rajesh");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(a.equals("mysql")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fullstack","root","rajesh");
				}
				catch(Exception e) {
					e.printStackTrace();
				}
		}
		return con;
	}

}
