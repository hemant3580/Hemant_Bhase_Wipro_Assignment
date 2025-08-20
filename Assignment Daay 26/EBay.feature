Feature: eBay Functional Tests

Scenario: Login with valid credentials
Given I open the eBay homepage
When I click on Sign in
And I enter valid username and password
Then I should be logged in successfully

Scenario Outline: Multiple product searches
Given I am on the eBay homepage
When I search for "<product>"
Then search results for "<product>" should be displayed

Examples:
| product    |
| laptop     |
| headphones |
| camera     |

Scenario: Add product to cart and remove it
Given I am logged in
When I search for "Bulova 97B168 Marine Star Blue Dial Rubber Strap Men's"
And I add the product to the cart
Then the product should be visible in the cart
When I remove the product from the cart
Then the cart should be empty

Scenario: Change login username
Given I am logged in
When I navigate to account settings and update the username to "Hemant"
Then the username should be updated successfully

Scenario: Change address details
Given I am logged in
When I navigate to account settings and update the address with valid details
Then the address should be updated successfully

Scenario: Shop by category navigation
Given I am on the eBay homepage
When I navigate by categories to Electronics -> Mobiles
Then the correct category page should be displayed

Scenario: Shop by all category dropdown
Given I am on the eBay homepage
When I select "Electronics" from all categories dropdown and search
Then the results should be filtered for Electronics


