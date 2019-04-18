package com.cts.insurance.junittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.cts.insurance.dao.LocationDAO;
import com.cts.insurance.model.Location;

public class LocationDAOTest {
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
	Location l = new Location();
	LocationDAO ld = new LocationDAO();

	List<Location> locationList;

	// Test for checkEqualsCreateLocation
	@Test
	public void checkEqualsCreateLocation() throws ClassNotFoundException, SQLException, IOException {

		l.setUserId(14);
		l.setResidenceType("Rental5");
		l.setAddressLine1("9982");
		l.setAddressLine2("");
		l.setCity("Denton");
		l.setLocationState("Texas");
		l.setZipCode("72076");
		l.setResidenceUse("2");

		ld.createLocation(l);

		assertEquals(14, l.getUserId());
		assertEquals("Rental5", l.getResidenceType());
		assertEquals("9982", l.getAddressLine1());
		assertEquals("", l.getAddressLine2());
		assertEquals("Denton", l.getCity());
		assertEquals("Texas", l.getLocationState());
		assertEquals("72076", l.getZipCode());
		assertEquals("2", l.getResidenceUse());

	}

	// Test for notNullCreateLocation
	@Test
	public void notNullCreateLocation() throws ClassNotFoundException, SQLException, IOException {

		l.setUserId(14);
		l.setResidenceType("Rental5");
		l.setAddressLine1("9982");
		l.setAddressLine2("");
		l.setCity("Denton");
		l.setLocationState("Texas");
		l.setZipCode("72076");
		l.setResidenceUse("2");

		ld.createLocation(l);

		assertNotNull(l.getUserId());
		assertNotNull(l.getResidenceType());
		assertNotNull(l.getAddressLine1());
		assertNotNull(l.getAddressLine2());
		assertNotNull(l.getCity());
		assertNotNull(l.getLocationState());
		assertNotNull(l.getZipCode());
		assertNotNull(l.getResidenceUse());

	}

	// Test for notNullGetAllLocationByUserId
	@Test
	public void notNullGetAllLocationByUserId() throws ClassNotFoundException, SQLException, IOException {

		locationList = ld.getAllLocationByUserId(14);
		for (Location l1 : locationList) {
			assertNotNull(l1.getUserId());
			assertNotNull(l1.getResidenceType());
			assertNotNull(l1.getAddressLine1());
			assertNotNull(l1.getCity());
			assertNotNull(l1.getLocationState());
			assertNotNull(l1.getZipCode());
			assertNotNull(l1.getResidenceUse());
		}

	}

}
