package Hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import Utils.ConfigReader;
import Utils.ElementLocatorsReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties configProp;
	private String browserNameInProp="Browser";
	

	@Before(order = 0)
	public void getProperties() {
		configReader = new ConfigReader();
		configProp = configReader.get_Config_properties();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = configProp.getProperty(browserNameInProp);
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);	
	}

	
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

}
