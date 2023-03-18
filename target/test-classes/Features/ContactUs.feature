Feature: Contact Us functionality

Scenario: Validate navigating to Contact Us page from Header options
Given User opens the Application
When user Clicks on Phone icon option from the header options
Then user should navigates to Contact Us page


Scenario: Validate navigating to Contact Us page from Footer options
Given User opens the Application
When user clicks on Contact us link from Footer options
Then user should navigates to Contact Us page


Scenario: Validate whether the required details and fields are displayed in the Contact Us page
Given User opens the Application
When user Clicks on Phone icon option from the header options
Then user should navigates to Contact Us page
Then user should get required details and fields are proper displayed in the Contact Us page


Scenario: Validate all the text fields in the Contact Us page are mandatory
Given User opens the Application
When user Clicks on Phone icon option from the header options
Then user should navigates to Contact Us page
Then user should get all the text fields of contact us page are mandetory

@bug
Scenario: Validate submitting the Contact Form in Contact Us page by providing all the details but without logging In
Given User opens the Application
When user Clicks on Phone icon option from the header options
Then user should navigates to Contact Us page
When user enters valid description in related field
And clicks on submit button of contact us page
Then user should navigates to login page

#@bug @recheck
#Scenario: Validate submitting the Contact Form in Contact Us page by providing all the details with logging In with valid credentials
#Given User navigates to login page
#When User enters valid email address "amotooricap1@gmail.com" into email field
#And User enters valid password "12345" into password field
#And User clicks on Login button
#Then User should get successfully logged in
#When user Clicks on Phone icon option from the header options
#Then user should get name as "Arun" and email fields "amotooricap1@gmail.com" are by default entered with a valid name and email
#When user enters valid description in related field
#And clicks on submit button of contact us page
#Then user should get successful enquirey sent message


Scenario: Validate submitting the Contact Form in Contact Us page by not providing any details
Given User opens the Application
When user clicks on Contact us link from Footer options
Then user should navigates to Contact Us page
And user dont enter anything in all the fields
And clicks on submit button of contact us page
Then user should get warning messages for all the fields

@bug
Scenario: Validate entering invalid email address into the E-Mail Address field and submit the form
Given User opens the Application
When user clicks on Contact us link from Footer options
Then user should navigates to Contact Us page
When user enters invalid email along with other details
And clicks on submit button of contact us page
Then request should not send instead of Confirm with OTP notification should come


Scenario: Validate the Breadcrumb of Contact Us page
Given User opens the Application
When user clicks on Contact us link from Footer options
Then user should navigates to Contact Us page
Then user should get proper breadcrum for page

Scenario: Validate the Page URL, Page Heading and Page Title of Contact Us page
Given User opens the Application
When user clicks on Contact us link from Footer options
Then user should navigates to Contact Us page
Then user should get proper page title, Page Heading and Page Title of contact us page
