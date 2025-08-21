Feature: eBay Functional Tests
Scenario: Login with valid credentials
Given I open the eBay homepage
When I click on Sign in
And I enter valid username and password
Then I should be logged in successfully
