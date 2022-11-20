package stepDef;

import java.io.IOException;

import org.openqa.selenium.By;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import utils.SnapShot;
import utils.UtilityClass;

public class LoginPage extends UtilityClass {

	@Given ("Type username as {string}")
	public void typeUsername(String userName) {
		driver.findElement(By.id("username")).sendKeys(userName);
	}

	@And ("type password as {string}")
	public void typePassword(String passWord) {
		driver.findElement(By.id("password")).sendKeys(passWord);
	}

	@And ("Click on Login")
	public void clickLogin() {
		driver.findElement(By.id("Login")).click();
	}

	@But ("But Verify error Displayed")
	public void verifyErrorMessage() throws IOException, InterruptedException {
		boolean displayed = driver.findElement(By.id("error")).isDisplayed();
		if(displayed) {
			System.out.println("invalid Login");
		}
		SnapShot.takeScreenshot("LoginFailed");
	}	
}
