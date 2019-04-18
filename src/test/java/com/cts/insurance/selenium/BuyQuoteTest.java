package com.cts.insurance.selenium;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeTrue;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.cts.insurance.dao.DbConnection;

public class BuyQuoteTest {
	private static WebDriver driver;
	private static Wait wait;
	private static String screenshotFolder;
	private static DbConnection oracle;
	private static Connection conn;
	private static Boolean databaseIsOnline;

	@BeforeClass
	public static void setUp() {
		// Setup Webdriver property
		System.setProperty("webdriver.chrome.driver", "/Users/Student/Downloads/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		try {
			oracle = new DbConnection();
			conn = oracle.getConnection();
			databaseIsOnline = true;
			conn.close();
		} catch (Exception e) {
			databaseIsOnline = false;
			System.out.println("UserDAOTest Class: Could not connect to the database. Tests will be skipped");
		}

		// Screenshot folder declare
		screenshotFolder = "Screenshots_" + LocalDateTime.now();

		// Open website
		driver.get("http://localhost:8081/homeinsurance/");

	}

	@AfterClass
	public static void tearDownClass() {

		driver.close();
	}

	@Test
	public void loginTest() throws IOException {
		// Check redirected to correct page
		assertThat(driver.getTitle(), equalTo("Login Page"));

		// Enter input elements
		WebElement nameInput = driver.findElement(By.xpath("/html/body/div/form/div[1]/input"));
		nameInput.sendKeys("mona");

		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/form/div[2]/input"));
		passwordInput.sendKeys("1212");

		// Click login button
		driver.findElement(By.xpath("/html/body/div/form/div[3]/input")).click();

		// Take screenshot
		takeScreenShot(driver);
	}

	@Test
	public void beginGetQuote() throws IOException {

		// Clicking Get Start on Welcome Page
		WebElement startBtn = driver.findElement(By.cssSelector("body > div > div > div.col-1 > form > input"));
		startBtn.click();

		// Input Location
		Select residenceType = new Select(driver.findElement(By.name("residenceType")));
		residenceType.selectByVisibleText("Single-Family Home");
		WebElement addressLine1Input = driver.findElement(By.name("address1"));
		addressLine1Input.sendKeys("3200 Hawks View Ln");
		WebElement cityInput = driver.findElement(By.name("city"));
		cityInput.sendKeys("Denton");
		WebElement stateInput = driver.findElement(By.name("state"));
		stateInput.sendKeys("Texas");
		WebElement zipInput = driver.findElement(By.name("zip"));
		zipInput.sendKeys("76201");
		Select residenceUse = new Select(driver.findElement(By.name("residenceUse")));
		residenceUse.selectByVisibleText("Primary");
		WebElement continueToHomeownerBtn = driver.findElement(By.xpath("/html/body/div/form/div[8]/input"));
		continueToHomeownerBtn.click();

		// Input Homeowner information
		WebElement firstName = driver.findElement(By.name("firstName"));
		firstName.sendKeys("Mona");
		WebElement lastName = driver.findElement(By.name("lastName"));
		lastName.sendKeys("Kang");
		WebElement DOB = driver.findElement(By.name("dob"));
		DOB.sendKeys("11/11/1988");
		WebElement ssn = driver.findElement(By.name("ssn"));
		ssn.sendKeys("123451511");
		WebElement retired = driver.findElement(By.xpath("(//input[@name='retired'])[2]"));
		retired.click();
		WebElement emailInput = driver.findElement(By.name("email"));
		emailInput.sendKeys("monaka@outlook.com");
		WebElement continueToPropertyDetailsBtn = driver.findElement(By.xpath("/html/body/div/form/div[7]/input"));
		continueToPropertyDetailsBtn.click();

		// Input Property Details information
		WebElement marketValueInput = driver.findElement(By.name("marketValue"));
		marketValueInput.sendKeys("150000");
		WebElement yearBuiltInput = driver.findElement(By.name("yearBuilt"));
		yearBuiltInput.sendKeys("2016");
		WebElement squareFootageInput = driver.findElement(By.name("squareFootage"));
		squareFootageInput.sendKeys("2000");
		Select dwellingStyle = new Select(driver.findElement(By.name("dwellingStyle")));
		dwellingStyle.selectByVisibleText("2 Stories");
		Select roofMaterial = new Select(driver.findElement(By.name("roofingMaterial")));
		roofMaterial.selectByVisibleText("Concrete");
		Select garageType = new Select(driver.findElement(By.name("garageType")));
		garageType.selectByVisibleText("Attached");
		Select fullBaths = new Select(driver.findElement(By.name("fullBaths")));
		fullBaths.selectByVisibleText("3");
		Select halfBaths = new Select(driver.findElement(By.name("halfBaths")));
		halfBaths.selectByVisibleText("1");
		WebElement pool = driver.findElement(By.xpath("/html/body/div/form/div[9]/input[2]"));
		pool.click();
		WebElement continueToCoverageDetailsBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
		continueToCoverageDetailsBtn.click();

		// Take screenshot
		takeScreenShot(driver);

	}

