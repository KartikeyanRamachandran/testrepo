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

public class CreateNewOpportunity extends UtilityClass{
	
	@Given ("Click on Opportunity tab")
	public void clickOpportunityTab() {
		WebElement webelementOpportinities = driver.findElement(By.xpath("//p[text()='Opportunities']"));
		action.moveToElement(webelementOpportinities).perform();
		webelementOpportinities.click();
	}
	
	@And ("Click on New Opportunity button")
	public void clickCreateNewOpportunities() throws InterruptedException {
		driver.findElement(By.xpath("//div[text()='New']")).click();
	}
	
	@And ("Enter Opportunity name as Salesforce Automation by (.*)$")
	public void typeOpportunityName(String nameofopportunities) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//label[text()='Opportunity Name']/following::input[@class='slds-input'])[1]")));
		driver.findElement(By.xpath("(//label[text()='Opportunity Name']/following::input[@class='slds-input'])[1]")).sendKeys("Salesforce Automation by "+nameofopportunities);
	}
	
	@And ("Choose close date as Today")
	public void selectTodaydate() {
		driver.findElement(By.xpath("//label[text()='Close Date']/following::input[@name='CloseDate']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Today']")));
		driver.findElement(By.xpath("//button[text()='Today']")).click();
	}
	
	@And ("Select Stage as Need Analysis")
	public void selectStage() throws InterruptedException {
		driver.findElement(By.xpath("(//label[text()='Stage']/following::button[@aria-haspopup=\"listbox\"])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Needs Analysis' and @title='Needs Analysis']")).click();
	}
	
	@And ("click Save Opportunity")
	public void clickSaveOpportunities() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	
	@Then ("VerifyOppurtunity Name")
	public void verifyOppurtunityName() throws IOException, InterruptedException {
		System.out.println(driver.findElement(By.xpath("(//a[@class=\"forceActionLink\"])[2]/div")).getText());
		SnapShot.takeScreenshot("Opportunity");
	}
}
