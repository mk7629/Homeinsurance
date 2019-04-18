package com.cts.insurance.junittest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UserDAOTest.class, LocationDAOTest.class, HomeownerDAOTest.class, PropertyDAOTest.class,
		QuoteDAOTest.class, PolicyDAOTest.class })

public class AllDAOTestSuite {

}
