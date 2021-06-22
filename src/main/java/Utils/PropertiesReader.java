package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
	private Properties prop;
	public Properties init_properties(String filePath) {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(filePath);

			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}


}
