package com.cts.insurance.selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ RegistrationTest.class, LoginTest.class, GetQuoteTest.class, BuyQuoteTest.class, RetrieveQuoteTest.class,
		BuyQuoteThruRetrieveQuoteTest.class, MyPoliciesTest.class, ViewPolicyAsAdminTest.class, RenewPolicyAsAdminTest.class, CancelPolicyAsAdminTest.class })

public class AllSeleniumTestSuite {

}
