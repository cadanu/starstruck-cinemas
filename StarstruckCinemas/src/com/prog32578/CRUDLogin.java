package com.prog32578;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDLogin {
	
	// validate login
	public static boolean getLogin(String email, String pass) throws SQLException, ClassNotFoundException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean stat = false;
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			if(conn == null || conn.isClosed()) {
				conn = DbConn.getConnection();
				System.out.println("Connection On.");
			}
			
			String sql = "select email, pass from users where email=? and pass=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			
			rs = ps.executeQuery();
			
			System.out.println("Executed.");
			stat = rs.next();
			
		}catch(SQLException se) {
			se.printStackTrace();
			System.out.print("Exception.");
		}finally {
			//conn.close();
			System.out.println("Closed");
		}
		return stat;
	}
}
