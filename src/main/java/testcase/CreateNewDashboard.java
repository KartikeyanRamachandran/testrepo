package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewDashboard extends UtilityClass{

	@Test
	public void clickDashboard() {
		//verify title of the Page
		titleOfPage = driver.getTitle();
		System.out.println(titleOfPage);

		//soft Assertion	
		softAsrt.assertEquals(titleOfPage, "Home | Salesforce");

		//Click Dashboards from App Launcher
		WebElement elementDashboard = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		action.moveToElement(elementDashboard).perform();
		elementDashboard.click();
		//Click on the New Dashboard option
		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();

		//Enter Name as Salesforce Automation
		WebElement dashboardFrame = driver.findElement(By.xpath("//iframe[@title=\"dashboard\"]"));
		driver.switchTo().frame(dashboardFrame);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dashboardNameInput")));
		driver.findElement(By.id("dashboardNameInput")).sendKeys("Salesforce Automation by Aju");

		//Click on Create
		driver.findElement(By.xpath("//button[text()='Create']")).click();

		//Click Save Dashboard
		WebElement webElementFrame = driver.findElement(By.xpath("//iframe[@title=\"dashboard\"]"));
		driver.switchTo().frame(webElementFrame);
		driver.findElement(By.xpath("//button[text()='Save']")).click();

		//Verify Individuals Name
		titleAfterSave = driver.getTitle();

		//Hard Assertion
		Assert.assertEquals(titleAfterSave, "Salesforce Automation by Aju | Salesforce");
		System.out.println("TestCase Failed Since you are in wrong Page");

	}	
}
