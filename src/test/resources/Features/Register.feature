Feature: Registration functionality

@ok
Scenario: User creates an account only with mandatory fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName	|Arun												|
|lastName		|Motoori										|
|telephone	|1234567890									|
|password		|12345											|
When user enters new valid email into the email field
And User selects Privacy Policy
And User clicks on Continue button
Then User account should get created successfully

@ok
Scenario: User creates an account with all fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName	|Arun												|
|lastName		|Motoori										|
|telephone	|1234567890									|
|password		|12345											|
When user enters new valid email into the email field
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button
Then User account should get created successfully

@ok @negative
Scenario: User creates a duplicate account
Given User navigates to Register Account page
When User enters the details into below fields with duplicate email
|firstName	|Arun												|
|lastName		|Motoori										|
|email			|amotooricap1@gmail.com			|
|telephone	|1234567890									|
|password		|12345											|
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button
Then User should get a proper warning about duplicate email

@ok @negative
Scenario: User creates an account without filling any details
Given User navigates to Register Account page
When User dont enter any details into fields
And User clicks on Continue button
Then User should get proper warning messages for every mandatory field

# newly added scenarios ----------------------------------------------------------------

@ok @negative
Scenario: Validate Registering an Account by providing an invalid email address into the E-Mail field
Given User navigates to Register Account page
When User enters the details into below fields for invalid email
|firstName	|Arun												|
|lastName		|Motoori										|
|telephone	|1234567890									|
|password		|12345											|
And user enters invalid email as "jkasb#d2$13@bfh%g.cOm" in email field
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button
Then User should not get Successfully create account page

@bug @negative
Scenario: Validate Registering an Account by providing an invalid phone number
Given User navigates to Register Account page
When User enters the details into below fields for invalid phone number
|firstName	|Arun												|
|lastName		|Motoori										|
|password		|12345											|
When user enters new valid email into the email field
And user enters invalid phone as "13269761485687546" in phone field
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button
Then User account should not be created


@ok
Scenario: Validate all the fields in the Register Account page have the proper placeholders
Given User navigates to Register Account page
Then user should get proper placeholders for all the text fileds


@ok @negative
Scenario: Validate whether the Mandatory fields in the Register Account page are accepting only spaces
Given User navigates to Register Account page
When User enters the space into all fields
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button
Then User should get proper warning messages for every mandatory field

@bug @negative
Scenario: Validate whether the Password fields in the Register Account page are following Password Complexity Standards
Given User navigates to Register Account page
When User enters the details into below fields
|firstName	|Arun												|
|lastName		|Motoori										|
|telephone	|1234567890									|
|password		|12345											|
When user enters new valid email into the email field
And User selects Privacy Policy
And User clicks on Continue button
Then user should not get Account success page, instead of should get warning message about Password complexcity standards

@ok1
Scenario: Validate whether the leading and trailing spaces entered into the Register Account fields are trimmed
Given User navigates to Register Account page
When User enters the details into below fields
|firstName	| Arun 												|
|lastName		| Motoori  										|
|telephone	| 1234567890  								|
|password		|12345												|
When user enters new valid email into the email field
And User selects Privacy Policy
And User clicks on Continue button
Then User account should get created successfully

@ok
Scenario: Validate whether the Privacy Policy checkbox option is not selected by default
Given User navigates to Register Account page
Then user should get unselected Privacy Policy Checkbox by default

@bug
Scenario: Validate whether the Newsletter checkbox is selected by default
Given User navigates to Register Account page
Then user should get by defaulted selected Newsletter checkbox

@ok
Scenario: Validate Registering the Account without selecting the Privacy Policy checkbox option
Given User navigates to Register Account page
When User enters the details into below fields
|firstName	|Arun												|
|lastName		|Motoori										|
|telephone	|1234567890									|
|password		|12345											|
When user enters new valid email into the email field
And User clicks on Continue button
Then User should get a proper warning message related to privacy policy

@ok
Scenario: Validate navigating to other pages using the options or links provided on the Register Account page
Given User navigates to Register Account page
When user clicks on Login link
Then user should navigates to the Login page
When user clicks on browser back button
When user clicks on Phones module
Then user should navigates to Phones page

@ok @negative
Scenario: Validate Registring an Account, by filling Password field and not filling Password Confirm field
Given User navigates to Register Account page
When User enters the details into below fields except confirm password filed
|firstName|Arun|
|lastName|Motoori|
|telephone|1234567890|
|password|12345|
And user do not enters password into confirm password field
When user enters new valid email into the email field
And User selects Privacy Policy
And User clicks on Continue button
Then User should get proper warning message about confirm password field


#@abc
#Scenario: Validate all the mandatory fields in the Register Account page are marked with red color * symbol
#Given User navigates to Register Account page
#Then should get all the mandatory fileds along with * symbol