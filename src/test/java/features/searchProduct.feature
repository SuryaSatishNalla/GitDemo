Feature: Search and Place the Order of Products

@OfferPage
Scenario Outline: Search Experience for product search in both home and offers page

Given User is on Greenkart Landing page
When User searched with shortname <Name> in home page and extracted actual name of product
Then User searched with shortname <Name> in offers page 
And Validate product name in offers page matches with Landing Page


Examples:
| Name |
| Tom  |
| Beet |