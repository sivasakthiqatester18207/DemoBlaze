package com.DB.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DB_Login {
	@FindBy(xpath = "//a[text()='Log in']")
	public static WebElement login;
	
	@FindBy(id = "loginusername")
	public static WebElement log_username;
	
	@FindBy(id = "loginpassword")
	public static WebElement log_password;
	
	@FindBy(xpath = "//button[text()='Log in']")
	public static WebElement login_btn;
}
