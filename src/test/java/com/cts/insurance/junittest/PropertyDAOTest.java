package com.cts.insurance.junittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.cts.insurance.dao.PropertyDAO;
import com.cts.insurance.model.Property;

public class PropertyDAOTest {
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
	Property p = new Property();
	PropertyDAO pd = new PropertyDAO();

	// Test for checkEqualsCreateProperty
	@Test
	public void checkEqualsCreateProperty() throws ClassNotFoundException, SQLException, IOException {

		p.setLocationId(234);
		p.setMarketValue(2000.11f);
		p.setYearBuilt(2016);
		p.setSquareFootage(2000);
		p.setDwellingType("1.5 Story");
		p.setRoofMaterial("Concrete");
		p.setGarageType("Attached");
		p.setFullBaths(3);
		p.setHalfBaths(1);
		p.setPool(2);

		pd.createProperty(p);

		assertEquals(2000.11, p.getMarketValue(), 0.0002);
		assertEquals(2016, p.getYearBuilt());
		assertEquals(2000, p.getSquareFootage());
		assertEquals("1.5 Story", p.getDwellingType());
		assertEquals("Concrete", p.getRoofMaterial());
		assertEquals("Attached", p.getGarageType());
		assertEquals(3, p.getFullBaths());
		assertEquals(1, p.getHalfBaths());
		assertEquals(2, p.getPool());
	}

	// Test for notNullCreateProperty
	@Test
	public void notNullCreateProperty() throws ClassNotFoundException, SQLException, IOException {

		p.setLocationId(4);
		p.setMarketValue(2000.11f);
		p.setYearBuilt(2016);
		p.setSquareFootage(2000);
		p.setDwellingType("1.5 Story");
		p.setRoofMaterial("Concrete");
		p.setGarageType("Attached");
		p.setFullBaths(3);
		p.setHalfBaths(1);
		p.setPool(2);

		pd.createProperty(p);

		assertNotNull(p.getLocationId());
		assertNotNull(p.getMarketValue());
		assertNotNull(p.getYearBuilt());
		assertNotNull(p.getSquareFootage());
		assertNotNull(p.getDwellingType());
		assertNotNull(p.getRoofMaterial());
		assertNotNull(p.getGarageType());
		assertNotNull(p.getFullBaths());
		assertNotNull(p.getHalfBaths());
		assertNotNull(p.getPool());
	}

	// Test for checkEqualsGetAllProperty
	@Test
	public void checkEqualsGetAllPropertyByLocationId() throws ClassNotFoundException, SQLException, IOException {

		p = pd.getAllPropertyByLocationId(233);

		assertEquals(150000.0, p.getMarketValue(), 0.0002);
		assertEquals(2016, p.getYearBuilt());
		assertEquals(2000, p.getSquareFootage());
		assertEquals("2", p.getDwellingType());
		assertEquals("Concrete", p.getRoofMaterial());
		assertEquals("Attached", p.getGarageType());
		assertEquals(3, p.getFullBaths());
		assertEquals(1, p.getHalfBaths());
		assertEquals(2, p.getPool());

	}

	// Test for notNullGetUserByName
	@Test
	public void notNullGetAllPropertyByLocationId() throws ClassNotFoundException, SQLException, IOException {

		p = pd.getAllPropertyByLocationId(233);

		// Checking userId

		assertNotNull(p.getMarketValue());
		assertNotNull(p.getYearBuilt());
		assertNotNull(p.getSquareFootage());
		assertNotNull(p.getDwellingType());
		assertNotNull(p.getRoofMaterial());
		assertNotNull(p.getGarageType());
		assertNotNull(p.getFullBaths());
		assertNotNull(p.getHalfBaths());
		assertNotNull(p.getPool());

	}
}
