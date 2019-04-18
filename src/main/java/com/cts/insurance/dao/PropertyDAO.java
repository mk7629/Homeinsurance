package com.cts.insurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.insurance.model.Property;

public class PropertyDAO {
	// ******createProperty Method

	public Property createProperty(Property property) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Property p = null;

		// Assign insert statement string to variable
		String insertString = "insert into Properties (LOCATION_ID,\r\n" + "MARKET_VALUE,\r\n" + "YEAR_BUILT,\r\n"
				+ "SQUARE_FOOTAGE,\r\n" + "DWELLING_TYPE,\r\n" + "ROOF_MATERIAL,\r\n" + "GARAGE_TYPE,\r\n"
				+ "FULL_BATHS,\r\n" + "HALF_BATHS,\r\n" + "POOL) values (?,?,?,?,?,?,?,?,?,?)";

		DbConnection oracle = new DbConnection();

		try {
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(insertString);

			// get parameters
			stmt.setInt(1, property.getLocationId());
			stmt.setFloat(2, property.getMarketValue());
			stmt.setInt(3, property.getYearBuilt());
			stmt.setInt(4, property.getSquareFootage());
			stmt.setString(5, property.getDwellingType());
			stmt.setString(6, property.getRoofMaterial());
			stmt.setString(7, property.getGarageType());
			stmt.setInt(8, property.getFullBaths());
			stmt.setInt(9, property.getHalfBaths());
			stmt.setInt(10, property.getPool());

			stmt.executeQuery();
			//System.out.println("Executed.");

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

		return p;
	} // End of createProperty Method()

	// ****************getAllPropertyByLocationId *****************
	public Property getAllPropertyByLocationId(int locationId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Property p = null;

		// Assign query string to variable
		String qString = "select * from Properties where location_id = ?";

		// Create DBConnection class instance
		DbConnection oracle = new DbConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters
			stmt.setInt(1, locationId);
			
			// Run query and assign to ResultSet
			rs = stmt.executeQuery();
			
			// Retrieve ResultSet and assign to new Property

			if (rs.next()) {

				// Assign columns/fields to related fields in the object
				// 1,2 and 3 represent column numbers/positions
				p = new Property();
				
				p.setLocationId(rs.getInt(1));
				p.setMarketValue(rs.getFloat(2));
				p.setYearBuilt(rs.getInt(3));
				p.setSquareFootage(rs.getInt(4));
				p.setDwellingType(rs.getString(5));
				p.setRoofMaterial(rs.getString(6));
				p.setGarageType(rs.getString(7));
				p.setFullBaths(rs.getInt(8));
				p.setHalfBaths(rs.getInt(9));
				p.setPool(rs.getInt(10));

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
		return p;
	} // End of getAllPropertyByLocationId() method

	//Testing DB
/*	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

		Property p = new Property();
		PropertyDAO pd = new PropertyDAO();

		//Calling createProperty
		p.setLocationId(6);
		p.setMarketValue(2000.11f);
		p.setYearBuilt(2016);
		p.setSquareFootage(2000);
		p.setDwellingType("test");
		p.setRoofMaterial("1.5 Story");
		p.setGarageType("1213fsdf");
		p.setFullBaths(3);
		p.setHalfBaths(1);
		p.setPool(true);

		pd.createProperty(p);
		System.out.println("Printing .");
		System.out.println(p.getLocationId());
		System.out.println("createProperty success.");
		
		//Calling getAllPropertyByLocationId
		p = pd.getAllPropertyByLocationId(5);
		
		System.out.println("YearBuilt is " + p.getYearBuilt());
		System.out.println("getAllProperty success.");

	}*/
}
