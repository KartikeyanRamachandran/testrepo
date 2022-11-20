package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

public class SnapShot extends UtilityClass{ 
	public static void takeScreenshot(String fileName) throws IOException, InterruptedException {
		Thread.sleep(3000);
		File scrFile = driver.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + fileName+ System.currentTimeMillis() + ".png"));
	}
}
