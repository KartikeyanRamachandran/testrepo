package hooks;

import io.cucumber.java.BeforeStep;
import testcase.UtilityClass;

public class HooksImplementation extends UtilityClass{
	
	@BeforeStep
	public void stepDelay() throws InterruptedException {
		Thread.sleep(1000);
	}

}
