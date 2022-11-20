package runner;

import io.cucumber.testng.CucumberOptions;
import testcase.UtilityClass;

@CucumberOptions(features = "src\\test\\java\\features",
glue = {"stepDef","hooks"},
monochrome = true,
publish = true,
tags = "@smoke or @sanity")

public class RunTestSuit extends UtilityClass{

}
