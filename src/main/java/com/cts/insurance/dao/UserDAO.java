package com.cts.insurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cts.insurance.model.User;


public class UserDAO {

	// ******registerUsers Method

	public int registerUser(User user) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// User u = null;

		// Assign insert statement string to variable
		String insertString = "insert into Users (user_name, password, admin_role) values (?,?,?)";
System.out.println(insertString);
		int ID = -1;
		String[] COL = { "user_id" };

		DbConnection oracle = new DbConnection();
		System.out.println("Conntected to DB. ");

		try {
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(insertString, COL);

			// get parameters
			// stmt.setString(1, u2);
			// stmt.setInt(1, ID);
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getAdminRole());
			System.out.println(stmt);
			stmt.executeUpdate();
			System.out.println("Inserted User.");

			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				ID = rs.getInt(1);
				// stmt.setInt(1, rs.getInt(ID));
			}
			// System.out.println(ID);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return ID;
	} // End of registerUser() method

	// ****************getUserByName*****************
	public User getUserByName(String name) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User u = null;

		// Assign query string to variable
		String qString = "select * from Users where user_name = ?";

		// Create DBConnection class instance
		DbConnection oracle = new DbConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters
			stmt.setString(1, name);

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();
			// Retrieve ResultSet and assign to new User
			if (rs.next()) {
				u = new User();
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setAdminRole(rs.getString(4));

			}

//			while (rs.next()) {
//				System.out.printf("%d | ", rs.getInt(1));
//				System.out.printf("%s | ", rs.getString(2));
//				System.out.println(rs.getString(3));
//			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println(e.getStackTrace());
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return u;
	} // End of getUserByName() method

	// ****************getAllUsers() method*****************

	public List<User> getAllUsers() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		User u = null;
		List<User> userList = null;

		// Assign query string to a variable
		String qString = "select * from users";

		// Create MySqlConnection class instance
		DbConnection oracle = new DbConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database
			conn = oracle.getConnection();
			// If the connection fails the application won't make it to this point
			System.out.println("Connected to database.");
			// Create Statement instance/object
			stmt = conn.createStatement();

			// Run query and assign to the ResultSet instance
			rs = stmt.executeQuery(qString);
			// Create list to hold User objects
			userList = new ArrayList<User>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new user
				u = new User();
				// Assign columns/fields to related fields in the User object
				// 1,2 and 3 represent column numbers/positions
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setAdminRole(rs.getString(4));

				// Add the user to the list
				userList.add(u);
				// Repeat until rs.next() returns false (i.e., end of ResultSet)
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return userList;
	} // End of getAllUsers method

	// Testing DB
//	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
//
//		User u = new User();
//		UserDAO ud = new UserDAO();
//		// System.out.println(u.getUserName());
//		// Calling registerUser
//		u.setUserName("test6");
//		u.setPassword("test12344");
//		u.setAdminRole("user");
//		// ud.registerUser(u);
//
//		System.out.println("Printing .");
//		System.out.println(ud.registerUser(u));
//		System.out.println("registerUser success.");
//
//		// Calling getUserByName
//		u = ud.getUserByName("Mona1");
//
//		System.out.println(u.getUserId());
//		System.out.println("getUserByName success.");
//	}
}
