package com.prog32578;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbConn {
	
	static Connection connection = null;
	
	static {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/starstruckcinemas");
			connection = ds.getConnection();
			System.out.println("dbconn first out: " + connection.toString());
			System.out.println("metadata" + connection.getMetaData());
		}
		catch(NamingException ne) {
			ne.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	static {
		System.out.println("hello");
	}
	
	public static Connection getConnection() {
		System.out.println("dbconn second out: " + connection.toString());
		return connection;
	}
}