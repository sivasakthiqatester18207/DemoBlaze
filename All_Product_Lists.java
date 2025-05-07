package com.DB.testcases;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class All_Product_Lists {

	WebDriver driver;
    WebDriverWait wait;

    @FindBy(linkText = "Phones")
    public static WebElement phoneCategoryLink;
    @FindBy(css = ".card-title a")
    public static List<WebElement> phoneLinks;

    @FindBy(xpath = "//a[text()='Laptops']")
	public static WebElement laptopCategoryLink;
	@FindBy(css = ".card-title a")
	public static List<WebElement> laptopLinks;
	
	@FindBy(xpath = "//a[text()='Monitors']")
	public static WebElement monitorCategoryLink;
	@FindBy(css = ".card-title a")
	public static List<WebElement> monitorLinks;
	
    @BeforeClass
    public void setup() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
    }

    @Test(priority = 1)
    public void testListAllPhones() {
        List<String> phones = getAllPhoneNamesFromCategory();
        for (String pname : phones) {
            System.out.println("Phone: " + pname);
        }
    }

    public List<String> getAllPhoneNamesFromCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(phoneCategoryLink)).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".card-title a")));

        List<String> phoneNames = new ArrayList<>();
        for (WebElement phone : phoneLinks) {
            phoneNames.add(phone.getText());
        }
        return phoneNames;
    }
    
    @Test(priority = 2)
    public void testListAllLaptops() {
		List<String> laptops = getAllLaptopNamesFromCategory();
		for (String lname : laptops) {
			System.out.println("Laptops: " + lname);
		}
	}

	public List<String> getAllLaptopNamesFromCategory() {
		wait.until(ExpectedConditions.elementToBeClickable(laptopCategoryLink)).click();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".card-title a"), "Sony vaio i5"));
		List<WebElement> laptopLinks = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".card-title a")));
		List<String> laptopNames = new ArrayList<>();
		for (WebElement laptop : laptopLinks) {
			laptopNames.add(laptop.getText());
		}

		return laptopNames;
	}
	
	 @Test(priority = 2)
	    public void testListAllMonitors() {
			List<String> monitors = getAllMonitorNamesFromCategory();
			for (String mname : monitors) {
				System.out.println("Monitors: " + mname);
			}
		}

		public List<String> getAllMonitorNamesFromCategory() {
			wait.until(ExpectedConditions.elementToBeClickable(monitorCategoryLink)).click();
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".card-title a"), "Apple monitor 24"));
			List<WebElement> monitorLinks = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".card-title a")));
			List<String> monitorNames = new ArrayList<>();
			for (WebElement monitor : monitorLinks) {
				monitorNames.add(monitor.getText());
			}

			return monitorNames;
		}
	

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}