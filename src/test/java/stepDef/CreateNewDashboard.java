package stepDef;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.SnapShot;
import testcase.UtilityClass;

public class CreateNewDashboard extends UtilityClass{

	@Given ("Click Dashboards from App Launcher")
	public void clickDashboard() {
		WebElement elementDashboard = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		action.moveToElement(elementDashboard).perform();
		elementDashboard.click();
	}
	
	@And ("Click on the New Dashboard option")
	public void clickNewDashboard() {
		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
	}
	
	@And ("Enter Name as Salesforce Automation by (.*)$")
	public void typeYourName(String yourName) {
		WebElement dashboardFrame = driver.findElement(By.xpath("//iframe[@title=\"dashboard\"]"));
		driver.switchTo().frame(dashboardFrame);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dashboardNameInput")));
		driver.findElement(By.id("dashboardNameInput")).sendKeys("Salesforce Automation by "+yourName);
	}
	
	@And ("Click on Create")
	public void clickCreate() {
		driver.findElement(By.xpath("//button[text()='Create']")).click();
	}
	
	@And ("Click Save Dashboard")
	public void clickSaveDashboard() throws InterruptedException {
		WebElement webElementFrame = driver.findElement(By.xpath("//iframe[@title=\"dashboard\"]"));
		driver.switchTo().frame(webElementFrame);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	@Then ("Verify Dashboard name")
	public void verifyDashboard() throws IOException, InterruptedException {
		System.out.println(driver.findElement(By.xpath("//span[contains(@class,\"slds-form-element__static\")]")).getText());
		SnapShot.takeScreenshot("Dashboards");
	}
}
