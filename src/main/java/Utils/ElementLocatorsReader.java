package Utils;

import java.util.Properties;

public class ElementLocatorsReader {
	
	private Properties prop;
	private String filePath= "./src/test/resources/Locators/ElementLocators.properties";

	/**
	 * This method is used to load the properties from config.properties file
	 * @return it returns Properties prop object
	 */
	public Properties get_Locators_properties() {

		prop = new PropertiesReader().init_properties(filePath);

		return prop;
	}
}
