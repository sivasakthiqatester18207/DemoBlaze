package com.DB.testcases;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.DB.pom.DB_Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login 
{
	@Test
	public void login() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.demoblaze.com/");
		
		PageFactory.initElements(driver, DB_Login.class);
		
		DB_Login.login.click();
		DB_Login.log_username.sendKeys("testb1@yopmail.com");
		DB_Login.log_password.sendKeys("Test@1234");
		DB_Login.login_btn.click();
	}
}
