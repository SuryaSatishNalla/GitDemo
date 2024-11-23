Feature: Search and Place the Order of Products

@PlaceOrder
Scenario Outline: Search Experience for product search in both home and offers page

Given User is on Greenkart Landing page
When User searched with shortname <Name> in home page and extracted actual name of product
And Added "3" items of selected product to cart
Then User proceeds to Checkout and validate the <Name> items in checkout page
And Verify user has ability to enter promo code and place the order


Examples:
| Name |
| Tom  |