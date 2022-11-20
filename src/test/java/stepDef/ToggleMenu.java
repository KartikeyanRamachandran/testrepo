package stepDef;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.SnapShot;
import testcase.UtilityClass;

public class ToggleMenu extends UtilityClass{
	
	@And ("Click on toggle menu button from the left corner")
	public void toggleMenuButton() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("slds-icon-waffle")));
		driver.findElement(By.className("slds-icon-waffle")).click();
	}
	@And ("Click view All and click Sales from App Launcher")
	public void clickViewAll() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='View All']")));
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	}
	
	@Then ("Home screen Displays")
	public void verifyLogin() throws IOException, InterruptedException {
		System.out.println(driver.getTitle());
		SnapShot.takeScreenshot("LoginSuccess");
	}
}
