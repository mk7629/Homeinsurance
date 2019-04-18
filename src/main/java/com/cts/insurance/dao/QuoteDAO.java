package com.cts.insurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.insurance.model.Quote;

public class QuoteDAO {

	// ******createQuote Method

	public int createQuote(Quote quote) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Quote q = null;

		// Assign insert statement string to variable
		String insertString = "insert into Quotes (LOCATION_ID,\r\n" + "MONTHLY_PREMIUM,\r\n" + "DWELLING_COVERAGE,\r\n"
				+ "DETATCHED_STRUCTURES,\r\n" + "PERSONAL_PROPERTY,\r\n" + "ADD_LIVING_EXP,\r\n"
				+ "MEDICAL_EXPENSES,\r\n" + "DEDUCTIBLE) values (?,?,?,?,?,?,?,?)";

		int ID = -1;
		String[] COL = { "quote_id" };
		
		DbConnection oracle = new DbConnection();

		try {
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(insertString, COL);

			// get parameters

			stmt.setInt(1, quote.getLocationId());
			// System.out.println("1st");
			stmt.setFloat(2, quote.getMonthlyPremium());
			// System.out.println("2nd");
			stmt.setFloat(3, quote.getDwellingCoverage());
			// System.out.println("3rd");
			stmt.setFloat(4, quote.getDetatchedStructures());
			// System.out.println("4th");
			stmt.setFloat(5, quote.getPersonalProperty());
			// System.out.println("5th");
			stmt.setFloat(6, quote.getAddLivingExp());
			// System.out.println("6th");
			stmt.setFloat(7, quote.getMedicalExpenses());
			// System.out.println("7th");
			stmt.setFloat(8, quote.getDeductible());
			// System.out.println("8th");

			stmt.executeQuery();
			//System.out.println("Executed. ");
			
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
	} // End of createQuote Method()

	// ****************getQuoteByQuoteId*****************
	public Quote getQuoteByQuoteId(int quoteId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Quote q = null;

		// Assign query string to variable
		String qString = "select * from Quotes where quote_id = ? ";

		// Create DBConnection class instance
		DbConnection oracle = new DbConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters
			stmt.setInt(1, quoteId);

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();
			// Retrieve ResultSet and assign

			while (rs.next()) {

				// Assign columns/fields to related fields in the object
				// 1,2 and 3 represent column numbers/positions

				q = new Quote();
				q.setQuoteId(rs.getInt(1));
				q.setLocationId(rs.getInt(2));
				q.setMonthlyPremium(rs.getFloat(3));
				q.setDwellingCoverage(rs.getFloat(4));
				q.setDetatchedStructures(rs.getFloat(5));
				q.setPersonalProperty(rs.getFloat(6));
				q.setAddLivingExp(rs.getFloat(7));
				q.setMedicalExpenses(rs.getFloat(8));
				q.setDeductible(rs.getFloat(9));

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
		return q;
	} // End of getQuoteByQuoteId() method

	// ****************getQuoteByUserId*****************
	public List<Quote> getQuoteByUserId(int userId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Quote q = null;
		List<Quote> quoteList = null;

		// Assign query string to variable
		String qString = "Select * From Quotes\r\n"
				+ "Inner Join Locations On Quotes.location_id = Locations.location_id\r\n"
				+ "Where Locations.user_id = ? ";

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
			// Retrieve ResultSet and assign to new Quote
			quoteList = new ArrayList<Quote>();

			while (rs.next()) {

				// Assign columns/fields to related fields in the object
				// 1,2 and 3 represent column numbers/positions
				q = new Quote();

				q.setQuoteId(rs.getInt(1));
				q.setLocationId(rs.getInt(2));
				q.setMonthlyPremium(rs.getFloat(3));
				q.setDwellingCoverage(rs.getFloat(4));
				q.setDetatchedStructures(rs.getFloat(5));
				q.setPersonalProperty(rs.getFloat(6));
				q.setAddLivingExp(rs.getFloat(7));
				q.setMedicalExpenses(rs.getFloat(8));
				q.setDeductible(rs.getFloat(9));

				// Add the user to the list
				quoteList.add(q);
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
		return quoteList;
	} // End of getQuoteByUserId() method

	//Testing DB
	/*public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

		Quote q = new Quote();
		QuoteDAO qd = new QuoteDAO();

		List<Quote> quoteList;

		// Calling createQuote
		q.setLocationId(5);
		q.setMonthlyPremium(50.1f);
		q.setDwellingCoverage(2091.0f);
		q.setDetatchedStructures(100.0f);
		q.setPersonalProperty(123.0f);
		q.setAddLivingExp(10002.0f);
		q.setMedicalExpenses(100.1f);
		q.setDeductible(50.5f);

		System.out.println("Printing .");
		System.out.println(qd.createQuote(q));
		System.out.println("createQuote success.");

		// Calling getQuoteByQuoteId
		q = qd.getQuoteByQuoteId(6);

		System.out.println("Monthly Premium is $"+q.getMonthlyPremium());
		System.out.println("getQuoteByQuoteId success.");

		// Calling getQuoteByUserId
		quoteList = qd.getQuoteByUserId(12);
		for (Quote q1 : quoteList) {
			System.out.printf("Quote ID: %d | Location ID: %d\n", q1.getQuoteId(), q1.getLocationId());
		}
		System.out.println("getQuoteByUserId Success. ");

	}*/

}