	@Test
	public void coverageDetails() throws IOException {
		// Check redirected to correct page
		assertThat(driver.getTitle(), equalTo("Coverage Detail"));

		// Check Policy confirmation is correct
		assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr[2]/td[2]")).getText(),
				containsString("$ 62.5"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr[3]/td[2]")).getText(),
				containsString("$ 315000.0"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr[4]/td[2]")).getText(),
				containsString("$ 31500.0"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr[5]/td[2]")).getText(),
				containsString("$ 189000.0"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr[6]/td[2]")).getText(),
				containsString("$ 63000.0"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr[7]/td[2]")).getText(),
				containsString("$ 5000.0"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr[8]/td[2]")).getText(),
				containsString("$ 1500.0"));


		//Click proceedBut button
		WebElement proceedBuyBtn = driver.findElement(By.xpath("/html/body/div/div[3]/div/form/input"));
		proceedBuyBtn.click();
		
		// Check redirected to correct page
		assertThat(driver.getTitle(), equalTo("Quote Summary"));

		// Check quote summary information is correct
		assertThat(driver.findElement(By.xpath("/html/body/div/h4")).getText(), containsString("$62.5"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/table/tbody/tr[4]/td[2]")).getText(),
				containsString("3200 Hawks View Ln"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/table/tbody/tr[4]/td[2]")).getText(),
				containsString("2000"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/table/tbody/tr[4]/td[2]")).getText(),
				containsString("1988-11-11"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/table/tbody/tr[6]/td[2]")).getText(),
				containsString("$ 63000.0"));

		// Clicking buy quote button
		WebElement buyQuoteBtn = driver.findElement(By.xpath("/html/body/div/div[1]/form/input"));
		buyQuoteBtn.click();

		// Check redirected to correct page
		assertThat(driver.getTitle(), equalTo("Buy Policy"));

		// Input policy info
		WebElement startDate = driver.findElement(By.xpath("/html/body/div/form/div[1]/input"));
		startDate.sendKeys("04/23/2019");
		WebElement term = driver.findElement(By.xpath("/html/body/div/form/div[3]/input"));
		term.click();

		// Clicking buy quote button
		WebElement submitBtn = driver.findElement(By.xpath("/html/body/div/form/div[4]/input"));
		submitBtn.click();

		// Check redirected to correct page
		assertThat(driver.getTitle(), equalTo("Policy Confirmation"));

		// Check policy confirmation is correct
		assertThat(driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[3]/td[2]")).getText(),
				containsString("2019-04-23"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[4]/td[2]")).getText(),
				containsString("2020-04-22"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[6]/td[2]")).getText(),
				containsString("active"));

		// Take screenshot
		takeScreenShot(driver);
		
		// Logging out
		WebElement logout = driver.findElement(By.xpath("/html/body/header/nav/ul/li[5]/a"));
		logout.click();

	}


	private void takeScreenShot(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\Student\\Desktop\\ScreenShot\\"
				+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH.mm.ss_dd.MM.yyyy")) + ".png"));
	}

}
