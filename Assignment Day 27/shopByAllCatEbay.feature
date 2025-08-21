Feature: eBay Functional Tests
Scenario: Shop by all category dropdown
Given I am on the eBay homepage
When I select "Electronics" from all categories dropdown and search
Then the results should be filtered for Electronics
