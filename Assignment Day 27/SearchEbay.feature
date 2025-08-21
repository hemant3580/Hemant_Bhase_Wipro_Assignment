Feature: eBay Functional Tests
Scenario Outline: Multiple product searches
Given I am on the eBay homepage
When I search for "<product>"
Then search results for "<product>" should be displayed
Examples:
| product    |
| laptop     |
| headphones |
| camera     |
