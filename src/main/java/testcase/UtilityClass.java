package testcase;

import org.testng.annotations.AfterMethod;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilityClass{

	public static ChromeDriver driver;
	public static WebDriverWait wait;
	public static Actions action;
	public static String fname;
	public static String titleOfPage;
	public static String titleAfterSave;
	public SoftAssert softAsrt;

	@Parameters({"url","username","password"})
	@BeforeMethod
	public void init(String url,String userName,String passWord) {

		//Setup Driver
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		action = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//SoftAssertion
		softAsrt = new SoftAssert();

		//Load Service now Application
		driver.get(url);

		//Type username 
		driver.findElement(By.id("username")).sendKeys(userName);

		//type password
		driver.findElement(By.id("password")).sendKeys(passWord);

		//Click on Login
		driver.findElement(By.id("Login")).click();

		//Click on toggle menu button from the left corner
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("slds-icon-waffle")));
		driver.findElement(By.className("slds-icon-waffle")).click();

		//Click view All and click Sales from App Launcher
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='View All']")));
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	}

	@AfterMethod(alwaysRun =true)
	public void tearDown() {
		//Close Brower
		driver.close();
	}
}
