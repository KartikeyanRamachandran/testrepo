package stepDef;

import java.io.IOException;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import utils.SnapShot;
import testcase.UtilityClass;

public class CreateOpportunityWithoutMandatoryFields extends UtilityClass{
	
	@Then ("Verify the Alert message")
	public void verifyAlert() throws IOException, InterruptedException {
		String errorName = driver.findElement(By.xpath("//h2[contains(@class,'slds-text-heading_medium')]")).getText();
		System.out.println(errorName);
		SnapShot.takeScreenshot("OpportunityWithoutMandatoryFields");
	}

}
