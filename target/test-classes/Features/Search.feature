Feature: Search functionality


Scenario: User searches for a valid product name with logging IN the account
Given User navigates to login page
When User enters valid email address "amotooricap1@gmail.com" into email field
And User enters valid password "12345" into password field
And User clicks on Login button
Then User should get successfully logged in
When User enters valid product "iPhone" into Search box field
And User clicks on Search button
Then User should get valid product displayed page in search results

Scenario: User searches for a valid product name without logging IN the account
Given User opens the Application
When User enters valid product "iPhone" into Search box field
And User clicks on Search button
Then User should get valid product displayed page in search results

@negative 
Scenario: User searches for a invalid product name with logging IN the account
Given User navigates to login page
When User enters valid email address "amotooricap1@gmail.com" into email field
And User enters valid password "12345" into password field
And User clicks on Login button
Then User should get successfully logged in
When User enters valid product "facewash" into Search box field
And User clicks on Search button
Then User should get a message about no product matching

@negative
Scenario: User searches for a invalid product name without logging IN the account
Given User opens the Application
When User enters valid product "facewash" into Search box field
And User clicks on Search button
Then User should get a message about no product matching

Scenario: User searches for a valid brand name with logging IN the account
Given User navigates to login page
When User enters valid email address "amotooricap1@gmail.com" into email field
And User enters valid password "12345" into password field
And User clicks on Login button
Then User should get successfully logged in
When User enters valid product "HP" into Search box field
And User clicks on Search button
Then User should get valid product displayed page in search results

Scenario: User searches for a valid brand name without logging IN the account
Given User opens the Application
When User enters valid product "HP" into Search box field
And User clicks on Search button
Then User should get valid product displayed page in search results

@negative
Scenario: User searches for a invalid brand name with logging IN the account
Given User navigates to login page
When User enters valid email address "amotooricap1@gmail.com" into email field
And User enters valid password "12345" into password field
And User clicks on Login button
Then User should get successfully logged in
When User enters valid product "oneplus" into Search box field
And User clicks on Search button
Then User should get a message about no product matching

@negative
Scenario: User searches for a invalid brand name without logging IN the account
Given User opens the Application
When User enters valid product "oneplus" into Search box field
And User clicks on Search button
Then User should get a message about no product matching

Scenario: Validate placeholder of search field
Given User opens the Application
Then user should get proper placeholder for search field

Scenario: Validate navigating to the search page from homepage
Given User opens the Application
And User clicks on Search button
Then user should navigates to the search page



Scenario: verify product name, product description and price in search result page
Given User opens the Application
When User enters valid product "iPhone" into Search box field
And User clicks on Search button
Then User should get valid product displayed page in search results
And user clicks on Grid view button
Then user should get proper productname description and price in searched result



Scenario: Verify add to Cart functionality of search result page with valid LoggingIN
Given User navigates to login page
When User enters valid email address "amotooricap1@gmail.com" into email field
And User enters valid password "12345" into password field
And User clicks on Login button
Then User should get successfully logged in
When User enters valid product "iPhone" into Search box field
And User clicks on Search button
Then User should get valid product displayed page in search results
When user clicks on add to Cart button
Then user should get confirmation message for add to cart
And user clicks on Shopping cart menu
Then added product should be present inside Shopping cart

@bug
Scenario: Verify add to Cart functionality of search result page without valid LoggingIN
Given User opens the Application
When User enters valid product "iPhone" into Search box field
And User clicks on Search button
Then User should get valid product displayed page in search results
When user clicks on add to Cart button
Then user should navigates to the Login page


Scenario: Verify add to Wishlist functionality of search result page without valid LoggingIN
Given User opens the Application
When User enters valid product "iPhone" into Search box field
And User clicks on Search button
Then User should get valid product displayed page in search results
When user clicks on add to Wishlist button
Then user should get proper warning message for wishlist



Scenario: Verify add to Wishlist functionality of search result page with valid LoggingIN
Given User navigates to login page
When User enters valid email address "amotooricap1@gmail.com" into email field
And User enters valid password "12345" into password field
And User clicks on Login button
Then User should get successfully logged in
When User enters valid product "iPhone" into Search box field
And User clicks on Search button
Then User should get valid product displayed page in search results
When user clicks on add to Wishlist button
Then user should get proper success message for wish list
And user clicks on wishlist cart menu
Then added product should be present inside My wishlist



#@removed
#Scenario: verify show number of products listbox
#Given User opens the Application
#When User enters valid product "iPhone" into Search box field
#And User clicks on Search button
#Then User should get valid product displayed page in search results
#Then user should get 15 products selected by default in show listbox


#Scenario: verify Sort by style in search result page
#Given User opens the Application
#When User enters valid product "iPhone" into Search box field
#And User clicks on Search button
#Then User should get valid product displayed page in search results
#Then user should get Default option selected by default


#Scenario: verify show number of products listbox
#Given User opens the Application
#When User enters valid product "iPhone" into Search box field
#And User clicks on Search button
#Then User should get valid product displayed page in search results
#Then user should get 15 products selected by default in show listbox