Feature: Login functionality

@DDT
Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid email address <username> into email field by DDT
And User enters valid password <password> into password field by DDT
And User clicks on Login button
Then User should get successfully logged in
Examples:
|username								|password	|
| gfahwghwg@gmail.com 	|12345 		|
|amotooricap3@gmail.com	|12345		|

@nagatives
Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address into email field
And User enters invalid password "1234567890" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

@nagative
Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address "amotooricap1@gmail.com" into email field
And User enters invalid password "1234567890" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

@nagative
Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters invalid email address into email field
And User enters valid password "12345" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

@nagative
Scenario: Login without providing any credentails
Given User navigates to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch 

Scenario: Validate Forgotten Password link is available in the Login page and is working
Given User navigates to login page
And user should get Forgotten Password link is available on loginpage
When user clicks on Forgotten Password link
Then user should taken to Forgotten Password Page

Scenario: Validate E-Mail Address and Password text fields in the Login page have the placeholder text
Given User navigates to login page
Then user should get proper placeholders for E-Mail Address and Password text fields 

@gggg
Scenario: Validate Logging into the Application and browsing back using Browser back button
Given User navigates to login page
When User enters valid email address "amotooricap1@gmail.com" into email field
And User enters valid password "12345" into password field
And User clicks on Login button
Then User should get successfully logged in
When user clicks on browser back button
And user clicks on browser forward button
Then User should get successfully logged in

@negative @bug
Scenario: Validate Loggingout from the Application and browsing back using Browser back button
Given User navigates to login page
When User enters valid email address "amotooricap1@gmail.com" into email field
And User enters valid password "12345" into password field
And User clicks on Login button
Then User should get successfully logged in
When user clicks on logout link
When user clicks on browser back button
Then user should not get loggedin again


Scenario: Validate Logging into the Application, closing the Browser without loggingout and opening the application in the Browser again
Given User navigates to login page
When User enters valid email address "amotooricap1@gmail.com" into email field
And User enters valid password "12345" into password field
And User clicks on Login button
And user closes the browser without logging out his account
When user again natigates to url
Then User should get successfully logged in

@smoke121
Scenario: Validate user is able to navigate to different pages from Login page
Given User navigates to login page
When user clicks on Phones module
Then user should navigates to Phones page
When user clicks on browser back button
And user clicks on Register link
Then user should navigates to Register account page
When user clicks on browser back button
When user clicks on Cameras module
Then user should navigates Cameras page

