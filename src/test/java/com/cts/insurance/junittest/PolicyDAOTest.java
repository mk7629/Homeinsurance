package com.cts.insurance.junittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.cts.insurance.dao.PolicyDAO;
import com.cts.insurance.model.Policy;

public class PolicyDAOTest {
	// The @Before method will run prior to each test method
	@Before
	public void setUp() throws Exception {
		System.out.println("Setting up test method @ " + LocalTime.now());
	}

	// The @After method will run after each test method
	@After
	public void tearDown() throws Exception {
		System.out.println("Tearing down test method @ " + LocalTime.now());
	}

	@Rule
	public TestName name = new TestName();

	// Declare Objects
	Policy p = new Policy();
	PolicyDAO pold = new PolicyDAO();

	List<Policy> policyList;

	// Test for checkEqualsCreatePolicy
	@Test
	public void checkEqualsCreatePolicy() throws ClassNotFoundException, SQLException, IOException, ParseException {

		// Setup Dates
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String EffectiveDate = "2019-03-19";
		String EndDate = "2020-03-19";
		java.util.Date fd = formatter.parse(EffectiveDate);
		java.util.Date fd1 = formatter.parse(EndDate);
		java.sql.Date sqlDate = new java.sql.Date(fd.getTime());
		java.sql.Date sqlDate1 = new java.sql.Date(fd1.getTime());

		p.setQuoteId(140);
		p.setUserId(14);
		p.setEffectiveDate(sqlDate);
		p.setEndDate(sqlDate1);
		p.setTerm(1);
		p.setPolicyStatus("active");

		pold.createPolicy(p);

		assertEquals(14, p.getUserId());
		assertEquals(sqlDate, p.getEffectiveDate());
		assertEquals(sqlDate1, p.getEndDate());
		assertEquals(1, p.getTerm());
		assertEquals("active", p.getPolicyStatus());

	}

	// Test for notNullGetAllPolicyByUserId
	@Test
	public void notNullGetAllPolicyByUserId() throws ClassNotFoundException, SQLException, IOException {

		policyList = pold.getAllPolicyByUserId(14);

		for (Policy p1 : policyList) {
			
			assertNotNull(p1.getPolicyId());
			assertNotNull(p1.getQuoteId());
			assertNotNull(p1.getUserId());
			assertNotNull(p1.getEffectiveDate());
			assertNotNull(p1.getEndDate());
			assertNotNull(p1.getTerm());
			assertNotNull(p1.getPolicyStatus());
		}

	}

	// Test for notNullUpdatePolicy
	@Test
	public void notNullUpdatePolicy() throws ClassNotFoundException, SQLException, IOException, ParseException {
		// Setup Dates
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String EndDate = "2020-03-19";
		java.util.Date fd1 = formatter.parse(EndDate);
		java.sql.Date sqlDate1 = new java.sql.Date(fd1.getTime());
		

		p.setPolicyId(2);
		p.setPolicyStatus("active");
		p.setEndDate(sqlDate1);
		
		pold.updatePolicy(p);

		assertNotNull(p.getQuoteId());
		assertNotNull(p.getUserId());
		assertNotNull(p.getPolicyStatus());

	}

}
