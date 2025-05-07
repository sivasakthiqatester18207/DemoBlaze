package com.DB.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DB_SignUp
{
	@FindBy(xpath = "//a[text()='Sign up']")
	public static WebElement signup;
	
	@FindBy(id = "sign-username")
	public static WebElement username;
	
	@FindBy(id = "sign-password")
	public static WebElement password;
	
	@FindBy(xpath = "//button[text()='Sign up']")
	public static WebElement signup_btn;
}
