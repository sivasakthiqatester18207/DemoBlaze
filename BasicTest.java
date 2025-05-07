package com.DB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class BasicTest {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com");

		// Setup explicit wait with 10-second timeout
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	public void testHomepageLoads() {
		List<WebElement> products = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("card-title")));
		Assert.assertTrue(products.size() > 0, "Homepage should display products");
		System.out.println("[PASS] Homepage loaded and products are displayed.");
	}

	@Test(priority = 2)
	public void testPhonesCategory() {
		driver.findElement(By.linkText("Phones")).click();
		List<WebElement> phones = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Phones']")));
		Assert.assertTrue(phones.size() > 0, "Phones category should display products");
		System.out.println("[PASS] Phones category loaded with products.");
	}

	@Test(priority = 3)
	public void testLaptopsCategory() {
		driver.findElement(By.linkText("Laptops")).click();
		List<WebElement> laptops = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Laptops']")));
		Assert.assertTrue(laptops.size() > 0, "Laptops category should display products");
		System.out.println("[PASS] Laptops category loaded with products.");
	}

	@Test(priority = 4)
	public void testMonitorsCategory() {
		driver.findElement(By.linkText("Monitors")).click();
		List<WebElement> monitors = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Monitors']")));
		Assert.assertTrue(monitors.size() > 0, "Monitors category should display products");
		System.out.println("[PASS] Monitors category loaded with products.");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
