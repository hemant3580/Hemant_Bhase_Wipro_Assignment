Feature: eBay Functional Tests
Scenario: Shop by category navigation
Given I am on the eBay homepage
When I navigate by categories to Electronics -> Mobiles
Then the correct category page should be displayed
