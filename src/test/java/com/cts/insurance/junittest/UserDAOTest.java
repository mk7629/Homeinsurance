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

import com.cts.insurance.dao.UserDAO;
import com.cts.insurance.model.User;

public class UserDAOTest {
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
	User u = new User();
	UserDAO ud = new UserDAO();

	// Test for checkEqualsRegisterUser 
	@Test
	public void checkEqualsRegisterUser() throws ClassNotFoundException, SQLException, IOException {

		u.setUserName("test21");
		u.setPassword("test1234");
		u.setAdminRole("user");
		ud.registerUser(u);

		assertEquals("test21", u.getUserName());
		assertEquals("test1234", u.getPassword());
		assertEquals("user", u.getAdminRole());
	}
	
	// Test for notNullRegisterUser
	@Test
	public void notNullRegisterUser() throws ClassNotFoundException, SQLException, IOException {

		u.setUserName("test23");
		u.setPassword("test1234");
		u.setAdminRole("user");
		ud.registerUser(u);

		assertNotNull(u.getUserId());
		assertNotNull(u.getUserName());
		assertNotNull(u.getPassword());
		assertNotNull(u.getAdminRole());
	}

	// Test for checkEqualsGetUserByName
	@Test
	public void checkEqualsGetUserByName() throws ClassNotFoundException, SQLException, IOException {

		u.getUserName();
		u = ud.getUserByName("Mona1");

		assertEquals("Mona1", u.getUserName());
		assertEquals("test11", u.getPassword());
		assertEquals("user", u.getAdminRole());

	}

	// Test for notNullGetUserByName
	@Test
	public void notNullGetUserByName() throws ClassNotFoundException, SQLException, IOException {

		u.getUserName();
		u = ud.getUserByName("Mona1");

		assertNotNull(u.getUserId());
		assertNotNull(u.getUserName());
		assertNotNull(u.getPassword());
		assertNotNull(u.getAdminRole());

	}

}
