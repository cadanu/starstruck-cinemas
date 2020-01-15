package com.prog32578;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD {
	
	//private static Connection conn = null;
	
//	// get count of column in table (for..)
//	public static String getCount(String column, String table) throws SQLException, ClassNotFoundException {
//		
//		
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		String count = null;
//		
//		try {
//			//Class.forName("com.mysql.cj.jdbc.Driver");
//			if(conn == null || conn.isClosed()) {
//				conn = DbConn.getConnection();
//				System.out.println("Connection On inside getCount.");
//			}
//			
//			String sql = "select COUNT(" + column + ") from " + table + ";";
//			ps = conn.prepareStatement(sql);
//			
//			rs = ps.executeQuery();
//			
//			System.out.println("Executed inside getCount.");
//			System.out.println(rs.toString());
//			while(rs.next()) {
//				count = rs.getNString(1);
//			}
//			
//			
//			
//		}
//		catch(SQLException se) {
//			se.getMessage();
//			System.out.println("Exception inside getCount.");
//		}
//		catch(NullPointerException npe) {
//			count = String.valueOf(0);
//			System.out.println("Null Exception inside getCount.");
//			return count;
//		}
//		finally {
//			//conn.close();
//			System.out.println("Closed inside getCount.");
//		}
//		return count;
//	}
	
	
	// create Users (for sign up)
	public static void createUser(User user) throws SQLException, ClassNotFoundException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			//Class.forName("com.mysql.jc.jdbc.Driver");//			
			if(conn == null || conn.isClosed()) {
				conn = DbConn.getConnection();
				System.out.println("Connection On.");
			}
			
			// transactions reference - https://stackoverflow.com/questions/5178697/mysql-insert-into-multiple-tables-database-normalization
			String sql = "insert into users(firstName, lastName, email, pass) values(?,?,?,?);";
			
			ps = conn.prepareStatement(sql);			
			
			//ps.setString(1, user.getIdAcc());
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());			
			ps.setString(3, user.getEmail());
			ps.setString(4,  user.getPassword());			
			ps.executeUpdate();
			
			System.out.println("Executed.");
		}catch(SQLException se) {
			se.printStackTrace();
			System.out.println("Exception");
		}finally {
			//conn.close();
			System.out.println("Closed");
		}
	}

	
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
	
	// update number of seats sold per movie in database
	public static void setSeatsSold(Ticket tic) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			if(conn == null || conn.isClosed()) {
				conn = DbConn.getConnection();
			}
		
			String sql = "update cinema set tickets_sold=tickets_sold + ? where current_feature like ?";
			ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, tic.getAmount());
			ps.setString(1, tic.getFeatName());
			ps.executeUpdate();
			
		}
		catch (SQLException se) {
			se.printStackTrace();
		}		
	}
	
	// get the number of seats sold per movie
	public static int getSeatsSold(String featName) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int seats = 0;
		
		try {
			if(conn == null || conn.isClosed()) {
				conn = DbConn.getConnection();
			}
			
			String sql = "select tickets_sold from cinema where current_feature like ?;";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, featName);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				seats = rs.getInt("tickets_sold");
			}
			else seats = 0;
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
//			catch(ClassNotFoundException cnfe) {
//			cnfe.printStackTrace();
//		}	
		return seats;
	}
	
	
	// update tickets_sold (for calculate remaining seats)
	public static void updateTickets(Ticket tic) throws SQLException, ClassNotFoundException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		if(conn == null || conn.isClosed()) {
			conn = DbConn.getConnection();
		}
		
		String sql = "update cinema set tickets_sold = ? where current_feature like ?";
		ps = conn.prepareStatement(sql);
		
		ps.setInt(1, Integer.parseInt(tic.getSeatsSold()));
		ps.setString(2, tic.getFeatName());
		
	}
	
	
	
	
//	// update
//	public static void update(User user) throws SQLException, ClassNotFoundException {
//		Connection conn = null;
//		PreparedStatement ps = null;
//		
//		try {
//			//Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = null;
//			
//		}
//		catch(Exception e) {
//			e.getMessage();
//		}
//	}
//	
//	// delete
//	public static void delete(User user) throws SQLException, ClassNotFoundException {
//		Connection conn = null;
//		PreparedStatement ps = null;
//		
//		try {
//			//Class.forName("com.mysql.cj.jdbc.Driver");
//		}
//		catch(Exception e) {
//			e.getMessage();
//		}
//	}
}
