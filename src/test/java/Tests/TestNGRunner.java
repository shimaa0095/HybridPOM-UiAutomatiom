package Tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {"src/test/resources/PageFeatures"}
		,glue = {"DiffinitionStepsOfPages", "Hooks"}
		,plugin = {"pretty","html:target/MyReports/Report.html"}

//,plugin = {"pretty",
		//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		//"timeline:test-output-thread/"}
		,publish = true
				)
public class TestNGRunner extends AbstractTestNGCucumberTests{
	

}
