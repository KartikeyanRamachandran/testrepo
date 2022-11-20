package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CreateOpportunityWithoutMandatoryFields extends UtilityClass{
	
	@Test
	public void createOpportunityToVerify() {
		//verify title of the Page
		titleOfPage = driver.getTitle();
		System.out.println(titleOfPage);

		//soft Assertion	
		softAsrt.assertEquals(titleOfPage, "Home | Salesforce");
		
		//Click on Opportunity tab
		WebElement webelementOpportinities = driver.findElement(By.xpath("//p[text()='Opportunities']"));
		action.moveToElement(webelementOpportinities).perform();
		webelementOpportinities.click();


		//Click on New Opportunity button
		driver.findElement(By.xpath("//div[text()='New']")).click();

		//Enter Opportunity name as Salesforce Automation
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//label[text()='Opportunity Name']/following::input[@class='slds-input'])[1]")));
		driver.findElement(By.xpath("(//label[text()='Opportunity Name']/following::input[@class='slds-input'])[1]")).sendKeys("Salesforce Automation by Muthu");

		//Choose close date as Today
		driver.findElement(By.xpath("//label[text()='Close Date']/following::input[@name='CloseDate']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Today']")));
		driver.findElement(By.xpath("//button[text()='Today']")).click();

		//Select Stage as Need Analysis
		driver.findElement(By.xpath("(//label[text()='Stage']/following::button[@aria-haspopup=\"listbox\"])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Needs Analysis' and @title='Needs Analysis']")).click();

		//click Save Opportunity
		driver.findElement(By.xpath("//button[text()='Save']")).click();

		//VerifyOppurtunity Name
		System.out.println(driver.findElement(By.xpath("(//a[@class=\"forceActionLink\"])[2]/div")).getText());
	}

}
