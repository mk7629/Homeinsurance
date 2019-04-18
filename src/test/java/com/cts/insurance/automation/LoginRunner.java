package com.cts.insurance.automation;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/cts/insurance/features",
		glue = "com/cts/insurance/step_definitions"
		)
public class LoginRunner {

   

}
