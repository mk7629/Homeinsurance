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
import org.openqa.selenium.support.ui.Wait;

import com.cts.insurance.dao.DbConnection;

public class CancelPolicyAsAdminTest {
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

		// Click admin login link
		driver.findElement(By.xpath("/html/body/div/div[1]/a[1]")).click();

		// Check redirected to correct page
		assertThat(driver.getTitle(), equalTo("Admin Login Page"));

		// Enter input elements
		WebElement nameInput = driver.findElement(By.xpath("/html/body/div/form/div[1]/input"));
		nameInput.sendKeys("admin");

		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/form/div[2]/input"));
		passwordInput.sendKeys("1234");

		// Click login button
		driver.findElement(By.xpath("/html/body/div/form/div[3]/input")).click();

		// Take screenshot
		takeScreenShot(driver);
	}

	@Test
	public void beginCancelPolicyTest() throws IOException {
		// Check redirected to correct page
		assertThat(driver.getTitle(), equalTo("Admin Search Page"));

		// Enter input elements
		WebElement userInput = driver
				.findElement(By.cssSelector("body > div > div > form > div.form-group > input[type=\"text\"]"));
		userInput.sendKeys("mona");

		// Click search button
		driver.findElement(By.xpath("/html/body/div/div/form/div[2]/input")).click();

		// Check redirected to correct page
		assertThat(driver.getTitle(), equalTo("Admin Search Result Page"));

		// Check correct user displayed
		assertThat(driver.findElement(By.cssSelector("body > h2")).getText(), containsString("mona Policies"));

		// Check policy information is correct
		assertThat(driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td[4]")).getText(),
				containsString("2019-04-23"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td[5]")).getText(),
				containsString("2020-04-22"));
		assertThat(driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[2]/td[7]")).getText(),
				containsString("active"));

		// Click Cancel button
		driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[5]/td[9]/form/input")).click();


		// Click logout button
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[2]/a")).click();

		// Take screenshot
		takeScreenShot(driver);
	}

	private void takeScreenShot(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\Student\\Desktop\\ScreenShot\\"
				+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH.mm.ss_dd.MM.yyyy")) + ".png"));
	}

}
