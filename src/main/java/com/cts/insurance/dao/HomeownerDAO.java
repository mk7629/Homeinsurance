package com.cts.insurance.dao;

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.cts.insurance.model.Homeowner;

public class HomeownerDAO {

	// ******createHomeowner Method

	public Homeowner createHomeowner(Homeowner homeowner) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Homeowner h = null;

		// Assign insert statement string to variable
		String insertString = "insert into Homeowners (USER_ID, FIRST_NAME, LAST_NAME, DOB, RETIRED_STATUS,\r\n"
				+ "SSN, EMAIL) values (?,?,?,?,?,?,?)";

		DbConnection oracle = new DbConnection();

		try {
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(insertString);

			// get parameters
			stmt.setInt(1, homeowner.getUserId());
//			System.out.println("1st" + homeowner.getUserId());
			stmt.setString(2, homeowner.getFirstName());
//			System.out.println("2nd" + homeowner.getFirstName());
			stmt.setString(3, homeowner.getLastName());
//			System.out.println("3rd" + homeowner.getLastName());
			stmt.setDate(4, homeowner.getDob());
//			System.out.println("4th" + homeowner.getDob());
			stmt.setInt(5, homeowner.getRetiredStatus());
//			System.out.println("5th" + homeowner.getRetiredStatus());
			stmt.setString(6, homeowner.getSsn());
//			System.out.println("6th" + homeowner.getSsn());
			stmt.setString(7, homeowner.getEmail());
//			System.out.println("7th" + homeowner.getEmail());
//			System.out.println(insertString);
			stmt.executeQuery();
			// System.out.println("Executed Insert to Homeowners.");

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

		return h;
	} // End of createHomeowner Method()

	// ****************getAllHomeownerByUserId *****************
	public Homeowner getAllHomeownerByUserId(int userId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Homeowner h = null;

		// Assign query string to variable
		String qString = "select * from Homeowners where user_id = ? ";

		// Create DBConnection class instance
		DbConnection oracle = new DbConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters
			stmt.setInt(1, userId);

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();
			//System.out.println("Executed homeowner.");

			if (rs.next()) {

				// Assign columns/fields to related fields in the object
				// 1,2 and 3 represent column numbers/positions
				h = new Homeowner();

				h.setUserId(rs.getInt(1));
				h.setFirstName(rs.getString(2));
				h.setLastName(rs.getString(3));
				h.setDob(rs.getDate(4));
				h.setRetiredStatus(rs.getInt(5));
				h.setSsn(rs.getString(6));
				h.setEmail(rs.getString(7));

				// Repeat until rs.next() returns false (i.e., end of ResultSet)
			}

			while (rs.next()) {
				System.out.printf("%d | ", rs.getInt(1));
				System.out.printf("%s | ", rs.getString(2));
				System.out.println(rs.getString(3));
			}
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
		return h;
	} // End of getAllHomeownerByUserId() method

	//Testing DB
/*	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, ParseException {

		Homeowner h = new Homeowner();
		HomeownerDAO hd = new HomeownerDAO();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dob = "2016-09-09";
		java.util.Date fd = formatter.parse(dob);
		java.sql.Date sqlDate = new java.sql.Date(fd.getTime());

		// Calling createHomeowner
		h.setUserId(15);
		h.setFirstName("Mona");
		h.setLastName("Kang");
		h.setDob(sqlDate);
		h.setRetiredStatus(true);
		h.setSsn("123456789");
		h.setEmail("ka.mona212@test.com");

		System.out.println("Printing .");
		//System.out.println(hd.createHomeowner(h));
		System.out.println("createHomeowner success.");

		// Calling getAllHomeownerByUserId
		h = hd.getAllHomeownerByUserId(12);

		System.out.println("Email is " + h.getEmail());
		System.out.println("DOB is " + h.getDob());
		System.out.println("getAllHomeownerByUserId success.");

	}*/
}
