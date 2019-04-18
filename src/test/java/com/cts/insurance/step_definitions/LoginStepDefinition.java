package com.cts.insurance.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Cucumber.class)
public class LoginStepDefinition {
	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Student/Downloads/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		action = new Actions(driver);
	}

	@After
	public void tearDownClass() {
		driver.close();
	}

	@Given("^User is on the login page$")
	public void user_is_on_the_login_page() throws Throwable {

		// Open web application
		driver.get("http://localhost:8081/homeinsurance/");

	}

	@When("^User enters username into username input field$")
	public void user_enters_username_into_username_input_field() throws Throwable {
		// Enter input element
		WebElement nameInput = driver.findElement(By.xpath("/html/body/div/form/div[1]/input"));
		nameInput.sendKeys("mona");

	}

	@Then("^User is directed to Get Started page$")
	public void user_is_directed_to_get_started_page() throws Throwable {
		// Click login button
		driver.findElement(By.xpath("/html/body/div/form/div[3]/input")).click();

		// Check redirected to correct page
		assertThat(driver.getTitle(), equalTo("Welcome Page"));
	}

	@And("^User enters passowrd into password field$")
	public void user_enters_passowrd_into_password_field() throws Throwable {
		// Enter input elements
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/form/div[2]/input"));
		passwordInput.sendKeys("1212");
	}

}
