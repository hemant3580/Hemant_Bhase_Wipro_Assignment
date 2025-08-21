Feature: eBay Functional Tests
Scenario: Change login username
Given I am logged in
When I navigate to account settings and update the username to "Hemant"
Then the username should be updated successfully
