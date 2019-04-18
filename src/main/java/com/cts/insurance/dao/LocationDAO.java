package com.cts.insurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.insurance.model.Location;

public class LocationDAO {
	// ******createLocation Method

	public int createLocation(Location location) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Location l = null;

		// Assign insert statement string to variable
		String insertString = "insert into Locations (USER_ID,\r\n" + "RESIDENCE_TYPE,\r\n" + "ADDRESS_LINE_1,\r\n"
				+ "ADDRESS_LINE_2,\r\n" + "CITY,\r\n" + "LOCATION_STATE,\r\n" + "ZIP_CODE,\r\n"
				+ "RESIDENCE_USE) values (?,?,?,?,?,?,?,?)";
		int ID = -1;
		String[] COL = { "location_id" };
		
		DbConnection oracle = new DbConnection();

		try {
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(insertString, COL);

			// get parameters
			stmt.setInt(1, location.getUserId());
			// System.out.println("2nd");
			stmt.setString(2, location.getResidenceType());
			// System.out.println("3rd");
			stmt.setString(3, location.getAddressLine1());
			// System.out.println("4th");
			stmt.setString(4, location.getAddressLine2());
			// System.out.println("5th");
			stmt.setString(5, location.getCity());
			// System.out.println("6th");
			stmt.setString(6, location.getLocationState());
			// System.out.println("7th");
			stmt.setString(7, location.getZipCode());
			// System.out.println("8th");
			stmt.setString(8, location.getResidenceUse());
			// System.out.println("9th");

			stmt.executeUpdate();
			// System.out.println("Excuted.");
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				ID = rs.getInt(1);
				//stmt.setInt(1, rs.getInt(ID));
			}

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
	} // End of createLocation Method()

	// ****************getAllLocationByUserId *****************
	public List<Location> getAllLocationByUserId(int userId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Location l = null;
		List<Location> locationList = null;

		// Assign query string to variable
		String qString = "select * from Locations where user_id = ?";

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
			// Retrieve ResultSet and assign
			locationList = new ArrayList<Location>();

			while (rs.next()) {

				// Assign columns/fields to related fields in the object

				l = new Location();
				l.setLocationId(rs.getInt(1));
				l.setUserId(rs.getInt(2));

				l.setResidenceType(rs.getString(3));

				l.setAddressLine1(rs.getString(4));
				l.setAddressLine2(rs.getString(5));
				l.setCity(rs.getString(6));
				l.setLocationState(rs.getString(7));
				l.setZipCode(rs.getString(8));
				l.setResidenceUse(rs.getString(9));
				// System.out.println(l.getAddressLine1());
				// Add the location to the list
				locationList.add(l);

				// Repeat until rs.next() returns false (i.e., end of ResultSet)
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
		return locationList;
	} // End of getAllLocationByUserId() method

	// Testing DB
/*	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

		Location l = new Location();
		LocationDAO ld = new LocationDAO();

		List<Location> locationList;

		// Calling createLocation

		l.setUserId(14);
		l.setResidenceType("Rental5");
		l.setAddressLine1("9982");
		l.setAddressLine2("");
		l.setCity("Denton");
		l.setLocationState("Texas");
		l.setZipCode("72076");
		l.setResidenceUse("2");

		System.out.println("Printing .");
		System.out.println(ld.createLocation(l));
		System.out.println("createLocation success.");

		// Calling getAllLocationByUserId
		locationList = ld.getAllLocationByUserId(14);
		for (Location l1 : locationList) {
			System.out.printf("User ID %d: %s\n", l1.getUserId(), l1.getResidenceType());
		}
		System.out.println("getAllLocationByUserId Success. ");

	}*/
}
