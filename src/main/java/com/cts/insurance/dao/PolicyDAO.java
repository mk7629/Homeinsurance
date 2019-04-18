package com.cts.insurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import org.springframework.util.SystemPropertyUtils;

import com.cts.insurance.model.Policy;

public class PolicyDAO {
	// ******createPolicy Method

	public int createPolicy(Policy policy) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Policy pol = null;

		// Assign insert statement string to variable
		String insertString = "insert into Policies (QUOTE_ID,\r\n" + "USER_ID,\r\n" + "EFFECTIVE_DATE,\r\n"
				+ "END_DATE,\r\n" + "TERM,\r\n" + "POLICY_STATUS) values (?,?,?,?,?,?)";

		int ID = -1;
		String[] COL = { "policy_id" };
		DbConnection oracle = new DbConnection();

		try {
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(insertString, COL);

			// Get the system date and time.
//			java.util.Date utilDate = new Date();
//			// Convert it to java.sql.Date
//			java.sql.Date date = new java.sql.Date(utilDate.getTime());

			// get parameters

			stmt.setInt(1, policy.getQuoteId());
			stmt.setInt(2, policy.getUserId());
			stmt.setDate(3, policy.getEffectiveDate());
			stmt.setDate(4, policy.getEndDate());
			stmt.setInt(5, policy.getTerm());
			stmt.setString(6, policy.getPolicyStatus());

			stmt.executeQuery();
			//System.out.println("Executed Policy.");
			
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				ID = rs.getInt(1);
				// stmt.setInt(1, rs.getInt(ID));
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
	} // End of createPolicy Method()

	// ****************getAllPolicyByUserId *****************
	public List<Policy> getAllPolicyByUserId(int userId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Policy pol = null;
		List<Policy> policyList = null;

		// Assign query string to variable
		String qString = "select * from Policies where user_id = ?";

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
			//System.out.println("Executed AllPolicy.");

			// Retrieve ResultSet and assign
			policyList = new ArrayList<Policy>();

			while (rs.next()) {

				// Assign columns/fields to related fields in the object
				// 1,2 and 3 represent column numbers/positions
				pol = new Policy();
				pol.setPolicyId(rs.getInt(1));
				pol.setQuoteId(rs.getInt(2));
				pol.setUserId(rs.getInt(3));
				pol.setEffectiveDate(rs.getDate(4));
				pol.setEndDate(rs.getDate(5));
				pol.setTerm(rs.getInt(6));
				pol.setPolicyStatus(rs.getString(7));

				// Add the user to the list
				policyList.add(pol);
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
		return policyList;
	} // End of getAllPolicyByUserId() method

	// ****************updatePolicy() method*****************

	public Boolean updatePolicy(Policy policy) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables

		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign update string to variable
		String updateString = "Update Policies Set POLICY_STATUS = ?, END_DATE = ? Where POLICY_ID = ?";

		// Create MySqlConnection class instance
		DbConnection oracle = new DbConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters
			stmt.setString(1, policy.getPolicyStatus());
			stmt.setDate(2, policy.getEndDate());
			stmt.setInt(3, policy.getPolicyId());

			// Run query and assign to ResultSet
			updateResult = stmt.executeUpdate();
			//System.out.println("Updated.");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		if (updateResult > 0) {
			return true;
		}
		return false;
	} // End of updatePolicy() method

	//Testing DB
/*	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, ParseException {

		Policy p = new Policy();
		PolicyDAO pold = new PolicyDAO();

		List<Policy> policyList;
		// Setup Dates
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String EffectiveDate = "2019-03-19";
		String EndDate = "2020-03-19";
		java.util.Date fd = formatter.parse(EffectiveDate);
		java.util.Date fd1 = formatter.parse(EndDate);
		java.sql.Date sqlDate = new java.sql.Date(fd.getTime());
		java.sql.Date sqlDate1 = new java.sql.Date(fd1.getTime());

		// Calling createPolicy
		//Setup arguments
		p.setQuoteId(6);
		p.setUserId(14);
		p.setEffectiveDate(sqlDate);
		p.setEndDate(sqlDate1);
		p.setTerm(1);
		p.setPolicyStatus("active");


		System.out.println("Printing .");
		//System.out.println(pold.createPolicy(p));
		System.out.println("createPolicy success.");

		// Calling getAllPolicyByUserId
		policyList = pold.getAllPolicyByUserId(44);
		System.out.println(policyList.size());
		

		// System.out.println(pold.getAllPolicyByUserId(14));
		for (Policy p1 : policyList) {
			Date myDate = new Date();
			Date myDate1 = new Date();
			myDate = p1.getEffectiveDate();
			myDate1 = p1.getEndDate();
			System.out.printf("User ID %d: %s\n", p1.getUserId(), p1.getPolicyId());
			//System.out.printf("EffectiveDate %d: %s\n", new SimpleDateFormat("yyyy-MM-dd").format(myDate), new SimpleDateFormat("yyyy-MM-dd").format(myDate1));
		}
		System.out.println("getAllPolicyByUserId Success. ");

		//Calling updatePolicy
		//Setup arguments
		p.setPolicyStatus("active");
		p.setEndDate(sqlDate1);
		p.setPolicyId(2);

		//System.out.println(pold.updatePolicy(p));
		System.out.println("updatePolicy success.");

	}*/
}
