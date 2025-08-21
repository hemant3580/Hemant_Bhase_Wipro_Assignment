Feature: eBay Functional Tests
Scenario: Change address details
Given I am logged in
When I navigate to account settings and update the address with valid details
Then the address should be updated successfully
