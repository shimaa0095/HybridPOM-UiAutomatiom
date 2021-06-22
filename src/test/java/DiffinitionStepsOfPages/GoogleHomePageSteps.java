package DiffinitionStepsOfPages;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import Pages.GoogleSearchResultPage;
import Pages.GoogleSearhHomePage;
import Pages.PagesAllocators;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleHomePageSteps {
	private WebDriver driver=DriverFactory.getDriver();
	private GoogleSearhHomePage googleHomePage = new GoogleSearhHomePage(driver);
	private GoogleSearchResultPage googleResultPage ;
    List<Integer> listOfLinksCounts = new ArrayList<Integer>();


	@Given("user is on google home page")
	public void user_is_on_google_home_page() {
		PagesAllocators.managePagesAllocators();//read elements properties file for only one time
		GoogleSearhHomePage.ManageHomePageAllocators();//read only home page allocators
		googleHomePage.OpenUrl();
	}

	@When("user searchs about: {string}")
	public void user_searchs_about(String searchData) {
		googleHomePage.SearchAboutSomeThing(searchData);
	}
	
	@When("user scrolls down and clicks on the result page of number: {string}")
	public void user_scrolls_down_and_clicks_on_the_result_page_of_number(String searchItemNumber) {
	    googleHomePage.ScrollAndClick(searchItemNumber);

	}
	@Given("user redirects to search result page")
	public void user_redirects_to_search_result_page() {
		googleResultPage=new GoogleSearchResultPage(googleHomePage.GetDriver());
		
	}
	
	@When("user gets the total number of displayed links")
	public void user_gets_the_total_number_of_displayed_links() {
		listOfLinksCounts.add(googleResultPage.getResultsLinksCounts());
	}

	
	@When("User get navigate back to google search home page")
	public void User_get_navigate_back_to_google_search_home_page() {
		googleHomePage.SetDriver(googleResultPage.NavigateBackToHomePage());
	}
	
	@Then("user validates if the number of results pages links is equal")
	public void user_validates_if_the_number_of_results_pages_links_is_equal() {
		assertEquals(Double.valueOf(listOfLinksCounts.get(0)),Double.valueOf(listOfLinksCounts.get(1)));
	}
	
	}
