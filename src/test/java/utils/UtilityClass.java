package utils;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilityClass extends AbstractTestNGCucumberTests{
	
	public static ChromeDriver driver;
	public static WebDriverWait wait;
	public static Actions action;
	public static String fname;
	
	@BeforeMethod
	public void init() {
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			action = new Actions(driver);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://login.salesforce.com/");
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
