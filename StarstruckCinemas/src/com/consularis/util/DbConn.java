package com.consularis.util;

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
		}
		catch(NamingException ne) {
			ne.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
