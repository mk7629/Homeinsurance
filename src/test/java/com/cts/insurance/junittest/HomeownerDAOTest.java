package com.cts.insurance.junittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.cts.insurance.dao.HomeownerDAO;
import com.cts.insurance.model.Homeowner;

public class HomeownerDAOTest {
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
	Homeowner h = new Homeowner();
	HomeownerDAO hd = new HomeownerDAO();

	// Test for checkEqualsCreateHomeowner
	@Test
	public void checkEqualsCreateHomeowner() throws ClassNotFoundException, SQLException, IOException, ParseException {

		// Setup Dates
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dob = "2016-09-09";
		java.util.Date fd = formatter.parse(dob);
		java.sql.Date sqlDate = new java.sql.Date(fd.getTime());

		h.setUserId(15);
		h.setFirstName("Mona");
		h.setLastName("Kang");
		h.setDob(sqlDate);
		h.setRetiredStatus(1);
		h.setSsn("123456789");
		h.setEmail("ka.mona212@test.com");

		hd.createHomeowner(h);

		assertEquals(15, h.getUserId());
		assertEquals("Mona", h.getFirstName());
		assertEquals("Kang", h.getLastName());
		assertEquals(sqlDate, h.getDob());
		assertEquals(true, h.getRetiredStatus());
		assertEquals("123456789", h.getSsn());
		assertEquals("ka.mona212@test.com", h.getEmail());

	}

	// Test for notNullGetAllHomeownerByUserId
	@Test
	public void notNullGetAllHomeownerByUserId() throws ClassNotFoundException, SQLException, IOException {

		h = hd.getAllHomeownerByUserId(12);

		assertNotNull(h.getUserId());
		assertNotNull(h.getFirstName());
		assertNotNull(h.getLastName());
		assertNotNull(h.getDob());
		assertNotNull(h.getRetiredStatus());
		assertNotNull(h.getSsn());
		assertNotNull(h.getEmail());

	}

}
