package com.cts.insurance.selenium;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeTrue;

import java.io.File;
import java.io.IOException;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationTest {
	private static WebDriver driver;
	private static String screenshotFolder;

	@BeforeClass
	public static void setUp() {
		//Setup Webdriver property
		System.setProperty("webdriver.chrome.driver", "/Users/Student/Downloads/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		//Screenshot folder declare 
		screenshotFolder = "Screenshots_" + LocalDateTime.now();
		
		//Open website
		driver.get("http://localhost:8081/homeinsurance/");
		
		//Click Registration link
		driver.findElement(By.cssSelector("body > div > div:nth-child(4) > a:nth-child(2)")).click();

	}

	@AfterClass
	public static void tearDownClass() {
		driver.close();
	}

	@Test
	public void registrationTest() throws IOException {
		//Check redirected to correct page
		assertThat(driver.getTitle(), equalTo("Registration Page"));
		
		//Enter input elements
		WebElement nameInput = driver.findElement(By.xpath("/html/body/form/div[1]/input[1]"));
		nameInput.sendKeys("testUser");

		WebElement passwordInput = driver.findElement(By.xpath("/html/body/form/div[2]/input"));
		passwordInput.sendKeys("testPassword");

		WebElement passwordConfirm = driver.findElement(By.xpath("/html/body/form/div[3]/input"));
		passwordConfirm.sendKeys("testPassword");
		
		//Click Registration button
		driver.findElement(By.xpath("/html/body/form/div[4]/input")).click();
		
		//Take screenshot
		takeScreenShot(driver);
	}

	private void takeScreenShot(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\Student\\Desktop\\ScreenShot\\"
				+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH.mm.ss_dd.MM.yyyy")) + ".png"));
	}

}
