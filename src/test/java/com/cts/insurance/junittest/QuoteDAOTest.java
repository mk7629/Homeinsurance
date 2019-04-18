package com.cts.insurance.junittest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.cts.insurance.dao.QuoteDAO;
import com.cts.insurance.model.Quote;


public class QuoteDAOTest {

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
	Quote q = new Quote();
	QuoteDAO qd = new QuoteDAO();
	List<Quote> quoteList;

	// Test checkEqualsCreateQuote
	@Test
	public void checkEqualsCreateQuote() throws ClassNotFoundException, SQLException, IOException {

		q.setLocationId(239);
		q.setMonthlyPremium(50.1f);
		q.setDwellingCoverage(2091.0f);
		q.setDetatchedStructures(100.0f);
		q.setPersonalProperty(123.0f);
		q.setAddLivingExp(10002.0f);
		q.setMedicalExpenses(100.1f);
		q.setDeductible(50.5f);

		qd.createQuote(q);

		assertEquals(50.1, q.getMonthlyPremium(), 0.0002);
		assertEquals(2091.0, q.getDwellingCoverage(), 0.0002);
		assertEquals(100.0, q.getDetatchedStructures(), 0.0002);
		assertEquals(123.0, q.getPersonalProperty(), 0.0002);
		assertEquals(10002.0, q.getAddLivingExp(), 0.0002);
		assertEquals(100.1, q.getMedicalExpenses(), 0.0002);
		assertEquals(50.5, q.getDeductible(), 0.0002);
	}

	// Test for checkEqualsgetQuoteByQuoteId
	@Test
	public void checkEqualsGetQuoteByQuoteId() throws ClassNotFoundException, SQLException, IOException {

		q = qd.getQuoteByQuoteId(140);


		assertEquals(50.1, q.getMonthlyPremium(), 0.0002);
		assertEquals(2091.0, q.getDwellingCoverage(), 0.0002);
		assertEquals(100.0, q.getDetatchedStructures(), 0.0002);
		assertEquals(123.0, q.getPersonalProperty(), 0.0002);
		assertEquals(10002.0, q.getAddLivingExp(), 0.0002);
		assertEquals(100.1, q.getMedicalExpenses(), 0.0002);
		assertEquals(50.5, q.getDeductible(), 0.0002);
	}

	// Test for checkEqualsGetQuoteByUserId 	
	
	@Test
	public void checkEqualsGetQuoteByUserId() throws ClassNotFoundException, SQLException, IOException {

		quoteList = qd.getQuoteByUserId(12);
		
		for (Quote q1 : quoteList) {
			System.out.printf("Quote ID: %d | Location ID: %d\n", q1.getQuoteId(), q1.getLocationId());
			assertEquals(1, q1.getQuoteId());
			assertEquals(6, q1.getLocationId());
		}
	}
}
