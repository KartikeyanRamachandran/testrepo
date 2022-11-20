package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateIndividuals extends UtilityClass {

	@Test
	public void CreateNewIndividuals() {
		//verify title of the Page
		titleOfPage = driver.getTitle();
		System.out.println(titleOfPage);

		//soft Assertion	
		softAsrt.assertEquals(titleOfPage, "Home | Salesforce");

		//Click Individuals from App Launcher
		WebElement findElementIndividuals = driver.findElement(By.xpath("//p[text()='Individuals']"));
		action.moveToElement(findElementIndividuals).perform();
		findElementIndividuals.click();		

		//Click on the Dropdown icon in the Individuals tab
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Individuals')]/following::lightning-icon[contains(@class,'slds-icon_container')])[1]")));
		driver.findElement(By.xpath("(//span[contains(text(),'Individuals')]/following::lightning-icon[contains(@class,'slds-icon_container')])[1]")).click();

		//Click on New Individual
		WebElement webelementNewIndividual = driver.findElement(By.xpath("//span[text()='New Individual']"));
		driver.executeScript("arguments[0].click()", webelementNewIndividual);

		//Enter the Last Name
		driver.findElement(By.xpath("//span[text()='Last Name']/following::input[@placeholder=\"Last Name\"]")).sendKeys("kumar");

		//Click save Individuals
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();

		//Verify Individuals Name
		titleAfterSave = driver.getTitle();
		
		//Hard Assertion
		Assert.assertEquals(titleAfterSave, "Home | Salesforce");
		System.out.println("TestCase Failed Since you are in wrong Page");
	}
}
