package testcase;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CreateAccounts extends UtilityClass{

	@Test
	public void clickAccounts() throws IOException, InterruptedException {	

		//verify title of the Page
		titleOfPage = driver.getTitle();
		System.out.println(titleOfPage);

		//soft Assertion	
		softAsrt.assertEquals(titleOfPage, "Home | Salesforce");

		//Click on Accounts tab
		WebElement webElementAccounts = driver.findElement(By.xpath("//p[text()='Accounts']"));
		action.moveToElement(webElementAccounts).perform();
		webElementAccounts.click();

		//Click on New Account button
		driver.findElement(By.xpath("//div[text()='New']")).click();

		//Enter account name 
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input[@name='Name']")).sendKeys("ramachandran");

		//Select Ownership as Public
		driver.findElement(By.xpath("(//label[text()='Ownership']/following::span[@class='slds-truncate'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Public']")).click();

		//Click Save Account
		driver.findElement(By.xpath("//button[text()='Save']")).click();

		//Verify Account Page Name
		titleAfterSave = driver.getTitle();
		
		//Hard Assertion
		Assert.assertEquals(titleAfterSave, "New Account | Salesforce");
		System.out.println("TestCase Failed Since you are in wrong Page");

	}
}
