package com.DB.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.expectThrows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Add_To_Cart

{

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(linkText = "Phones")
	public static WebElement phnlink;

	@FindBy(xpath = "//a[text()='Add to cart']")
	public static WebElement addcartbtn;


	@BeforeClass

	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
		driver.get("https://www.demoblaze.com/");
	}
	@Test
	public  void verifyAndAddPhones()
	{
		wait.until(ExpectedConditions.elementToBeClickable(phnlink)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.card-block h4 a")));
		List<WebElement> phoneElements = driver.findElements(By.cssSelector("div.card-block h4 a"));
		System.out.println(phoneElements.size());
		for (WebElement phone : phoneElements) {
			if(phone.getText().equals("Samsung galaxy s6"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(phone)).click();
				wait.until(ExpectedConditions.elementToBeClickable(addcartbtn)).click();
				wait.until(ExpectedConditions.alertIsPresent());
				Alert alert =driver.switchTo().alert();
		        alert.accept();
		        String text = alert.getText();
		        assertEquals(text, "Product added");
		        System.out.println(text);

				continue;
			}
		}
	}

	@AfterClass

	public void teardown()
	{
		driver.quit();
	}
}
