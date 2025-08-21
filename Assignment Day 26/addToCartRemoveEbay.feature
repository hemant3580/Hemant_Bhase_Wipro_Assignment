Feature: eBay Functional Tests
Scenario: Add product to cart and remove it
Given I open the eBay homepage1
When I search for "Bulova 97B168 Marine Star Blue Dial Rubber Strap Men's"
And I add the product to the cart
Then the product should be visible in the cart
When I remove the product from the cart
Then the cart should be empty
