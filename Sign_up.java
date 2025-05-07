package com.DB.testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.DB.pom.DB_SignUp;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sign_up {
	@Test
	public void signup()
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.demoblaze.com/");
		
		PageFactory.initElements(driver, DB_SignUp.class);
		
		DB_SignUp.signup.click();
		DB_SignUp.username.sendKeys("testg1@yopmail.com");
		DB_SignUp.password.sendKeys("Test@1234");
		DB_SignUp.signup_btn.click();
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	        //execute js for alert
	        js.executeScript("alert('Sign up successful.');");
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        //Wait for the alert to be displayed and store it in a variable
	        wait.until(ExpectedConditions.alertIsPresent());

	        Alert alert = driver.switchTo().alert();
	        //Store the alert text in a variable and verify it
	        String text = alert.getText();
	        assertEquals(text, "Sign up successful.");
	        //Press the OK button
	        alert.accept();
	        driver.quit();
	}

}
