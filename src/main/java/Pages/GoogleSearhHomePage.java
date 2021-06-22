package Pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.ConfigReader;
import Utils.ElementLocatorsReader;

public class GoogleSearhHomePage {

	private WebDriver driver;
    private static String serchBarNameInProp="SearchBarByName";
    private static String serchBarOptionsInProp="SearchOptionsByXpath";
    private static String urlInProp="Url";
    protected static By google_search_bar;
    protected static By google_search_options; 
   
    
    
    public GoogleSearhHomePage(WebDriver driver) {
	this.driver = driver;
	
    }
    
    public static void ManageHomePageAllocators() {
		urlInProp = PagesAllocators.elementsProp.getProperty(urlInProp);
		serchBarNameInProp=PagesAllocators.elementsProp.getProperty(serchBarNameInProp);
		serchBarOptionsInProp=PagesAllocators.elementsProp.getProperty(serchBarOptionsInProp);
		google_search_bar=By.name(serchBarNameInProp);
		google_search_options=By.xpath(serchBarOptionsInProp);
	}    

   
   
   public void OpenUrl() {
 	   driver.get(urlInProp);
   }  
   
   public void SetDriver(WebDriver driver) {
	   this.driver = driver;
   }
   
   public WebDriver GetDriver() {
	   return driver;
   }
   
    public void SearchAboutSomeThing(String searchData) {

    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(google_search_bar));
    	driver.findElement(google_search_bar).sendKeys(searchData);
	}
    
    public void ScrollAndClick(String searchItemNumber) {

    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.elementToBeClickable(google_search_options));
    	driver.findElements(google_search_options).get(Integer.valueOf(searchItemNumber)-1).click();
	}
    public WebDriver NavigateBack() {
    	 driver.navigate().back();
    	 return driver;
    }
  
}
