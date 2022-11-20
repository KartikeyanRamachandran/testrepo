package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.SnapShot;
import testcase.UtilityClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;

public class CreateAccounts extends UtilityClass{
	
	@Given ("Click on Accounts tab")
	public void clickAccounts() {
		WebElement webElementAccounts = driver.findElement(By.xpath("//p[text()='Accounts']"));
		action.moveToElement(webElementAccounts).perform();
		webElementAccounts.click();
	}
	
	@And ("Click on New Account button")
	public void clickNewAccount() {
		driver.findElement(By.xpath("//div[text()='New']")).click();
	}
	@And ("Enter account name as (.*)$")
	public void typeAccountName(String accountName) {
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input[@name='Name']")).sendKeys(accountName);
	}
	@And ("Select Ownership as Public")
	public void selectOwnerShip() {
		driver.findElement(By.xpath("(//label[text()='Ownership']/following::span[@class='slds-truncate'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Public']")).click();
	}
	
	@And ("Click Save Account")
	public void clickSaveNewAccount() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	
	@Then ("Verify Account name")
	public void verifyAccountName() throws IOException, InterruptedException {
		System.out.println(driver.findElement(By.xpath("//div[@role='alertdialog']//span//div")).getText());
		SnapShot.takeScreenshot("CreateAccount");
	}

}
