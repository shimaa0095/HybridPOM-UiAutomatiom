Feature: Google Search feature

Scenario: Doing Search
Given user is on google home page
When user searchs about: "Vodafone" 
And user scrolls down and clicks on the result page of number: "3"
Given user redirects to search result page
When user gets the total number of displayed links 
And User get navigate back to google search home page
And user searchs about: "Vodafone"
And user scrolls down and clicks on the result page of number: "3"
Given user redirects to search result page
When user gets the total number of displayed links 
Then user validates if the number of results pages links is equal 

