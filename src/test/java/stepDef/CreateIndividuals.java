package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.SnapShot;
import testcase.UtilityClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
public class CreateIndividuals extends UtilityClass {

	@Given ("Click Individuals from App Launcher")
	public void clickIndividuals() {
		WebElement findElementIndividuals = driver.findElement(By.xpath("//p[text()='Individuals']"));
		action.moveToElement(findElementIndividuals).perform();
		findElementIndividuals.click();		
	}

	@And ("Click on the Dropdown icon in the Individuals tab")
	public void clickDropdownandIndividuals() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Individuals')]/following::lightning-icon[contains(@class,'slds-icon_container')])[1]")));
		driver.findElement(By.xpath("(//span[contains(text(),'Individuals')]/following::lightning-icon[contains(@class,'slds-icon_container')])[1]")).click();
	}

	@And ("Click on New Individual")
	public void newIndividual() {
		WebElement webelementNewIndividual = driver.findElement(By.xpath("//span[text()='New Individual']"));
		driver.executeScript("arguments[0].click()", webelementNewIndividual);
	}

	@And ("Enter the Last Name as (.*)$")
	public void typeLastName(String lastName) {
		driver.findElement(By.xpath("//span[text()='Last Name']/following::input[@placeholder=\"Last Name\"]")).sendKeys(lastName);
	}

	@And ("Click save Individuals")
	public void clickSaveIndividual() {
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	}

	@Then ("Verify Individuals Name")
	public void verifyIndividual() throws IOException, InterruptedException {
		System.out.println(driver.findElement(By.xpath("//span[contains(@class,'slds-text-heading--small forceActionsText')]")).getText());
		SnapShot.takeScreenshot("Individuals");
	}
}
