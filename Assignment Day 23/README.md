# Ebay Test Automation - Selenium + TestNG

This project is a **Java Selenium WebDriver + TestNG** automated test suite for [eBay.com](https://www.ebay.com/).  
It covers **end-to-end user actions** like login, searching products, adding items to the cart, modifying account settings, and navigating through categories.

---

## Features / Test Cases Covered

1. **Login Test** (priority = 1)
   - Logs into eBay using username and password.
   - Verifies successful login via page title.

2. **Multiple Searches Test** (priority = 2)
   - Searches for multiple items: *Laptop*, *Headphones*, *Camera*.
   - Checks if search results match the entered item.

3. **Add to Cart Test** (priority = 3)
   - Searches for a specific watch product by exact name.
   - Opens product page (in a new tab/window if needed).
   - Adds the product to the cart.
   - Removes the product from the cart.

4. **Change Login Name** (priority = 4)
   - Navigates to account settings page.
   - Edits the current login name.
   - Re-authenticates with credentials.

5. **Change Address** (priority = 5)
   - Navigates to personal info → address edit form.
   - Updates address, city, state, and postal code.

6. **Shop by Category** (priority = 6)
   - Opens "Shop by Category" menu.
   - Selects a main category and subcategory.

7. **Shop by All Categories** (priority = 7)
   - Selects category from dropdown.
   - Validates results navigation.
