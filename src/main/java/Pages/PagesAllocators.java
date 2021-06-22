package Pages;

import java.util.Properties;

import Utils.ElementLocatorsReader;

public class PagesAllocators {
	public static Properties elementsProp;


	public static void managePagesAllocators () {
    	ElementLocatorsReader elementsReader = new ElementLocatorsReader();
	    elementsProp = elementsReader.get_Locators_properties();
	}
	
}
