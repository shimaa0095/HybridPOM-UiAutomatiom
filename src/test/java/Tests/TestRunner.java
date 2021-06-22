package Tests;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/PageFeatures"}
				,glue = {"DiffinitionStepsOfPages", "Hooks"}
						,plugin = {"pretty","html:target/MyReports/Report.html"}
		
		//,plugin = {"pretty",
				//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				//"timeline:test-output-thread/"}
		,publish = true
		)

public class TestRunner {

	
}
