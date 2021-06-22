package Pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchResultPage {
	
	private WebDriver driver;
    private static String pageTagNameInProp="pageTagName";
    protected static By google_result_links_byTagName ;
    
    
	protected By google_result_links_byTagname = By.tagName("a");
	
	public GoogleSearchResultPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public Integer getResultsLinksCounts() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(google_result_links_byTagname));	
		List<WebElement> listings = driver.findElements(google_result_links_byTagname);
		return listings.size();
	    }
	
	public WebDriver NavigateBackToHomePage() {
   	 driver.navigate().back();
   	 return driver;
   }

}
