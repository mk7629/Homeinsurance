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

public class BuyQuoteThruRetrieveQuoteTest {
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
		// Logging out
		WebElement logout = driver.findElement(By.xpath("/html/body/header/nav/ul/li[5]/a"));
		logout.click();

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
	public void beginBuyQuotThruRetrieveQuoteTest() throws IOException {
		// Clicking Retrieve Quote from navigation menu
		WebElement startBtn = driver.findElement(By.xpath("/html/body/header/nav/ul/li[3]/a"));
		startBtn.click();

		// Check redirected to correct page
		assertThat(driver.getTitle(), equalTo("Quote List"));

		// Check quote information is correct
		assertThat(driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td[2]")).getText(),
				containsString("$ 62.5"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td[3]")).getText(),
				containsString("$ 315000.0"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td[4]")).getText(),
				containsString("$ 31500.0"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td[5]")).getText(),
				containsString("$ 189000.0"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td[6]")).getText(),
				containsString("$ 63000.0"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td[7]")).getText(),
				containsString("$ 5000.0"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td[8]")).getText(),
				containsString("$ 1500.0"));

		// Take screenshot
		takeScreenShot(driver);

		WebElement buyQuoteBtn = driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td[9]/form/input"));
		buyQuoteBtn.click();
		takeScreenShot(driver);

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
	}

	

	private void takeScreenShot(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\Student\\Desktop\\ScreenShot\\"
				+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH.mm.ss_dd.MM.yyyy")) + ".png"));
	}

}
